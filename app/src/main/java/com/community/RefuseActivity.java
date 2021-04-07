package com.community;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.easylib.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 拒绝申请
 */
public class RefuseActivity extends BaseActivity {

    @Bind(R.id.title)
    RelativeLayout title;
    @Bind(R.id.et_content)
    EditText etContent;

    @Override
    public int getContentViewId() {
        return R.layout.activity_refuse;
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

                break;
        }
    }
}
