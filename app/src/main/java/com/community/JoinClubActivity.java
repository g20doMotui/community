package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.community.entity.ListBean;
import com.community.entity.ThroughBean;
import com.community.entity.UserInfoBean;
import com.easylib.base.BaseActivity;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ImageLoadUtils;
import com.easylib.utils.ToastUtils;
import com.guyj.img.EasyImageView;
import com.lzy.okhttputils.request.BaseRequest;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

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
    ListBean.DataBean bean;

    @Override
    public int getContentViewId() {
        return R.layout.activity_join_club;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {
        bean = EasySP.getInstance().loadJoinInfo().getData();

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        stopService(MyApp.serviceIntent);
        getUserInfo();
    }

    private void getUserInfo() {
        HttpUtils.getInstance().userinfo(bean.getMemberId(), new ResultCallback<UserInfoBean>() {
            @Override
            public void onAfter(@Nullable UserInfoBean userInfoBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(UserInfoBean userInfoBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(UserInfoBean userInfoBean, Call call, Response response) {
                if (userInfoBean != null && userInfoBean.getCode() == 200) {
                    ImageLoadUtils.into(userInfoBean.getData().getHeadPortrait(), ivHead);
                    tvNickname.setText("昵称：" + userInfoBean.getData().getNickname());
                    tvName.setText("姓名：" + userInfoBean.getData().getRealname());
                    tvAge.setText("年龄：" + userInfoBean.getData().getAge());
                    tvCollege.setText("专业/学院：" + userInfoBean.getData().getProfessionId());
                    tvContact.setText("联系方式：" + userInfoBean.getData().getPhone());
                    tvGrade.setText("年级：" + userInfoBean.getData().getGrade());
                    tvHometown.setText("故乡：" + userInfoBean.getData().getHome());
                    tvSex.setText("性别：" + userInfoBean.getData().getGender());
                    tvSign.setText("个性签名：" + userInfoBean.getData().getSignature());
                    tvStudentid.setText("学号：" + userInfoBean.getData().getStudentId());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService(MyApp.serviceIntent);
    }

    @OnClick({R.id.tv_cancel, R.id.tv_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel://拒绝
                startActivityForResult(new Intent(mContext, RefuseActivity.class), 0x01);
                break;
            case R.id.tv_submit://同意
                Through();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x01) {
            finish();
        }
    }

    private void Through() {
        HttpUtils.getInstance().through(bean.getId(), new ResultCallback<ThroughBean>() {
            @Override
            public void onAfter(@Nullable ThroughBean throughBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(ThroughBean throughBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(ThroughBean throughBean, Call call, Response response) {
                if (throughBean != null) {
                    ToastUtils.showToast("已通过");
                    finish();
                }
            }
        });
    }
}
