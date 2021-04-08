package com.community.entity;

import java.io.Serializable;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/13
 * 描　　述:
 * 备　　注:
 */
public class ListBean implements Serializable{

    /**
     * msg : success
     * code : 200
     * data : {"id":"58ef37f077c813068a5af3da","memberId":"58ef34b177c845eb2635771b","communityId":"58ecfc4077c8429728d57094","applyStatus":"0","reason":"","isRead":"0","createtime":1492072432000,"updatetime":1492072432000,"removed":false}
     */

    private String msg;
    private int code;
    /**
     * id : 58ef37f077c813068a5af3da
     * memberId : 58ef34b177c845eb2635771b
     * communityId : 58ecfc4077c8429728d57094
     * applyStatus : 0
     * reason :
     * isRead : 0
     * createtime : 1492072432000
     * updatetime : 1492072432000
     * removed : false
     */

    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private String id;
        private String memberId;
        private String communityId;
        private String applyStatus;
        private String reason;
        private String isRead;
        private long createtime;
        private long updatetime;
        private boolean removed;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getCommunityId() {
            return communityId;
        }

        public void setCommunityId(String communityId) {
            this.communityId = communityId;
        }

        public String getApplyStatus() {
            return applyStatus;
        }

        public void setApplyStatus(String applyStatus) {
            this.applyStatus = applyStatus;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getIsRead() {
            return isRead;
        }

        public void setIsRead(String isRead) {
            this.isRead = isRead;
        }

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public long getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(long updatetime) {
            this.updatetime = updatetime;
        }

        public boolean isRemoved() {
            return removed;
        }

        public void setRemoved(boolean removed) {
            this.removed = removed;
        }
    }
}
