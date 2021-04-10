package com.community;

import com.community.entity.ActivitiesBean;
import com.community.entity.AppliesBean;
import com.community.entity.ClubBean;
import com.community.entity.CommunitiesBean;
import com.community.entity.LabelBean;
import com.community.entity.LevelBean;
import com.community.entity.ListBean;
import com.community.entity.LoginBean;
import com.community.entity.MemberListBean;
import com.community.entity.MyClub;
import com.community.entity.ProfessionBean;
import com.community.entity.RefusedBean;
import com.community.entity.ThroughBean;
import com.community.entity.TypeBean;
import com.community.entity.UserInfoBean;
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
    private String host = "http://139.199.14.32:8080";
    private String login = "/api/members/login";//登录
    private String activities = "/api/activities";//活动列表
    private String communities = "/api/communities";//社团列表
    private String communitiesinfo = "/api/communities/";//社团详情
    private String member = "/api/communities/member/";//我的社团 缺返回值
    private String label = "/api/others/label";//兴趣标签
    private String level = "/api/others/level";//社团级别
    private String profession = "/api/others/profession";//社团专业
    private String type = "/api/others/type";//社团类型
    private String applies = "/api/applies";//申请加入
    private String list = "/api/applies/list";//拉取申请加入的信息，论
    private String through = "/api/applies/through";//同意申请
    private String refused = "/api/applies/refused";//拒绝申请
    private String userinfo = "/api/members/";//会员详情
    private String memberlist = "/api/communities/member/list/";//会员列表

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

    public void member(String userid, ResultCallback<MyClub> callback) {
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
    public void applies(String memberId,String communityId,ResultCallback<AppliesBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("memberId", memberId);
        httpParams.put("communityId", communityId);
        httpPost(host, applies, httpParams, callback);
    }

    public void list(String memberId,ResultCallback<ListBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("memberId", memberId);
        httpGet(host, list, httpParams, callback);
    }

    public void through(String applyId,ResultCallback<ThroughBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("applyId", applyId);
        httpGet(host, through, httpParams, callback);
    }
    public void refused(String applyId,String reason,ResultCallback<RefusedBean> callback) {
        httpParams = new HttpParams();
        httpParams.put("applyId", applyId);
        httpParams.put("reason", reason);
        httpGet(host, refused, httpParams, callback);
    }

    public void userinfo(String memberId, ResultCallback<UserInfoBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, userinfo + memberId, httpParams, callback);
    }

    public void memberlist(String clubid, ResultCallback<MemberListBean> callback) {
        httpParams = new HttpParams();
        httpGet(host, memberlist + clubid, httpParams, callback);
    }


}
