package com.community;

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


    /**
     * example save userName
     * @param userName
     */
    public void saveUserName(String userName){
        saveString("userName",userName);
    }

    /**
     * example load userName
     * @return
     */
    public String loadUserName(){
        return loadString("userName");
    }

    /**
     * example save with active time 带缓存有效时间（毫秒）
     * @param token
     */
    public void saveToken(String token, Long ActiveTime){
        saveStrCache("token",token,ActiveTime);
    }

    /**
     * example load with active time 带缓存有效时间（毫秒）
     * @return
     */
    public String loadToken(){
        return loadStrCache("token");
    }
}
