package com.community;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easylib.base.BaseActivity;
import com.easylib.utils.ImageLoadUtils;
import com.guyj.img.EasyImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MemberInfoActivity extends BaseActivity {

    @Bind(R.id.tv_cancel)
    TextView tvCancel;
    @Bind(R.id.iv_head)
    EasyImageView ivHead;
    @Bind(R.id.et_nickname)
    EditText etNickname;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_sex)
    EditText etSex;
    @Bind(R.id.et_age)
    EditText etAge;
    @Bind(R.id.et_grade)
    EditText etGrade;
    @Bind(R.id.et_studentid)
    EditText etStudentid;
    @Bind(R.id.et_college)
    EditText etCollege;
    @Bind(R.id.cb1)
    CheckBox cb1;
    @Bind(R.id.cb2)
    CheckBox cb2;
    @Bind(R.id.cb3)
    CheckBox cb3;
    @Bind(R.id.et_hometown)
    EditText etHometown;
    @Bind(R.id.et_contact)
    EditText etContact;
    @Bind(R.id.et_sign)
    EditText etSign;
    @Bind(R.id.activity_edit)
    LinearLayout activityEdit;
    private String url, nickname, name, sex, age, grade, studentid, college, home, phone, sign;

    @Override
    public int getContentViewId() {
        return R.layout.activity_member_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {
        url = getIntent().getStringExtra("1");
        nickname = getIntent().getStringExtra("2");
        name = getIntent().getStringExtra("3");
        sex = getIntent().getStringExtra("4");
        age = getIntent().getIntExtra("5", 0) + "";
        grade = getIntent().getStringExtra("6");
        studentid = getIntent().getStringExtra("7");
        college = getIntent().getStringExtra("8");
        home = getIntent().getStringExtra("9");
        phone = getIntent().getStringExtra("10");
        sign = getIntent().getStringExtra("11");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        ImageLoadUtils.into(url, ivHead);
        etNickname.setText(nickname);
        etName.setText(name);
        etSex.setText(sex);
        etAge.setText(age);
        etGrade.setText(grade);
        etStudentid.setText(studentid);
        etCollege.setText(college);
        etHometown.setText(home);
        etContact.setText(phone);
        etSign.setText(sign);

    }

    @OnClick(R.id.tv_cancel)
    public void onClick() {
        finish();
    }
}
