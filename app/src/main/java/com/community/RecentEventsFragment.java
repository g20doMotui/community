package com.community;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easylib.base.BaseFragment;
import com.easylib.utils.LogUtils;
import com.easylib.views.DividerItemDecoration;
import com.guyj.CommonAdapter;
import com.guyj.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 近期活动 列表页
 */
public class RecentEventsFragment extends BaseFragment {

    @Bind(R.id.recycler)
    RecyclerView recycler;
    LinearLayoutManager llm;
    CommonAdapter adapter;
    List<String> datas;

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
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        llm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        adapter = new CommonAdapter<String>(mContext, R.layout.item_recent_events, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String o, int i) {
                viewHolder.setText(R.id.tv_name, "club name" + i);
                viewHolder.setText(R.id.tv_content, "club 活动" + i);
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
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogUtils.e(TAG, "===============" + isVisible);
    }
}
