package com.community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.community.entity.LabelBean;
import com.community.entity.LoginBean;
import com.easylib.base.BaseActivity;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ImageLoadUtils;
import com.easylib.utils.ImagePickUtils;
import com.easylib.utils.ToastUtils;
import com.guyj.img.EasyImageView;
import com.lzy.okhttputils.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 编辑资料
 */
public class EditActivity extends BaseActivity {

    @Bind(R.id.tv_cancel)
    TextView tvCancel;
    @Bind(R.id.tv_submit)
    TextView tvSubmit;
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
    LoginBean userInfo;
    List<LabelBean.DataBean> labels;

    @Override
    public int getContentViewId() {
        return R.layout.activity_edit;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {
        labels = new ArrayList<>();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        getAllLabel();
        userInfo = EasySP.getInstance().loadUserInfo();
        ImageLoadUtils.into(userInfo.getData().getHeadPortrait(), ivHead);
        etNickname.setText(userInfo.getData().getNickname());
        etName.setText(userInfo.getData().getRealname());
        etSex.setText(userInfo.getData().getGender());
        etAge.setText(userInfo.getData().getAge() + "");
        etGrade.setText(userInfo.getData().getGrade());
        etStudentid.setText(userInfo.getData().getStudentId());
        etCollege.setText(userInfo.getData().getProfessionId());
        //标签

        etHometown.setText(userInfo.getData().getHome());
        etContact.setText(userInfo.getData().getPhone());
        etSign.setText(userInfo.getData().getSignature());

    }

    @OnClick({R.id.tv_cancel, R.id.tv_submit, R.id.iv_head})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.tv_submit:
                ToastUtils.showToast("修改成功");
                finish();
                break;
            case R.id.iv_head:
                ImagePickUtils.openImagePick(1, new ImagePickUtils.ImagePickListener() {
                    @Override
                    public void onHanlderSuccess(int requestCode, List<PhotoInfo> resultList) {
                        ImageLoadUtils.intoForImagePicker(resultList.get(0).getPhotoPath(), ivHead);
                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                break;
        }
    }

    private void getAllLabel() {
        HttpUtils.getInstance().label(new ResultCallback<LabelBean>() {
            @Override
            public void onAfter(@Nullable LabelBean labelBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(LabelBean labelBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(LabelBean labelBean, Call call, Response response) {
                if (labelBean != null && labelBean.getCode() == 200) {
                    labels.addAll(labelBean.getData());
                }
            }
        });
    }
}
