package com.community;

import com.community.entity.ActivitiesBean;
import com.community.entity.ClubBean;
import com.community.entity.CommunitiesBean;
import com.community.entity.LabelBean;
import com.community.entity.LevelBean;
import com.community.entity.LoginBean;
import com.community.entity.ProfessionBean;
import com.community.entity.TypeBean;
import com.easylib.base.BaseHttpUtils;
import com.easylib.okhttp.ResultCallback;
import com.lzy.okhttputils.model.HttpParams;

/**
 * 作　　者: guyj
 * 修改日期: 2016/11/19
 * 描　　述:
 * 备　　注:
 */
public class HttpUtils extends BaseHttpUtils {

    private static class SingleTon {
        private static HttpUtils getInstance = new HttpUtils();
    }

    public static HttpUtils getInstance() {
        return SingleTon.getInstance;
    }

    private HttpUtils() {
    }

    private HttpParams httpParams;
    private String host = "http://192.168.1.6:8080";
    private String login = "/api/members/login";//登录
    private String activities = "/api/activities";//活动列表
    private String communities = "/api/communities";//社团列表
    private String communitiesinfo = "/api/communities/";//社团详情
    private String member = "/api/communities/member/";//我的社团 缺返回值
    private String label = "/api/others/label";//兴趣标签
    private String level = "/api/others/level";//社团级别
    private String profession = "/api/others/profession";//社团专业
    private String type = "/api/others/type";//社团类型

    public void login(String loginName, String loginPwd, ResultCallback<LoginBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("loginName", loginName);
        httpParams.put("loginPwd", loginPwd);
        httpGet(host, login, httpParams, callback);
    }

    public void activities(ResultCallback<ActivitiesBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("page", 0);
        httpParams.put("Size", 100);
        httpGet(host, activities, httpParams, callback);
    }

    public void communities(String levelId, String professionId, String typeId, ResultCallback<CommunitiesBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("typeId", typeId);
        httpParams.put("levelId", levelId);
        httpParams.put("professionId", professionId);
        httpParams.put("page", 0);
        httpParams.put("Size", 100);
        httpGet(host, communities, httpParams, callback);
    }

    public void communitiesinfo(String clubId, ResultCallback<ClubBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, communitiesinfo + clubId, httpParams, callback);
    }

    public void member(String userid, ResultCallback<LabelBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, member + userid, httpParams, callback);
    }

    public void label(ResultCallback<LabelBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, label, httpParams, callback);
    }

    public void level(ResultCallback<LevelBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, level, httpParams, callback);
    }

    public void profession(ResultCallback<ProfessionBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, profession, httpParams, callback);
    }

    public void type(ResultCallback<TypeBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, type, httpParams, callback);
    }


}
