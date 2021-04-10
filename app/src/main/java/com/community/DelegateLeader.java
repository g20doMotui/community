package com.community;

import android.widget.ImageView;

import com.community.entity.MemberListBean;
import com.easylib.utils.ImageLoadUtils;
import com.guyj.base.ItemViewDelegate;
import com.guyj.base.ViewHolder;

/**
 * 团长的item
 */
public class DelegateLeader implements ItemViewDelegate<Object> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_club_leader;
    }

    @Override
    public boolean isForViewType(Object o, int i) {
        return o instanceof MemberListBean.DataBean.AdminBean;
    }

    @Override
    public void convert(ViewHolder viewHolder, Object o, int i) {
        viewHolder.setText(R.id.tv_name, ((MemberListBean.DataBean.AdminBean) o).getNickname());
        viewHolder.setText(R.id.tv_sign, ((MemberListBean.DataBean.AdminBean) o).getSignature());
        ImageLoadUtils.into(((MemberListBean.DataBean.AdminBean) o).getHeadPortrait(), (ImageView) viewHolder.getView(R.id.iv_photo));
        viewHolder.setOnItemChildClickListener(R.id.rl_root);
    }
}
