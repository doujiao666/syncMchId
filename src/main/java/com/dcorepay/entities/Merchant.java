package com.dcorepay.entities;

import java.util.ArrayList;
import java.util.List;

public class Merchant {

	private String mch_id;
	private String merchant_name;
	private String merchant_shortname;
	private String service_phone;
	private String contact;
	private String contact_phone;
	private String contact_email;
	private String business;
	private String merchant_remark;
	private List<Merchant> subMerchantList=new ArrayList();
	/**
	 * @return the mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**
	 * @param mch_id the mch_id to set
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**
	 * @return the merchant_name
	 */
	public String getMerchant_name() {
		return merchant_name;
	}
	/**
	 * @param merchant_name the merchant_name to set
	 */
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	/**
	 * @return the merchant_shortname
	 */
	public String getMerchant_shortname() {
		return merchant_shortname;
	}
	/**
	 * @param merchant_shortname the merchant_shortname to set
	 */
	public void setMerchant_shortname(String merchant_shortname) {
		this.merchant_shortname = merchant_shortname;
	}
	/**
	 * @return the service_phone
	 */
	public String getService_phone() {
		return service_phone;
	}
	/**
	 * @param service_phone the service_phone to set
	 */
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the contact_phone
	 */
	public String getContact_phone() {
		return contact_phone;
	}
	/**
	 * @param contact_phone the contact_phone to set
	 */
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	/**
	 * @return the contact_email
	 */
	public String getContact_email() {
		return contact_email;
	}
	/**
	 * @param contact_email the contact_email to set
	 */
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	/**
	 * @return the business
	 */
	public String getBusiness() {
		return business;
	}
	/**
	 * @param business the business to set
	 */
	public void setBusiness(String business) {
		this.business = business;
	}
	/**
	 * @return the merchant_remark
	 */
	public String getMerchant_remark() {
		return merchant_remark;
	}
	/**
	 * @param merchant_remark the merchant_remark to set
	 */
	public void setMerchant_remark(String merchant_remark) {
		this.merchant_remark = merchant_remark;
	}
	/**
	 * @return the subMerchantList
	 */
	public List<Merchant> getSubMerchantList() {
		return subMerchantList;
	}
	/**
	 * @param subMerchantList the subMerchantList to set
	 */
	public void setSubMerchantList(List<Merchant> subMerchantList) {
		this.subMerchantList = subMerchantList;
	}
	
}
