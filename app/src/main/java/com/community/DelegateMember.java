package com.community;

import android.widget.ImageView;

import com.community.entity.MemberListBean;
import com.easylib.utils.ImageLoadUtils;
import com.guyj.base.ItemViewDelegate;
import com.guyj.base.ViewHolder;

/**
 * 团员的item
 */
public class DelegateMember implements ItemViewDelegate<Object> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_club_member;
    }

    @Override
    public boolean isForViewType(Object o, int i) {
        return o instanceof MemberListBean.DataBean.MemberTListBean;
    }

    @Override
    public void convert(final ViewHolder viewHolder, Object o, int i) {
        viewHolder.setText(R.id.tv_name, ((MemberListBean.DataBean.MemberTListBean) o).getNickname());
        viewHolder.setText(R.id.tv_sign, ((MemberListBean.DataBean.MemberTListBean) o).getSignature());
        ImageLoadUtils.into(((MemberListBean.DataBean.MemberTListBean) o).getHeadPortrait(), (ImageView) viewHolder.getView(R.id.iv_photo));
        viewHolder.setOnItemChildClickListener(R.id.rl_root);
    }
}
