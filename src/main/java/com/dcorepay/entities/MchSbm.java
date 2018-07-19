package com.dcorepay.entities;

/**
 * 商户识别码Entity
 * 
 * @author huacw
 * @version 2016-01-17
 */
public class MchSbm {

    private static final long serialVersionUID = 1L;
    private String id;
    private String mchName; // 商家名称
    private String abbrName; // 商家简称
    private String contact; // 联系人
    private String mobile; // 手机号码
    private String email; // 邮箱
    private MchCategory mchCategory; // 经营类目
    private String custTel; // 客服电话
    private String wxSubMchId; // 微信分配商户号
    private String status; // 状态 1待生成 2已生成 9停用
    private String tgId; // 通道编号
    private String tgName; // 通道名称
    private String remarks;

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    private String wxSource;//微信渠道号

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MchCategory getMchCategory() {
        return mchCategory;
    }

    public void setMchCategory(MchCategory mchCategory) {
        this.mchCategory = mchCategory;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getWxSubMchId() {
        return wxSubMchId;
    }

    public void setWxSubMchId(String wxSubMchId) {
        this.wxSubMchId = wxSubMchId;
    }

    public String getStatus() {
        return status;
    }

    /**
     * 状态 1待生成 2已生成 9停用
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgId() {
        return tgId;
    }

    public void setTgId(String tgId) {
        this.tgId = tgId;
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public String getWxSource() {
        return wxSource;
    }

    public void setWxSource(String wxSource) {
        this.wxSource = wxSource;
    }
}