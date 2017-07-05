package com.mumu.easyemoji.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mumu.easyemoji.R;

/**
 * Created by MuMu on 2016/11/11/0011.
 */

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mToolBar.setTitle("EasyEmoJi");
        mToolBar.setTitleTextColor(getResources().getColor(R.color.white));

        mContext = this;
    }

    /*
     * 单组表情
     */
    public void openWeiXinChat(View view) {
        startActivity(new Intent(mContext, SingleEmotionActivity.class));
    }

    /*
     * 多组表情
     */
    public void openQQChat(View view) {
        startActivity(new Intent(mContext, MultiEmotionActivity.class));
    }
}
