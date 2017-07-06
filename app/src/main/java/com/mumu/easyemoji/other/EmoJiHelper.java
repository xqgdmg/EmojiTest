package com.mumu.easyemoji.other;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.mumu.easyemoji.view.ExpandGridView;
import com.mumu.easyemoji.R;
import com.mumu.easyemoji.adapter.EmoJiAdapter;
import com.mumu.easyemoji.utils.EmoJiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2016/10/28.
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
        getPagers();
    }

    public List<View> getPagers() {
        List<View> pageViewList = new ArrayList<>();
        //每一页表情的view
        mPageNum = (int) Math.ceil(emojiResList.size() * 1.0f / EMOJI_PAGE_COUNT);
        for (int position = 1; position <= mPageNum; position++) {
            pageViewList.add(getGridView(position));
        }
        return pageViewList;
    }

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
        mEmoJiList.addAll(emojiPageList);
        mEmoJiList.add("[删除]");

        final EmoJiAdapter mEmoJiAdapter = new EmoJiAdapter(type, mContext, position, mEmoJiList);
        eg_gridView.setAdapter(mEmoJiAdapter);
        eg_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionIndex, long id) {
                String titleName = mEmoJiAdapter.getItem(positionIndex); // 获取到表情标题
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
     * 显示EmoJi表情
     *
     * @param fileName
     */
    private void showEmoJi(String fileName) {
        int selectionStart = et_input_container.getSelectionStart();

        String body = et_input_container.getText().toString();
        StringBuilder stringBuilder = new StringBuilder(body);
        stringBuilder.insert(selectionStart, fileName);

        et_input_container.setText(
                EmoJiUtils.parseEmoJi(type, mContext, stringBuilder.toString())
        );
        et_input_container.setSelection(selectionStart + fileName.length());
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
