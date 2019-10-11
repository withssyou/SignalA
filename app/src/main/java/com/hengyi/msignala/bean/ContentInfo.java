package com.hengyi.msignala.bean;

public class ContentInfo {

    /**
     * ModifyClient : 0
     * DataModify : order
     * ModifyType : 4
     * Category : 0
     * Content : {"review1":"True","id":"211323","name":"GZD191010004"}
     */

    private int ModifyClient;
    private String DataModify;
    private int ModifyType;
    private int Category;
    private ContentBean Content;

    public int getModifyClient() {
        return ModifyClient;
    }

    public void setModifyClient(int ModifyClient) {
        this.ModifyClient = ModifyClient;
    }

    public String getDataModify() {
        return DataModify;
    }

    public void setDataModify(String DataModify) {
        this.DataModify = DataModify;
    }

    public int getModifyType() {
        return ModifyType;
    }

    public void setModifyType(int ModifyType) {
        this.ModifyType = ModifyType;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int Category) {
        this.Category = Category;
    }

    public ContentBean getContent() {
        return Content;
    }

    public void setContent(ContentBean Content) {
        this.Content = Content;
    }

    public static class ContentBean {
        /**
         * review1 : True
         * id : 211323
         * name : GZD191010004
         */

        private String review1;
        private String id;
        private String name;

        public String getReview1() {
            return review1;
        }

        public void setReview1(String review1) {
            this.review1 = review1;
        }

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
    }
}
