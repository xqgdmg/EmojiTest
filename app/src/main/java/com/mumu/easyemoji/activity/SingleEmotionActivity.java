package com.mumu.easyemoji.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mumu.easyemoji.other.CircleIndicator;
import com.mumu.easyemoji.other.EmoJiHelper;
import com.mumu.easyemoji.other.EmotionInputDetector;
import com.mumu.easyemoji.adapter.EmoJiContainerAdapter;
import com.mumu.easyemoji.utils.KeyBoardUtils;
import com.mumu.easyemoji.R;

/**
 * 单组表情
 */

public class SingleEmotionActivity extends AppCompatActivity {

    private CheckBox mCbEmoJiView;
    private EditText mEtInputContainer;
    private LinearLayout mLlEmoJiContainer;
    private ListView mLvChatContent;
    private EmotionInputDetector mDetector;
    private CircleIndicator mCircleIndicator;


    private Context mContext;
    private Button mBtnSendButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_single);
        mContext = this;

        initView();
    }

    private void initView() {
        mLvChatContent = (ListView) findViewById(R.id.listView_Content);
        mCbEmoJiView = (CheckBox) findViewById(R.id.cb_smile);
        mEtInputContainer = (EditText) findViewById(R.id.et_input_container);
        mLlEmoJiContainer = (LinearLayout) findViewById(R.id.ll_face_container);
        mBtnSendButton = (Button) findViewById(R.id.btn_send);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circleIndicator);

         // 绑定
        mDetector = EmotionInputDetector.with(this) // 初始化
                .bindSendButton(mBtnSendButton) // 发送按钮
                .bindToEditText(mEtInputContainer) // 消息输入框
                .setEmotionView(mLlEmoJiContainer) // 表情 ViewPager 上层的 LinearLayout
                .bindToContent(mLvChatContent) // 聊天消息 lv
                .bindToEmotionButton(mCbEmoJiView); // 表情按钮

        EmoJiHelper emojiHelper = new EmoJiHelper(1, mContext, mEtInputContainer);
        EmoJiContainerAdapter mAdapter = new EmoJiContainerAdapter(emojiHelper.getPagers());
        viewPager.setAdapter(mAdapter);
        mCircleIndicator.setViewPager(viewPager);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        KeyBoardUtils.toggleInput(mContext); // 这个没有什么意义？
//    }

    /*
     * 拦截返回键，收起键盘
     */
    @Override
    public void onBackPressed() {
        if (!mDetector.interceptBackPress()) {
            super.onBackPressed();
        }
    }
}
