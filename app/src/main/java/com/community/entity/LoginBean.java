package com.community.entity;

import java.io.Serializable;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/12
 * 描　　述:
 * 备　　注:
 */

public class LoginBean implements Serializable {
    /**
     * msg : success
     * code : 200
     * data : {"id":"58ed9dc477c8f369bf436a27","loginName":"youamoao","loginPwd":"7c4a8d09ca3762af61e59520943dc26494f8941b","realname":"王小赚儿","nickname":"许你清梦","gender":"男","age":22,"grade":"大二","studentId":"20170412001","professionId":"58ece74177c88638d4031cb4","labelId":"58ec6df577c81a520b3eeca3","home":"河南","phone":"158123456789","signature":"个性签名","headPortrait":"http://i2.sanwen8.cn/doc/1609/805-160922092H0-51.jpg","createtime":1491949429000,"updatetime":1491949429000,"removed":false}
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

    public static class DataBean implements Serializable {
        /**
         * id : 58ed9dc477c8f369bf436a27
         * loginName : youamoao
         * loginPwd : 7c4a8d09ca3762af61e59520943dc26494f8941b
         * realname : 王小赚儿
         * nickname : 许你清梦
         * gender : 男
         * age : 22
         * grade : 大二
         * studentId : 20170412001
         * professionId : 58ece74177c88638d4031cb4
         * labelId : 58ec6df577c81a520b3eeca3
         * home : 河南
         * phone : 158123456789
         * signature : 个性签名
         * headPortrait : http://i2.sanwen8.cn/doc/1609/805-160922092H0-51.jpg
         * createtime : 1491949429000
         * updatetime : 1491949429000
         * removed : false
         */

        private String id;
        private String loginName;
        private String loginPwd;
        private String realname;
        private String nickname;
        private String gender;
        private int age;
        private String grade;
        private String studentId;
        private String professionId;
        private String labelId;
        private String home;
        private String phone;
        private String signature;
        private String headPortrait;
        private long createtime;
        private long updatetime;
        private boolean removed;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getLoginPwd() {
            return loginPwd;
        }

        public void setLoginPwd(String loginPwd) {
            this.loginPwd = loginPwd;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getProfessionId() {
            return professionId;
        }

        public void setProfessionId(String professionId) {
            this.professionId = professionId;
        }

        public String getLabelId() {
            return labelId;
        }

        public void setLabelId(String labelId) {
            this.labelId = labelId;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
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
