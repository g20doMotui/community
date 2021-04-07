package com.community;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.community.entity.ClubBean;
import com.community.entity.CommunitiesBean;
import com.easylib.base.BaseActivity;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ImageLoadUtils;
import com.guyj.img.EasyImageView;
import com.lzy.okhttputils.request.BaseRequest;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 社团介绍
 */
public class ClubInfoActivity extends BaseActivity {

    @Bind(R.id.title)
    RelativeLayout title;
    @Bind(R.id.iv_photo)
    EasyImageView ivPhoto;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_jibie)
    TextView tvJibie;
    @Bind(R.id.tv_xueyuan)
    TextView tvXueyuan;
    @Bind(R.id.tv_leixing)
    TextView tvLeixing;
    @Bind(R.id.tv_jianjie)
    TextView tvJianjie;
    String clubid;
    ClubBean.DataBean.CommunityBean bean;
    @Override
    public int getContentViewId() {
        return R.layout.activity_club_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {
        clubid = getIntent().getStringExtra("clubId");
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        getClubInfo();


    }

    private void getClubInfo() {
        HttpUtils.getInstance().communitiesinfo(clubid, new ResultCallback<ClubBean>() {
            @Override
            public void onAfter(@Nullable ClubBean clubBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(ClubBean clubBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(ClubBean clubBean, Call call, Response response) {
                if (clubBean != null && clubBean.getCode() == 200) {
                    bean = clubBean.getData().getCommunity();
                    ImageLoadUtils.into(bean.getEmblemUrl(), ivPhoto);
                    tvName.setText("社团：" + bean.getName());
                    tvJibie.setText("级别：" + bean.getLevelId());
                    tvXueyuan.setText("学院：" + bean.getProfessionId());
                    tvLeixing.setText("类型：" + bean.getTypeId());
                    tvJianjie.setText("简介：" + bean.getIntroduction());
                }
            }
        });
    }

    @OnClick({R.id.tv_back, R.id.tv_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_submit:
                startActivity(new Intent(mContext,JoinClubActivity.class));
                break;
        }
    }
}
