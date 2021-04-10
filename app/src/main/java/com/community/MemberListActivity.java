package com.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.community.entity.MemberListBean;
import com.easylib.base.BaseActivity;
import com.easylib.okhttp.ResultCallback;
import com.guyj.MultiItemTypeAdapter;
import com.guyj.listener.EasyOnItemChildClickListener;
import com.lzy.okhttputils.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 成员列表
 */
public class MemberListActivity extends BaseActivity {

    @Bind(R.id.title)
    RelativeLayout title;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    List<Object> datas;
    LinearLayoutManager llm;
    String clubid;
    MultiListAdapter adapter;
    @Override
    public int getContentViewId() {
        return R.layout.activity_member_list;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initVariable() {
        clubid = getIntent().getStringExtra("clubid");
        datas = new ArrayList<>();
        llm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recycler.setLayoutManager(llm);
        recycler.setAdapter(adapter = new MultiListAdapter(mContext, datas));
        getList();
        adapter.setEasyOnItemChildClickListener(new EasyOnItemChildClickListener() {
            @Override
            public void onClick(View view, int i) {
                Intent intent = new Intent(mContext, MemberInfoActivity.class);
                if (i == 0) {
                    MemberListBean.DataBean.AdminBean adminBean = (MemberListBean.DataBean.AdminBean) datas.get(0);
                    intent.putExtra("1", adminBean.getHeadPortrait());
                    intent.putExtra("2", adminBean.getNickname());
                    intent.putExtra("3", adminBean.getRealname());
                    intent.putExtra("4", adminBean.getGender());
                    intent.putExtra("5", adminBean.getAge());
                    intent.putExtra("6", adminBean.getGrade());
                    intent.putExtra("7", adminBean.getStudentId());
                    intent.putExtra("8", adminBean.getProfessionId());
                    intent.putExtra("9", adminBean.getHome());
                    intent.putExtra("10", adminBean.getPhone());
                    intent.putExtra("11", adminBean.getSignature());
                } else {
                    MemberListBean.DataBean.MemberTListBean adminBean = (MemberListBean.DataBean.MemberTListBean) datas.get(i);
                    intent.putExtra("1", adminBean.getHeadPortrait());
                    intent.putExtra("2", adminBean.getNickname());
                    intent.putExtra("3", adminBean.getRealname());
                    intent.putExtra("4", adminBean.getGender());
                    intent.putExtra("5", adminBean.getAge());
                    intent.putExtra("6", adminBean.getGrade());
                    intent.putExtra("7", adminBean.getStudentId());
                    intent.putExtra("8", adminBean.getProfessionId());
                    intent.putExtra("9", adminBean.getHome());
                    intent.putExtra("10", adminBean.getPhone());
                    intent.putExtra("11", adminBean.getSignature());
                }

                startActivity(intent);

            }
        });

    }

    private void getList() {
        HttpUtils.getInstance().memberlist(clubid, new ResultCallback<MemberListBean>() {
            @Override
            public void onAfter(@Nullable MemberListBean memberListBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(MemberListBean memberListBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(MemberListBean memberListBean, Call call, Response response) {
                if (memberListBean != null && memberListBean.getCode() == 200) {
                    datas.clear();
                    datas.add(memberListBean.getData().getAdmin());
                    datas.addAll(memberListBean.getData().getMemberTList());
                    adapter.setDatas(datas);
                }
            }
        });
    }


    @OnClick(R.id.tv_back)
    public void onClick() {
        finish();
    }
}
