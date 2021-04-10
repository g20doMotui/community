package com.community;

import android.content.Context;

import com.guyj.MultiItemTypeAdapter;

import java.util.List;

/**
 * 作　　者: guyj
 * 修改日期: 2016/12/22
 * 描　　述:
 * 备　　注:
 */
public class MultiListAdapter extends MultiItemTypeAdapter<Object> {

    public MultiListAdapter(Context context, List<Object> datas) {
        super(context, datas);
        addItemViewDelegate(new DelegateMember());
        addItemViewDelegate(new DelegateLeader());
    }


}
