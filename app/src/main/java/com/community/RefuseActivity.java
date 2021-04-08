package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.community.entity.RefusedBean;
import com.easylib.base.BaseActivity;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ToastUtils;
import com.lzy.okhttputils.request.BaseRequest;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

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
                submit();
                break;
        }
    }

    private void submit() {
        HttpUtils.getInstance().refused(EasySP.getInstance().loadJoinInfo().getData().getId(),
                etContent.getText().toString().trim(), new ResultCallback<RefusedBean>() {
                    @Override
                    public void onAfter(@Nullable RefusedBean refusedBean, @Nullable Exception e) {
                        dismissDialog();
                    }

                    @Override
                    public void onCacheSuccess(RefusedBean refusedBean, Call call) {

                    }

                    @Override
                    public void onBefored(BaseRequest request) {
                        showDialog();
                    }

                    @Override
                    public void onErrored(Call call, Response response, Exception e) {

                    }

                    @Override
                    public void onSuccess(RefusedBean refusedBean, Call call, Response response) {
                        if (refusedBean != null) {
                            ToastUtils.showToast("已拒绝");
                            setResult(RESULT_OK, new Intent(mContext, JoinClubActivity.class));
                            finish();
                        }
                    }
                });
    }
}
