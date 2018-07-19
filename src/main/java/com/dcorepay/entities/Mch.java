package com.dcorepay.entities;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Mch extends DataEntity<Mch> {

    private static final long serialVersionUID = 1L;
    // private String mchId;
    private String mchName;
    private String abbrName;
    private String contact;
    private String mobile;
    private String email;
    private String website;
    private String regAddr;
    private String regPic;
    private String legalName;
    private String cardType;
    private String cardNum;
    private String cardFront;
    private String cardBack;
    private String regPicId;
    private String cardFrontId;//没有用，暂时用来做一个开通时间储存
    private String cardBackId;
    private String orgCode;
    private String orgPic;
    private String orgPicId;
    private String custTel;
    private String acctName;
    private String bankName;
    private String bankCity;
    private String bankBranch;
    private String bankAcct;
    private String wxSubMchId;
    private String wxSubAppid;
    private String wxSubAppkey;
    private float wxRate;
    private String dcMchId;
    private String dcAppid;
    private float dcRate;
    private float oldDcRate;
    private String dcKey;
    private String status;
    private String address;
    private String remark;
    private String cardTypeName;
    private String mchSuperPwd;
    private String mchNewSuperPwd;// 新的退款授权码
    private String regCode;
    private String scope;
    private MchCategory category;// 20160104
    private String goods;
    private String goodsTag;
    private float agentRate;
    private String parentIds;// 分支机构的层级关系
    private int type;// 0表示区域，1表示商户
    private String op;//
    private String prentMchId;
    private String mchType;
    private String contractScan;// 合同扫描件
    private String qfOfficeId;// 分账机构
    private String tgId;
    private String parentMchId;// 商户上级
    private String parentMchIds;// 商户上级链
    private String parentTopMoId;// 商户集团
    private String bankAcctType;
    private Boolean defaultFollow;// 默认关注
    private String mchGrade;// 商户等级
    private String settleEndtime;// 结算截至时间 格式为：HH:MM 24小时制

    private String dkzhId;// 垫款账户
    private String settleType;// 结算模式 0 T+0结算 1 T+1结算
    private String tradeType;
    private String dkzhRete;

    private Integer refundType;//退款模式：1：只允许退全款；2：可退部分款；3：不允许退款；
    private float refundLimit;//退款预留金额 2时必填
    private int isDelayed;//是否允许延迟退款
    private MchCategoryAli aliCategory;
    private String aliSubMchId;
    private String aliPid;
    private String payType;
    private String aliTgId;
    private String companyId; //用于事业单位

    private String franchisePic;
    private String scenePic;
    private String otherePic;
    private String bankLhh;

    private String parentMchName;//所属商户集团名称

    private Date beginTime;
    private Date endTime;

    //受理商户在支付宝的PID
    private String businessLicense; //商户证件编号
    private String licenseType; //商户证件类型
    private String contactType; //联系人类型
    private String provinceCode; //商户所在省份编码
    private String cityCode; //商户所在城市编码
    private String districtCode; //商户所在区县编码
    private String indirectLevel; //商户在支付宝的等级
    private String externalId;//支付宝受理商户编号，默认为cib_mch_id

    private String newWxMchId;
    private String newAliMchId;

    private String source;


    public String getNewAliMchId() {
        return newAliMchId;
    }

    public String getNewWxMchId() {
        return newWxMchId;
    }

    public void setNewAliMchId(String newAliMchId) {
        this.newAliMchId = newAliMchId;
    }

    public void setNewWxMchId(String newWxMchId) {
        this.newWxMchId = newWxMchId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getIndirectLevel() {
        return indirectLevel;
    }

    public void setIndirectLevel(String indirectLevel) {
        this.indirectLevel = indirectLevel;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getBankLhh() {
        return bankLhh;
    }

    public void setBankLhh(String bankLhh) {
        this.bankLhh = bankLhh;
    }

    public String getOtherePic() {
        return otherePic;
    }

    public void setOtherePic(String otherePic) {
        this.otherePic = otherePic;
    }

    public String getFranchisePic() {
        return franchisePic;
    }

    public void setFranchisePic(String franchisePic) {
        this.franchisePic = franchisePic;
    }

    public String getScenePic() {
        return scenePic;
    }

    public void setScenePic(String scenePic) {
        this.scenePic = scenePic;
    }

    public MchCategoryAli getAliCategory() {
        return aliCategory;
    }

    public void setAliCategory(MchCategoryAli aliCategory) {
        this.aliCategory = aliCategory;
    }

    public String getAliSubMchId() {
        return aliSubMchId;
    }

    public void setAliSubMchId(String aliSubMchId) {
        this.aliSubMchId = aliSubMchId;
    }

    public String getAliPid() {
        return aliPid;
    }

    public void setAliPid(String aliPid) {
        this.aliPid = aliPid;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAliTgId() {
        return aliTgId;
    }

    public void setAliTgId(String aliTgId) {
        this.aliTgId = aliTgId;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public float getRefundLimit() {
        return refundLimit;
    }

    public String getDkzhRete() {
        return dkzhRete;
    }

    public void setDkzhRete(String dkzhRete) {
        this.dkzhRete = dkzhRete;
    }

    public void setDcRate(float dcRate) {
        this.dcRate = dcRate;
    }

    public void setRefundLimit(float refundLimit) {
        this.refundLimit = refundLimit;
    }

    /**
     * @return the paymentType
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setTradeType(String paymentType) {
        this.tradeType = paymentType;
    }

    /**
     * @return the settleEndtime
     */
    @Pattern(regexp = "([01]?[0-9]|[2][0-3]):[0-5]?[0-9]$", message = "结算截至时间格式为HH:MM")
    public String getSettleEndtime() {
        return settleEndtime;
    }

    /**
     * @param settleEndtime the settleEndtime to set
     */
    public void setSettleEndtime(String settleEndtime) {
        this.settleEndtime = settleEndtime;
    }

    /**
     * @return the dkzhId
     */
    public String getDkzhId() {
        return dkzhId;
    }

    /**
     * @param dkzhId the dkzhId to set
     */
    public void setDkzhId(String dkzhId) {
        this.dkzhId = dkzhId;
    }

    /**
     * @return the settleType
     */
    public String getSettleType() {
        return settleType;
    }

    /**
     * @param settleType the settleType to set
     */
    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    /**
     * @return 商户等级 1.大商户 2.普通商户
     */
    public String getMchGrade() {
        return mchGrade;
    }


    public void setMchGrade(String mchGrade) {
        this.mchGrade = mchGrade;
    }

    /**
     * @return 1需要默认关注 0.不需要默认关注
     */
    public Boolean getDefaultFollow() {
        return defaultFollow;
    }


    public void setDefaultFollow(Boolean defaultFollow) {
        this.defaultFollow = defaultFollow;
    }

    /**
     * @return 账号类型 1.企业 2.个人
     */
    public String getBankAcctType() {
        return bankAcctType;
    }


    public void setBankAcctType(String bankAcctType) {
        this.bankAcctType = bankAcctType;
    }


    /**
     * @return 商户所在的集团的直接父机构
     */
    public String getParentMchId() {
        return parentMchId;
    }


    public void setParentMchId(String parentMchId) {
        this.parentMchId = parentMchId;
    }

    /**
     * @return 商户所在的集团父机构链
     */
    public String getParentMchIds() {
        return parentMchIds;
    }


    public void setParentMchIds(String parentMchIds) {
        this.parentMchIds = parentMchIds;
    }

    /**
     * @return 商户所在的集团（顶级）
     */
    public String getParentTopMoId() {
        return parentTopMoId;
    }


    public void setParentTopMoId(String parentTopMoId) {
        this.parentTopMoId = parentTopMoId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRegAddr() {
        return regAddr;
    }

    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr;
    }

    public String getRegPic() {
        return regPic;
    }

    public void setRegPic(String regPic) {
        this.regPic = regPic;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardFront() {
        return cardFront;
    }

    public void setCardFront(String cardFront) {
        this.cardFront = cardFront;
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardBack(String cardBack) {
        this.cardBack = cardBack;
    }

    public String getRegPicId() {
        return regPicId;
    }

    public void setRegPicId(String regPicId) {
        this.regPicId = regPicId;
    }

    public String getCardFrontId() {
        return cardFrontId;
    }

    public void setCardFrontId(String cardFrontId) {
        this.cardFrontId = cardFrontId;
    }

    public String getCardBackId() {
        return cardBackId;
    }

    public void setCardBackId(String cardBackId) {
        this.cardBackId = cardBackId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgPic() {
        return orgPic;
    }

    public void setOrgPic(String orgPic) {
        this.orgPic = orgPic;
    }

    public String getOrgPicId() {
        return orgPicId;
    }

    public void setOrgPicId(String orgPicId) {
        this.orgPicId = orgPicId;
    }

    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    public String getWxSubMchId() {
        return wxSubMchId;
    }

    public void setWxSubMchId(String wxSubMchId) {
        this.wxSubMchId = wxSubMchId;
    }

    public String getWxSubAppid() {
        return this.wxSubAppid;
    }

    public void setWxSubAppid(String wxSubAppid) {
        this.wxSubAppid = wxSubAppid;
    }

    public float getWxRate() {
        return wxRate;
    }

    public String getWxRateEX() {
        return String.format("%.5f", wxRate);
    }

    public void setWxRate(float wxRate) {
        this.wxRate = wxRate;
    }

    public String getDcMchId() {
        return dcMchId;
    }

    /**
     * 兴业商户号
     *
     * @param dcMchId
     */
    public void setDcMchId(String dcMchId) {
        this.dcMchId = dcMchId;
    }

    /**
     * 兴业appid
     *
     * @return
     */
    public String getDcAppid() {
        return dcAppid;
    }

    /**
     * 兴业appid
     *
     * @return
     */
    public void setDcAppid(String dcAppid) {
        this.dcAppid = dcAppid;
    }

    public Float getDcRate() {
        return dcRate;
    }

    public String getDcRateEX() {
        return String.format("%.5f", dcRate);
    }

    public void setDcRate(Float dcRate) {
        this.dcRate = dcRate;
    }

    public String getDcKey() {
        return dcKey;
    }

    public void setDcKey(String dcKey) {
        this.dcKey = dcKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getMchSuperPwd() {
        return mchSuperPwd;
    }

    public void setMchSuperPwd(String mchSuperPwd) {
        this.mchSuperPwd = mchSuperPwd;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    // @ExcelField(title="经营类目", align=2, sort=100,type=0)
    public MchCategory getCategory() {
        return category;
    }

    public void setCategory(MchCategory category) {
        this.category = category;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public float getAgentRate() {
        return agentRate;
    }

    public void setAgentRate(float agentRate) {
        this.agentRate = agentRate;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String officeIds) {
        this.parentIds = officeIds;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getPrentMchId() {
        return prentMchId;
    }

    public void setPrentMchId(String prentMchId) {
        this.prentMchId = prentMchId;
    }

    public String getTgId() {
        return tgId;
    }

    public void setTgId(String tgId) {
        this.tgId = tgId;
    }

    public String getContractScan() {
        return contractScan;
    }

    public void setContractScan(String contractScan) {
        this.contractScan = contractScan;
    }

    public String getQfOfficeId() {
        return qfOfficeId;
    }

    public void setQfOfficeId(String qfOfficeId) {
        this.qfOfficeId = qfOfficeId;
    }

    /**
     * 渠道类型：1 银行商户 2 点芯商户 3 代理商商户
     *
     * @return
     */
    public String getMchType() {
        return mchType;
    }

    /**
     * 渠道类型：1 银行商户 2 点芯商户 3 代理商商户
     *
     * @return
     */
    public void setMchType(String mchType) {
        this.mchType = mchType;
    }

    public String getMchNewSuperPwd() {
        return mchNewSuperPwd;
    }

    public void setMchNewSuperPwd(String mchNewSuperPwd) {
        this.mchNewSuperPwd = mchNewSuperPwd;
    }

    public String getWxSubAppkey() {
        return wxSubAppkey;
    }

    public void setWxSubAppkey(String wxSubAppkey) {
        this.wxSubAppkey = wxSubAppkey;
    }

    public float getOldDcRate() {
        return oldDcRate;
    }

    public void setOldDcRate(float oldDcRate) {
        this.oldDcRate = oldDcRate;
    }

    //是否允许延迟退款
    public int getIsDelayed() {
        return isDelayed;
    }

    public void setIsDelayed(int isDelayed) {
        this.isDelayed = isDelayed;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getParentMchName() {
        return parentMchName;
    }

    public void setParentMchName(String parentMchName) {
        this.parentMchName = parentMchName;
    }
}
