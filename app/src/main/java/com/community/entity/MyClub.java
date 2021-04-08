package com.community.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.List;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/13
 * 描　　述:
 * 备　　注:
 */
public class MyClub implements Serializable{

    /**
     * msg : success
     * code : 200
     * data : {"communityList":[{"id":"58ecfc4077c8429728d57094","name":"社团的名字","emblemUrl":"http://img3.duitang.com/uploads/item/201604/24/20160424132044_ZzhuX.jpeg","introduction":"社团的简介","members":0,"typeId":"58ec5f0c77c8e99074df7b47","professionId":"58ece74177c88638d4031cb4","levelId":"58ecfb8477c8429728d57092","memberId":"58ed9dc477c8f369bf436a27","createtime":1491908080000,"updatetime":1492071682000,"removed":false}]}
     */

    private String msg;
    private int code;
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
        /**
         * id : 58ecfc4077c8429728d57094
         * name : 社团的名字
         * emblemUrl : http://img3.duitang.com/uploads/item/201604/24/20160424132044_ZzhuX.jpeg
         * introduction : 社团的简介
         * members : 0
         * typeId : 58ec5f0c77c8e99074df7b47
         * professionId : 58ece74177c88638d4031cb4
         * levelId : 58ecfb8477c8429728d57092
         * memberId : 58ed9dc477c8f369bf436a27
         * createtime : 1491908080000
         * updatetime : 1492071682000
         * removed : false
         */

        private List<CommunityListBean> communityList;

        public List<CommunityListBean> getCommunityList() {
            return communityList;
        }

        public void setCommunityList(List<CommunityListBean> communityList) {
            this.communityList = communityList;
        }

        public static class CommunityListBean implements Serializable{
            private String id;
            private String name;
            private String emblemUrl;
            private String introduction;
            private int members;
            private String typeId;
            private String professionId;
            private String levelId;
            private String memberId;
            private long createtime;
            private long updatetime;
            private boolean removed;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmblemUrl() {
                return emblemUrl;
            }

            public void setEmblemUrl(String emblemUrl) {
                this.emblemUrl = emblemUrl;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getMembers() {
                return members;
            }

            public void setMembers(int members) {
                this.members = members;
            }

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }

            public String getProfessionId() {
                return professionId;
            }

            public void setProfessionId(String professionId) {
                this.professionId = professionId;
            }

            public String getLevelId() {
                return levelId;
            }

            public void setLevelId(String levelId) {
                this.levelId = levelId;
            }

            public String getMemberId() {
                return memberId;
            }

            public void setMemberId(String memberId) {
                this.memberId = memberId;
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
}
