package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.community.entity.ActivitiesBean;
import com.easylib.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 社团活动
 */
public class ClubEventsActivity extends BaseActivity {

    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.title)
    RelativeLayout title;
    ActivitiesBean.DataBean.ActivityPageBean.ContentBean bean;

    @Override
    public int getContentViewId() {
        return R.layout.activity_club_events;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {
        bean= (ActivitiesBean.DataBean.ActivityPageBean.ContentBean) getIntent().getSerializableExtra("event");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        tvName.setText(bean.getCommunityName());
        tvContent.setText(bean.getContent());
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
