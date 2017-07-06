package com.mumu.easyemoji.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.mumu.easyemoji.R;
import com.mumu.easyemoji.utils.EmoJiUtils;

import java.util.List;

/**
 * Created by lq on 16/10/11.
 * ArrayAdapter 单个表情
 * 展示每一个表情 ImageView
 */

public class ExpressAdapter extends ArrayAdapter<String> {


    private int type = 0;

    public ExpressAdapter(int type, Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.type = type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_row_emoji, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_emoji);

         // 获取图片的路径
        String fileName = getItem(position);
        Integer resId = EmoJiUtils.getEmoJiMap(type).get(fileName);

        if (resId != null) {
            Drawable drawable = getContext().getResources().getDrawable(resId);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 2, drawable.getIntrinsicHeight() / 2);
            imageView.setImageResource(resId);
        }

        return convertView;
    }
}
