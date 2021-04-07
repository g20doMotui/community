package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easylib.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 社团活动
 */
public class ClubEventsActivity extends BaseActivity {

    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.title)
    RelativeLayout title;

    @Override
    public int getContentViewId() {
        return R.layout.activity_club_events;
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

    @OnClick({R.id.tv_back, R.id.tv_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_list:
                startActivity(new Intent(mContext,MemberListActivity.class));
                break;
        }
    }
}
