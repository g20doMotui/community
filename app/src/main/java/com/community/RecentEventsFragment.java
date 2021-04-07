package com.community;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.community.entity.ActivitiesBean;
import com.easylib.base.BaseFragment;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.LogUtils;
import com.easylib.utils.ToastUtils;
import com.easylib.views.DividerItemDecoration;
import com.guyj.CommonAdapter;
import com.guyj.base.ViewHolder;
import com.lzy.okhttputils.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 近期活动 列表页
 */
public class RecentEventsFragment extends BaseFragment {

    @Bind(R.id.recycler)
    RecyclerView recycler;
    LinearLayoutManager llm;
    CommonAdapter adapter;
    List<ActivitiesBean.DataBean.ActivityPageBean.ContentBean> datas;

    public RecentEventsFragment() {
        // Required empty public constructor
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_my_club;
    }

    @Override
    protected void initVariable() {
        datas = new ArrayList<>();
        llm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        adapter = new CommonAdapter<ActivitiesBean.DataBean.ActivityPageBean.ContentBean>(mContext, R.layout.item_recent_events, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, ActivitiesBean.DataBean.ActivityPageBean.ContentBean o, int i) {
                viewHolder.setText(R.id.tv_name, o.getCommunityName());
                viewHolder.setText(R.id.tv_content, o.getTitle() + "\n" + o.getContent());
                viewHolder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(mContext,ClubEventsActivity.class));
                    }
                });
            }
        };
    }

    @OnClick(R.id.iv_head)
    public void onClick(View view) {
        startActivity(new Intent(mContext, EditActivity.class));
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recycler.setLayoutManager(llm);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        getActivities();
    }

    private void getActivities() {
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
                ToastUtils.showToast("加载失败");
            }

            @Override
            public void onSuccess(ActivitiesBean activitiesBean, Call call, Response response) {
                if (activitiesBean != null && activitiesBean.getCode() == 200) {
                    datas.addAll(activitiesBean.getData().getActivityPage().getContent());
                    adapter.setDatas(datas);
                    ToastUtils.showToast("加载成功");
                }
            }
        });
    }


}
