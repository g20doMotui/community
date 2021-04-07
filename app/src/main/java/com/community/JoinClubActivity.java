package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.easylib.base.BaseActivity;
import com.guyj.img.EasyImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * XX申请加入
 */
public class JoinClubActivity extends BaseActivity {

    @Bind(R.id.iv_head)
    EasyImageView ivHead;
    @Bind(R.id.tv_nickname)
    TextView tvNickname;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.tv_grade)
    TextView tvGrade;
    @Bind(R.id.tv_studentid)
    TextView tvStudentid;
    @Bind(R.id.tv_college)
    TextView tvCollege;
    @Bind(R.id.cb1)
    CheckBox cb1;
    @Bind(R.id.cb2)
    CheckBox cb2;
    @Bind(R.id.cb3)
    CheckBox cb3;
    @Bind(R.id.tv_hometown)
    TextView tvHometown;
    @Bind(R.id.tv_contact)
    TextView tvContact;
    @Bind(R.id.tv_sign)
    TextView tvSign;

    @Override
    public int getContentViewId() {
        return R.layout.activity_join_club;
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

    @OnClick({R.id.tv_cancel, R.id.tv_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel://拒绝
                startActivity(new Intent(mContext,RefuseActivity.class));
                break;
            case R.id.tv_submit://同意
                finish();
                break;
        }
    }
}
