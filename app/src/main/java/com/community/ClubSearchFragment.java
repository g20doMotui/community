package com.community;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.community.entity.CommunitiesBean;
import com.community.entity.LevelBean;
import com.community.entity.ProfessionBean;
import com.community.entity.TypeBean;
import com.easylib.base.BaseFragment;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.ImageLoadUtils;
import com.easylib.views.DividerItemDecoration;
import com.guyj.CommonAdapter;
import com.guyj.base.ViewHolder;
import com.lzy.okhttputils.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 社团搜索 列表页
 */
public class ClubSearchFragment extends BaseFragment {

    @Bind(R.id.ll_root)
    LinearLayout ll_root;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    LinearLayoutManager llm;
    CommonAdapter adapter;
    List<CommunitiesBean.DataBean.CommunityPageBean.ContentBean> datas;
    List<CommunitiesBean.DataBean.CommunityPageBean.ContentBean> datas2;
    @Bind(R.id.search)
    SearchView search;

    private String levelId, professionId, typeId;

    public ClubSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_club_search;
    }

    @Override
    protected void initVariable() {
        datas = new ArrayList<>();
        datas2 = new ArrayList<>();
        pop1beans=new ArrayList<>();
        pop2beans=new ArrayList<>();
        pop3beans=new ArrayList<>();
        llm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        adapter = new CommonAdapter<CommunitiesBean.DataBean.CommunityPageBean.ContentBean>(mContext, R.layout.item_my_club, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, CommunitiesBean.DataBean.CommunityPageBean.ContentBean o, final int i) {
                viewHolder.setText(R.id.tv_name, o.getName());
                viewHolder.setText(R.id.tv_content, o.getIntroduction());
                ImageLoadUtils.into(o.getEmblemUrl(), (ImageView) viewHolder.getView(R.id.iv_photo));
                viewHolder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, ClubInfoActivity.class);
                        intent.putExtra("clubId", datas.get(i).getId());
                        startActivity(intent);
                    }
                });
            }
        };
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {
        search.setIconified(true);//false展开 true关闭
        search.setIconifiedByDefault(false);//查询图标默认位于编辑框true内 false外
        search.setSubmitButtonEnabled(true);


        recycler.setLayoutManager(llm);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));

        getAllClub();
        getJiBie();
        getZhuanYe();
        getLeiXing();


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                datas2.clear();
                for (int i = 0; i < datas.size(); i++) {
                    if (!datas.get(i).getName().contains(query)) {
                        datas2.add(datas.get(i));
                    }
                }
                adapter.setDatas(datas2);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void getLeiXing() {
        HttpUtils.getInstance().type(new ResultCallback<TypeBean>() {
            @Override
            public void onAfter(@Nullable TypeBean levelBean, @Nullable Exception e) {
            }

            @Override
            public void onCacheSuccess(TypeBean levelBean, Call call) {
            }

            @Override
            public void onBefored(BaseRequest request) {
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {
            }

            @Override
            public void onSuccess(TypeBean levelBean, Call call, Response response) {
                if (levelBean != null && levelBean.getCode() == 200) {
                    pop3beans.addAll(levelBean.getData());
                    if (!levelBean.getData().isEmpty()) {
                        typeId = levelBean.getData().get(0).getId();
                    }
                }
            }
        });
    }

    private void getZhuanYe() {
        HttpUtils.getInstance().profession(new ResultCallback<ProfessionBean>() {
            @Override
            public void onAfter(@Nullable ProfessionBean levelBean, @Nullable Exception e) {
            }

            @Override
            public void onCacheSuccess(ProfessionBean levelBean, Call call) {
            }

            @Override
            public void onBefored(BaseRequest request) {
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {
            }

            @Override
            public void onSuccess(ProfessionBean levelBean, Call call, Response response) {
                if (levelBean != null && levelBean.getCode() == 200) {
                    pop2beans.addAll(levelBean.getData());
                    if (!levelBean.getData().isEmpty()) {
                        professionId = levelBean.getData().get(0).getId();
                    }
                }
            }
        });
    }

    private void getJiBie() {
        HttpUtils.getInstance().level(new ResultCallback<LevelBean>() {
            @Override
            public void onAfter(@Nullable LevelBean levelBean, @Nullable Exception e) {
            }

            @Override
            public void onCacheSuccess(LevelBean levelBean, Call call) {
            }

            @Override
            public void onBefored(BaseRequest request) {
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {
            }

            @Override
            public void onSuccess(LevelBean levelBean, Call call, Response response) {
                if (levelBean != null && levelBean.getCode() == 200) {
                    pop1beans.addAll(levelBean.getData());
                    if (!levelBean.getData().isEmpty()) {
                        levelId = levelBean.getData().get(0).getId();
                    }
                }
            }
        });
    }

    private void getAllClub() {
        HttpUtils.getInstance().communities("", "", "", new ResultCallback<CommunitiesBean>() {
            @Override
            public void onAfter(@Nullable CommunitiesBean communitiesBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(CommunitiesBean communitiesBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(CommunitiesBean communitiesBean, Call call, Response response) {
                if (communitiesBean != null && communitiesBean.getCode() == 200) {
                    datas.clear();
                    datas.addAll(communitiesBean.getData().getCommunityPage().getContent());
                    adapter.setDatas(datas);
                }
            }
        });
    }


    @OnClick(R.id.filter)
    public void onClick() {
        showPop();
    }

    //弹框;
    private PopupWindow popupWindow;
    private View view;
    private List<LevelBean.DataBean> pop1beans;
    private List<ProfessionBean.DataBean> pop2beans;
    private List<TypeBean.DataBean> pop3beans;
    //
    private void showPop() {

        view = LayoutInflater.from(mContext).inflate(R.layout.pop_filter, ll_root, false);
        popupWindow = new PopupWindow(view,ll_root.getWidth(),ll_root.getHeight());
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources()));

        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        TextView cancel=(TextView)view.findViewById(R.id.tv_cancel);
        TextView ok=(TextView)view.findViewById(R.id.tv_ok);
        RelativeLayout rl_root = (RelativeLayout) view.findViewById(R.id.rl_root);

        // 建立Adapter并且绑定数据源
        SpinnerAdapter<LevelBean.DataBean> adapter1 = new SpinnerAdapter<LevelBean.DataBean>(mContext, pop1beans);
        SpinnerAdapter<ProfessionBean.DataBean> adapter2 = new SpinnerAdapter<ProfessionBean.DataBean>(mContext, pop2beans);
        SpinnerAdapter<TypeBean.DataBean> adapter3 = new SpinnerAdapter<TypeBean.DataBean>(mContext, pop3beans);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        levelId = pop1beans.get(0).getId();
        professionId = pop2beans.get(0).getId();
        typeId = pop3beans.get(0).getId();
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                levelId = pop1beans.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                professionId = pop2beans.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeId = pop3beans.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (popupWindow != null) {
                    popupWindow = null;
                    view = null;
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                searchClub();
            }
        });


//            popupWindow.showAsDropDown(v, 0, 0);
        popupWindow.showAtLocation(ll_root, Gravity.CENTER,0,0);

    }

    private void searchClub() {
        HttpUtils.getInstance().communities(levelId, professionId, typeId, new ResultCallback<CommunitiesBean>() {
            @Override
            public void onAfter(@Nullable CommunitiesBean communitiesBean, @Nullable Exception e) {
                dismissDialog();
            }

            @Override
            public void onCacheSuccess(CommunitiesBean communitiesBean, Call call) {

            }

            @Override
            public void onBefored(BaseRequest request) {
                showDialog();
            }

            @Override
            public void onErrored(Call call, Response response, Exception e) {

            }

            @Override
            public void onSuccess(CommunitiesBean communitiesBean, Call call, Response response) {
                if (communitiesBean != null && communitiesBean.getCode() == 200) {
                    datas.clear();
                    datas.addAll(communitiesBean.getData().getCommunityPage().getContent());
                    adapter.setDatas(datas);
                }
            }
        });
    }
}
