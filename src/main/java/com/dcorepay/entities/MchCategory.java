package com.dcorepay.entities;

public class MchCategory {
    private static final long serialVersionUID = 1L;
    private String bigType;// 行业大类

    private String bigTypeId;
    private String mchType;// 商户类型
    private String mchTypeId;
    private String categoryId;// 类目id
    private Integer categoryLevel;
    private String settleCycle;
    private float fee;

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * @return the fee
     */
    public float getFee() {
        return fee;
    }

    /**
     * @param fee
     *            the fee to set
     */
    public void setFee(float fee) {
        this.fee = fee;
    }

    /**
     * @return the settleCicle
     */
    public String getSettleCycle() {
        return settleCycle;
    }

    /**
     * @param settleCicle
     *            the settleCicle to set
     */
    public void setSettleCycle(String settleCycle) {
        this.settleCycle = settleCycle;
    }

    /**
     * @return the bigTypeId
     */
    public String getBigTypeId() {
        return bigTypeId;
    }

    /**
     * @param bigTypeId
     *            the bigTypeId to set
     */
    public void setBigTypeId(String bigTypeId) {
        this.bigTypeId = bigTypeId;
    }

    /**
     * @return the mchTypeId
     */
    public String getMchTypeId() {
        return mchTypeId;
    }

    /**
     * @param mchTypeId
     *            the mchTypeId to set
     */
    public void setMchTypeId(String mchTypeId) {
        this.mchTypeId = mchTypeId;
    }

    /**
     * @return the bigType
     */
    public String getBigType() {
        return bigType;
    }

    /**
     * @param bigType
     *            the bigType to set
     */
    public void setBigType(String bigType) {
        this.bigType = bigType;
    }

    /**
     * @return the mchType
     */
    public String getMchType() {
        return mchType;
    }

    /**
     * @param mchType
     *            the mchType to set
     */
    public void setMchType(String mchType) {
        this.mchType = mchType;
    }
    /**
     * @return the categoryNames
     */
    /*
     * public String getCategoryNames() { return categoryNames; }
     *//**
       * @param categoryNames
       *            the categoryNames to set
       *//*
         * public void setCategoryNames(String categoryNames) {
         * this.categoryNames = categoryNames; }
         */

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }
}
