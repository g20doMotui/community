package com.community;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.easylib.base.BaseFragment;
import com.easylib.views.DividerItemDecoration;
import com.guyj.CommonAdapter;
import com.guyj.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    List<String> datas;
    @Bind(R.id.search)
    SearchView search;

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
        pop1beans=new ArrayList<>();
        pop2beans=new ArrayList<>();
        pop3beans=new ArrayList<>();
        datas.add("1");
        datas.add("2");
        datas.add("3");
        datas.add("4");
        pop1beans.add("1");
        pop1beans.add("2");
        pop2beans.add("3");
        pop2beans.add("4");
        pop2beans.add("5");
        pop3beans.add("6");
        pop3beans.add("7");
        pop3beans.add("8");
        pop3beans.add("9");
        llm = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        adapter = new CommonAdapter<String>(mContext, R.layout.item_my_club, datas) {
            @Override
            protected void convert(ViewHolder viewHolder, String o, int i) {
                viewHolder.setText(R.id.tv_name, "club name" + i);
                viewHolder.setText(R.id.tv_content, "club 介绍" + i);
                viewHolder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(mContext,ClubInfoActivity.class));
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
    }



    @OnClick(R.id.filter)
    public void onClick() {
        showPop();
    }

    //弹框;
    private PopupWindow popupWindow;
    private View view;
    private List<String> pop1beans;
    private List<String> pop2beans;
    private List<String> pop3beans;
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
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item, pop1beans);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item, pop2beans);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item, pop3beans);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);


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
            }
        });


//            popupWindow.showAsDropDown(v, 0, 0);
        popupWindow.showAtLocation(ll_root, Gravity.CENTER,0,0);

    }
}
