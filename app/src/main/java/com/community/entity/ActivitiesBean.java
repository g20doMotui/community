package com.community.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/13
 * 描　　述:
 * 备　　注:
 */

public class ActivitiesBean implements Serializable {

    /**
     * msg : success
     * code : 200
     * data : {"activityPage":{"content":[{"id":"58ed067a77c802950974579e","title":"活动标题","content":"活动简介","communityId":"58ecfc4077c8429728d57094","communityName":"社团名称","createtime":1491910701000,"updatetime":1491910701000,"removed":false}],"last":true,"totalElements":1,"totalPages":1,"number":0,"size":10,"sort":[{"direction":"DESC","property":"updatetime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1}}
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
         * activityPage : {"content":[{"id":"58ed067a77c802950974579e","title":"活动标题","content":"活动简介","communityId":"58ecfc4077c8429728d57094","communityName":"社团名称","createtime":1491910701000,"updatetime":1491910701000,"removed":false}],"last":true,"totalElements":1,"totalPages":1,"number":0,"size":10,"sort":[{"direction":"DESC","property":"updatetime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1}
         */

        private ActivityPageBean activityPage;

        public ActivityPageBean getActivityPage() {
            return activityPage;
        }

        public void setActivityPage(ActivityPageBean activityPage) {
            this.activityPage = activityPage;
        }

        public static class ActivityPageBean implements Serializable {
            /**
             * content : [{"id":"58ed067a77c802950974579e","title":"活动标题","content":"活动简介","communityId":"58ecfc4077c8429728d57094","communityName":"社团名称","createtime":1491910701000,"updatetime":1491910701000,"removed":false}]
             * last : true
             * totalElements : 1
             * totalPages : 1
             * number : 0
             * size : 10
             * sort : [{"direction":"DESC","property":"updatetime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
             * first : true
             * numberOfElements : 1
             */

            private boolean last;
            private int totalElements;
            private int totalPages;
            private int number;
            private int size;
            private boolean first;
            private int numberOfElements;
            private List<ContentBean> content;
            private List<SortBean> sort;

            public boolean isLast() {
                return last;
            }

            public void setLast(boolean last) {
                this.last = last;
            }

            public int getTotalElements() {
                return totalElements;
            }

            public void setTotalElements(int totalElements) {
                this.totalElements = totalElements;
            }

            public int getTotalPages() {
                return totalPages;
            }

            public void setTotalPages(int totalPages) {
                this.totalPages = totalPages;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public boolean isFirst() {
                return first;
            }

            public void setFirst(boolean first) {
                this.first = first;
            }

            public int getNumberOfElements() {
                return numberOfElements;
            }

            public void setNumberOfElements(int numberOfElements) {
                this.numberOfElements = numberOfElements;
            }

            public List<ContentBean> getContent() {
                return content;
            }

            public void setContent(List<ContentBean> content) {
                this.content = content;
            }

            public List<SortBean> getSort() {
                return sort;
            }

            public void setSort(List<SortBean> sort) {
                this.sort = sort;
            }

            public static class ContentBean implements Serializable {
                /**
                 * id : 58ed067a77c802950974579e
                 * title : 活动标题
                 * content : 活动简介
                 * communityId : 58ecfc4077c8429728d57094
                 * communityName : 社团名称
                 * createtime : 1491910701000
                 * updatetime : 1491910701000
                 * removed : false
                 */

                private String id;
                private String title;
                private String content;
                private String communityId;
                private String communityName;
                private long createtime;
                private long updatetime;
                private boolean removed;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCommunityId() {
                    return communityId;
                }

                public void setCommunityId(String communityId) {
                    this.communityId = communityId;
                }

                public String getCommunityName() {
                    return communityName;
                }

                public void setCommunityName(String communityName) {
                    this.communityName = communityName;
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

            public static class SortBean implements Serializable {
                /**
                 * direction : DESC
                 * property : updatetime
                 * ignoreCase : false
                 * nullHandling : NATIVE
                 * ascending : false
                 */

                private String direction;
                private String property;
                private boolean ignoreCase;
                private String nullHandling;
                private boolean ascending;

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getProperty() {
                    return property;
                }

                public void setProperty(String property) {
                    this.property = property;
                }

                public boolean isIgnoreCase() {
                    return ignoreCase;
                }

                public void setIgnoreCase(boolean ignoreCase) {
                    this.ignoreCase = ignoreCase;
                }

                public String getNullHandling() {
                    return nullHandling;
                }

                public void setNullHandling(String nullHandling) {
                    this.nullHandling = nullHandling;
                }

                public boolean isAscending() {
                    return ascending;
                }

                public void setAscending(boolean ascending) {
                    this.ascending = ascending;
                }
            }
        }
    }
}
