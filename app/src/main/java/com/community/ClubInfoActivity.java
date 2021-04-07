package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easylib.base.BaseActivity;
import com.guyj.img.EasyImageView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 社团介绍
 */
public class ClubInfoActivity extends BaseActivity {

    @Bind(R.id.title)
    RelativeLayout title;
    @Bind(R.id.iv_photo)
    EasyImageView ivPhoto;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_jibie)
    TextView tvJibie;
    @Bind(R.id.tv_xueyuan)
    TextView tvXueyuan;
    @Bind(R.id.tv_leixing)
    TextView tvLeixing;
    @Bind(R.id.tv_jianjie)
    TextView tvJianjie;

    @Override
    public int getContentViewId() {
        return R.layout.activity_club_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @OnClick({R.id.tv_back, R.id.tv_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_submit:
                startActivity(new Intent(mContext,JoinClubActivity.class));
                break;
        }
    }
}
