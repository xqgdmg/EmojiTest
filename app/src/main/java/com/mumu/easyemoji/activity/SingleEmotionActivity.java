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

    private CheckBox mEmoJiView;
    private EditText mInputContainer;
    private LinearLayout mEmoJiContainer;
    private ListView mChatContent;
    private EmotionInputDetector mDetector;
    private CircleIndicator mCircleIndicator;


    private Context mContext;
    private Button mSendButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin_chat);
        mContext = this;

        initView();
    }

    private void initView() {
        mChatContent = (ListView) findViewById(R.id.listView_Content);
        mEmoJiView = (CheckBox) findViewById(R.id.cb_smile);
        mInputContainer = (EditText) findViewById(R.id.et_input_container);
        mEmoJiContainer = (LinearLayout) findViewById(R.id.ll_face_container);
        mSendButton = (Button) findViewById(R.id.btn_send);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circleIndicator);

        mDetector = EmotionInputDetector.with(this)
                .bindSendButton(mSendButton)
                .bindToEditText(mInputContainer)
                .setEmotionView(mEmoJiContainer)
                .bindToContent(mChatContent)
                .bindToEmotionButton(mEmoJiView);

        EmoJiHelper emojiHelper = new EmoJiHelper(1, mContext, mInputContainer);
        EmoJiContainerAdapter mAdapter = new EmoJiContainerAdapter(emojiHelper.getPagers());
        viewPager.setAdapter(mAdapter);
        mCircleIndicator.setViewPager(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        KeyBoardUtils.toggleInput(mContext);
    }


    @Override
    public void onBackPressed() {
        if (!mDetector.interceptBackPress()) {
            super.onBackPressed();
        }
    }
}
