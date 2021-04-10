package com.community;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.community.entity.ActivitiesBean;
import com.community.entity.LabelBean;
import com.community.entity.MyClub;
import com.easylib.base.BaseFragment;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ImageLoadUtils;
import com.easylib.utils.LogUtils;
import com.easylib.utils.ToastUtils;
import com.easylib.views.DividerItemDecoration;
import com.guyj.CommonAdapter;
import com.guyj.base.ViewHolder;
import com.guyj.img.EasyImageView;
import com.lzy.okhttputils.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 我的社团 列表页
 */
public class MyClubFragment extends BaseFragment {

    @Bind(R.id.iv_head)
    EasyImageView iv_head;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    LinearLayoutManager llm;
    CommonAdapter adapter;
    List<MyClub.DataBean.CommunityListBean> datas;

    public MyClubFragment() {
        // Required empty public constructor
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_my_club;
    }

    @Override
    protected void initVariable() {
        datas=new ArrayList<>();
        llm=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        adapter=new CommonAdapter<MyClub.DataBean.CommunityListBean>(mContext,R.layout.item_my_club,datas) {
            @Override
            protected void convert(ViewHolder viewHolder, MyClub.DataBean.CommunityListBean o, final int i) {
                viewHolder.setText(R.id.tv_name,o.getName());
                viewHolder.setText(R.id.tv_content, o.getIntroduction());
                ImageLoadUtils.into(o.getEmblemUrl(), (ImageView) viewHolder.getView(R.id.iv_photo));
                viewHolder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivities(i);

                    }
                });
            }
        };
    }

    @OnClick(R.id.iv_head)
    public void onClick(View view){
        startActivity(new Intent(mContext,EditActivity.class));
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        getMyClub();
        ImageLoadUtils.into(EasySP.getInstance().loadUserInfo().getData().getHeadPortrait(),iv_head);
        recycler.setLayoutManager(llm);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        ImageLoadUtils.into(EasySP.getInstance().loadUserInfo().getData().getHeadPortrait(), iv_head);
    }

    @Override
    public void onResume() {
        super.onResume();
        ImageLoadUtils.into(EasySP.getInstance().loadUserInfo().getData().getHeadPortrait(), iv_head);
    }

    private void getMyClub() {
        HttpUtils.getInstance().member(EasySP.getInstance().loadUserInfo().getData().getId(), new ResultCallback<MyClub>() {
            @Override
            public void onAfter(@Nullable MyClub bean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(MyClub bean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(MyClub bean, Call call, Response response) {
                if (bean!=null&&bean.getCode()==200){
                    datas.clear();
                    datas.addAll(bean.getData().getCommunityList());
                    adapter.setDatas(datas);
                }
            }
        });
    }

    private void getActivities(final int num) {
        HttpUtils.getInstance().activities(new ResultCallback<ActivitiesBean>() {
            @Override
            public void onAfter(@Nullable ActivitiesBean activitiesBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(ActivitiesBean activitiesBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {
//                ToastUtils.showToast("加载失败");
            }

            @Override
            public void onSuccess(ActivitiesBean activitiesBean, Call call, Response response) {
                if (activitiesBean != null && activitiesBean.getCode() == 200) {
                    List<ActivitiesBean.DataBean.ActivityPageBean.ContentBean> var = activitiesBean.getData().getActivityPage().getContent();
                    for (int i = 0; i < var.size(); i++) {
                        if (var.get(i).getCommunityId().equals(datas.get(num).getId())) {
                            Intent intent = new Intent(mContext, ClubEventsActivity.class);
                            intent.putExtra("event", var.get(i));
                            startActivity(intent);
                        }
                    }
//                    adapter.setDatas(datas);
//                    ToastUtils.showToast("加载成功");
                }
            }
        });
    }
}
