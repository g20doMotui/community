package com.community.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/13
 * 描　　述:
 * 备　　注:
 */

public class LabelBean implements Serializable {
    /**
     * msg : success
     * code : 200
     * data : [{"id":"58ec6df577c81a520b3eeca3","label":"标签","createtime":1491871654000,"updatetime":1491871654000,"removed":false}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 58ec6df577c81a520b3eeca3
         * label : 标签
         * createtime : 1491871654000
         * updatetime : 1491871654000
         * removed : false
         */

        private String id;
        private String label;
        private long createtime;
        private long updatetime;
        private boolean removed;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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
