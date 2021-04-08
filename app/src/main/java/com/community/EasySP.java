package com.community;

import com.community.entity.ListBean;
import com.community.entity.LoginBean;
import com.easylib.base.BaseSharedPreferences;

/**
 * 描　　述: SharedPreferences单例类
 */
public class EasySP extends BaseSharedPreferences {
    /**
     * singleton mode
     */
    private static class SingleTon{
        private static EasySP getInstance=new EasySP();
    }
    public static EasySP getInstance() {
        return SingleTon.getInstance;
    }
    private EasySP() {
    }

    public void saveUserInfo(LoginBean bean) {
        saveObj("userinfo", bean);
    }

    public LoginBean loadUserInfo() {
        return (LoginBean) loadObj("userinfo");
    }

    public void saveJoinInfo(ListBean bean) {
        saveObj("ListBean", bean);
    }

    public ListBean loadJoinInfo() {
        return (ListBean) loadObj("ListBean");
    }

}
