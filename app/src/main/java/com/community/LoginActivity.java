package com.community;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.community.entity.LoginBean;
import com.easylib.base.BaseActivity;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ToastUtils;
import com.lzy.okhttputils.request.BaseRequest;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity {
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
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

    @OnClick(R.id.btn_login)
    public void onClick() {
        doLogin();
    }

    private void doLogin() {
        if (isCorrectInput()) {
            HttpUtils.getInstance().login(name, pwd, new ResultCallback<LoginBean>() {
                @Override
                public void onAfter(@Nullable LoginBean loginBean, @Nullable Exception e) {
                    dismissDialog();
                }

                @Override
                public void onCacheSuccess(LoginBean loginBean, Call call) {

                }

                @Override
                public void onBefored(BaseRequest request) {
                    showDialog();
                }

                @Override
                public void onErrored(Call call, Response response, Exception e) {
                    ToastUtils.showToast("异常情况");
                }

                @Override
                public void onSuccess(LoginBean loginBean, Call call, Response response) {
                    if (loginBean != null && loginBean.getCode() == 200) {
                        EasySP.getInstance().saveUserInfo(loginBean);
                        ToastUtils.showToast("登录成功");
                        startActivity(new Intent(mContext, MainActivity.class));
                    }
                }
            });
        }
    }

    String name, pwd;

    private boolean isCorrectInput() {
        name = etUsername.getText().toString().toLowerCase().trim();
        pwd = etPassword.getText().toString().toLowerCase().trim();
        if (TextUtils.isEmpty(name)) {
            etUsername.setError("用户名不能为空");
            return false;
        }
        if (TextUtils.isEmpty(pwd)) {
            etPassword.setError("密码不能为空");
            return false;
        }
        if (pwd.length() < 4) {
            etPassword.setError("密码长度不足4位");
            return false;
        }
        return true;
    }
}
