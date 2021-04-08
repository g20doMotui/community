package com.community;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.easylib.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 成员列表
 */
public class MemberListActivity extends BaseActivity {

    @Bind(R.id.title)
    RelativeLayout title;

    @Override
    public int getContentViewId() {
        return R.layout.activity_member_list;
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


    @OnClick(R.id.tv_back)
    public void onClick() {
        finish();
    }
}
