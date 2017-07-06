package com.mumu.easyemoji.other;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.mumu.easyemoji.view.ExpandGridView;
import com.mumu.easyemoji.R;
import com.mumu.easyemoji.adapter.ExpressAdapter;
import com.mumu.easyemoji.utils.EmoJiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2016/10/28.
 * 表情包帮助类
 */

public class EmoJiHelper {

    private Context mContext;
    private EditText et_input_container;
    private static int EMOJI_PAGE_COUNT = 20;
    private int mPageNum;
    private List<String> emojiResList;
    private int type;

    public EmoJiHelper(int type, Context mContext, EditText et_input) {
        this.mContext = mContext;
        this.et_input_container = et_input;
        this.type = type;
        this.emojiResList = EmoJiUtils.getResTitleList(type);
        getPagerViews();
    }

    /*
     * 所有表情的视图（多页表情的view）
     */
    public List<View> getPagerViews() {
        List<View> pageViewList = new ArrayList<>();
        //每一页表情的view
        mPageNum = (int) Math.ceil(emojiResList.size() * 1.0f / EMOJI_PAGE_COUNT);
        for (int position = 1; position <= mPageNum; position++) {
            pageViewList.add(getGridView(position));
        }
        return pageViewList;
    }

    /*
     * 获取每页的表情视图（同一个表情包内）
     */
    public View getGridView(int position) {
        List mEmoJiList = new ArrayList<>();
        View containerView = View.inflate(mContext, R.layout.container_gridview, null);
        ExpandGridView eg_gridView = (ExpandGridView) containerView.findViewById(R.id.eg_gridView);
        eg_gridView.setGravity(Gravity.CENTER_VERTICAL);
        List<String> emojiPageList = null;
        if (position == mPageNum)//最后一页
            emojiPageList = emojiResList.subList((position - 1) * EMOJI_PAGE_COUNT, emojiResList.size());
        else
            emojiPageList = emojiResList.subList((position - 1) * EMOJI_PAGE_COUNT, EMOJI_PAGE_COUNT * position);
            mEmoJiList.addAll(emojiPageList); // 添加表情 View
            mEmoJiList.add("[删除]"); // 每页最后一个都是删除键

        /*
         * 视图展现的形式
         */
        final ExpressAdapter mExpressAdapter = new ExpressAdapter(type, mContext, position, mEmoJiList);
        eg_gridView.setAdapter(mExpressAdapter);

        /*
         * 点击每个表情
         */
        eg_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionIndex, long id) {
                String titleName = mExpressAdapter.getItem(positionIndex); // 获取到表情标题
                if ( !"[删除]".equals(titleName)) { // 不是删除键，显示表情
                    showEmoJi(titleName);
                } else { // 删除文字或者表情
                    deleteContent();
                }
            }
        });
        return containerView;
    }

    /**
     * 显示EmoJi表情,关键是解析表情
     */
    private void showEmoJi(String titleName) {

        int selectionStart = et_input_container.getSelectionStart();

         // 第一次点击body是 "",
        String body = et_input_container.getText().toString(); // 这个东西是什么
        Log.e("body",body); // [悲催][坚持住][好喜欢][泪流满面][泪流满面][泪流满面]
        StringBuilder stringBuilder = new StringBuilder(body);
        stringBuilder.insert(selectionStart, titleName); // 每点击一次，stringBuilder 加上后面的表情标题
        Log.e("stringBuilder",stringBuilder.toString()); // stringBuilder: [好囧][不好意思][好囧][抠鼻屎]

         // 根据EditText的内容，解析表情，解析出来的是图片
        SpannableString spannableString = EmoJiUtils.parseEmoJi(type, mContext, stringBuilder.toString());
        Log.e("spannableString",spannableString.toString()); // spannableString: [好囧][不好意思][好囧][抠鼻屎]
        et_input_container.setText(spannableString);

        et_input_container.setSelection(selectionStart + titleName.length());
    }

    /**
     * 删除表情或文字
     */
    private void deleteContent() {
        if (!TextUtils.isEmpty(et_input_container.getText())) {
            int selectionStart = et_input_container.getSelectionStart();//获取光标位置
            if (selectionStart > 0) {
                String body = et_input_container.getText().toString();
                String lastStr = body.substring(selectionStart - 1, selectionStart);//获取最后一个字符
                if (lastStr.equals("]")) {//表情
                    if (selectionStart < body.length()) {//从中间进行删除
                        body = body.substring(0, selectionStart); // 把光标后面的东西全部暂时忽略掉，方便后面删除
                    }
                    int lastIndexOf = body.lastIndexOf("["); // 获取到最后一个表情
                    if (lastIndexOf != -1) {
                        String tempStr = body.substring(lastIndexOf, selectionStart);//截取表情码
                        if (EmoJiUtils.getAllResList().contains(tempStr)) {//校验是否是表情
                            et_input_container.getEditableText().delete(lastIndexOf, selectionStart);//删除表情
                        } else {
                            et_input_container.getEditableText().delete(selectionStart - 1, selectionStart);//删除一个字符
                        }
                    } else {
                        et_input_container.getEditableText().delete(selectionStart - 1, selectionStart);//删除一个字符
                    }
                } else {//非表情
                    et_input_container.getEditableText().delete(selectionStart - 1, selectionStart);//删除一个字符
                }
            }
        }
    }
}
