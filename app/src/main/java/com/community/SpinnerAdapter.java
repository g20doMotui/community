package com.community;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.community.entity.LevelBean;
import com.community.entity.ProfessionBean;
import com.community.entity.TypeBean;

import java.util.List;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/13
 * 描　　述:
 * 备　　注:
 */
public class SpinnerAdapter<T> extends BaseAdapter {
    private List<T> mList;
    private Context mContext;

    public SpinnerAdapter(Context mContext, List<T> pop1beans) {
        this.mContext = mContext;
        this.mList = pop1beans;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater _LayoutInflater = LayoutInflater.from(mContext);
        convertView = _LayoutInflater.inflate(android.R.layout.simple_spinner_item, null);
        if (convertView != null) {
            TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
            if (getItem(position) instanceof LevelBean.DataBean) {
                tv.setText(((LevelBean.DataBean) (mList.get(position))).getLevel());
            } else if (getItem(position) instanceof ProfessionBean.DataBean) {
                tv.setText(((ProfessionBean.DataBean) (mList.get(position))).getProfession());
            } else if (getItem(position) instanceof TypeBean.DataBean) {
                tv.setText(((TypeBean.DataBean) (mList.get(position))).getType());
            }
        }
        return convertView;
    }

    public void setData(List<T> pop1beans) {
        this.mList = pop1beans;
        notifyDataSetChanged();
    }
}
