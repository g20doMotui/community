package com.community.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/13
 * 描　　述:
 * 备　　注:
 */

public class CommunitiesBean implements Serializable {
    /**
     * msg : success
     * code : 200
     * data : {"communityPage":{"content":[{"id":"58ecfc4077c8429728d57094","name":"社团名称","emblemUrl":"http://img3.duitang.com/uploads/item/201604/24/20160424132044_ZzhuX.jpeg","introduction":"社团简介","members":0,"typeId":"58ec5f0c77c8e99074df7b47","professionId":"58ece74177c88638d4031cb4","levelId":"58ecfb8477c8429728d57092","createtime":1491908080000,"updatetime":1491908460000,"removed":false}],"totalElements":1,"totalPages":1,"last":true,"number":0,"size":100,"sort":[{"direction":"DESC","property":"updatetime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"numberOfElements":1,"first":true}}
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
         * communityPage : {"content":[{"id":"58ecfc4077c8429728d57094","name":"社团名称","emblemUrl":"http://img3.duitang.com/uploads/item/201604/24/20160424132044_ZzhuX.jpeg","introduction":"社团简介","members":0,"typeId":"58ec5f0c77c8e99074df7b47","professionId":"58ece74177c88638d4031cb4","levelId":"58ecfb8477c8429728d57092","createtime":1491908080000,"updatetime":1491908460000,"removed":false}],"totalElements":1,"totalPages":1,"last":true,"number":0,"size":100,"sort":[{"direction":"DESC","property":"updatetime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"numberOfElements":1,"first":true}
         */

        private CommunityPageBean communityPage;

        public CommunityPageBean getCommunityPage() {
            return communityPage;
        }

        public void setCommunityPage(CommunityPageBean communityPage) {
            this.communityPage = communityPage;
        }

        public static class CommunityPageBean implements Serializable {
            /**
             * content : [{"id":"58ecfc4077c8429728d57094","name":"社团名称","emblemUrl":"http://img3.duitang.com/uploads/item/201604/24/20160424132044_ZzhuX.jpeg","introduction":"社团简介","members":0,"typeId":"58ec5f0c77c8e99074df7b47","professionId":"58ece74177c88638d4031cb4","levelId":"58ecfb8477c8429728d57092","createtime":1491908080000,"updatetime":1491908460000,"removed":false}]
             * totalElements : 1
             * totalPages : 1
             * last : true
             * number : 0
             * size : 100
             * sort : [{"direction":"DESC","property":"updatetime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
             * numberOfElements : 1
             * first : true
             */

            private int totalElements;
            private int totalPages;
            private boolean last;
            private int number;
            private int size;
            private int numberOfElements;
            private boolean first;
            private List<ContentBean> content;
            private List<SortBean> sort;

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

            public boolean isLast() {
                return last;
            }

            public void setLast(boolean last) {
                this.last = last;
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

            public int getNumberOfElements() {
                return numberOfElements;
            }

            public void setNumberOfElements(int numberOfElements) {
                this.numberOfElements = numberOfElements;
            }

            public boolean isFirst() {
                return first;
            }

            public void setFirst(boolean first) {
                this.first = first;
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
                 * id : 58ecfc4077c8429728d57094
                 * name : 社团名称
                 * emblemUrl : http://img3.duitang.com/uploads/item/201604/24/20160424132044_ZzhuX.jpeg
                 * introduction : 社团简介
                 * members : 0
                 * typeId : 58ec5f0c77c8e99074df7b47
                 * professionId : 58ece74177c88638d4031cb4
                 * levelId : 58ecfb8477c8429728d57092
                 * createtime : 1491908080000
                 * updatetime : 1491908460000
                 * removed : false
                 */

                private String id;
                private String name;
                private String emblemUrl;
                private String introduction;
                private int members;
                private String typeId;
                private String professionId;
                private String levelId;
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
