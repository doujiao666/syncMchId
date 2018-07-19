package com.dcorepay.services.impl;

import com.dcorepay.common.*;
import com.dcorepay.entities.Merchant;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class MchManager {
    public static void main(String[] args) throws Exception {
        // String result=getMchPage("1","",1,20,"小明");
        // System.out.println(result);
    	MchManager.getMchPage("1", "", 1, 10, "12836441");
    }

    /**
     * @param tgId
     * @param subMchId
     *            商户识别码
     * @return 成功返回：SUCCESS|成功消息 /FAIL|失败原因
     */
    public static String deleteMch(String tgId, String subMchId) {
        SortedMap<String, String> map = new TreeMap<String, String>();
        String key = null;
        String strReturn = null;
        HttpsRequestService s = new HttpsRequestService();
         if (tgId.equals(SubmchConfig.tgId_35)) {
            map.put("appid", SubmchConfig.appid_35);
            map.put("mch_id", SubmchConfig.mchId_35);
            key = SubmchConfig.key_35;
            s.setCertPassword(SubmchConfig.certPassword_35);
            s.setCertPath(SubmchConfig.certPath_35);
        }
        map.put("sub_mch_id", subMchId);
        // String key = "12345678abcdabcdabcdabcdabcdabcd";
        Map<String, String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() + 1) * 10);
        SignUtils.buildPayParams(buf, params, false);
        String preStr = buf.toString();
        String sign = MD5.encode(preStr + "&key=" + key, "utf-8");
        map.put("sign", sign.toUpperCase());
        String xml = XmlUtils.parseXML(map);
        System.out.println("reqParams:" + xml);
        // HttpsRequestService s = new HttpsRequestService();
        String result = s.post(SubmchConfig.mchDelete, xml);
        if (result != null) {
            Map<String, String> resultMap = XmlUtils.toMap(result);
            String value = resultMap.get("return_code");// 通讯结果
            if ("SUCCESS".equals(value)) {
                strReturn = "SUCCESS" + "|" + "";
            } else if ("FAIL".equals(value)) {
                strReturn = "FAIL|" + resultMap.get("return_msg");// 一般为通信错误
            }

        }
        return strReturn;

    }

    /**
     * 修改商户
     * 
     * @param tgId
     * @param subMchId
     *            商户识别码
     * @param mchShortName
     *            商户简称
     * @param servicePhone
     *            客户电话
     * @param contact
     *            联系人
     * @return
     */
    public static String mchModify(String tgId, String subMchId, String mchShortName, String servicePhone, String contact) {
        SortedMap<String, String> map = new TreeMap<String, String>();
        String key = null;
        String strReturn = null;
        HttpsRequestService s = new HttpsRequestService();
         if (tgId.equals(SubmchConfig.tgId_35)) {
            map.put("appid", SubmchConfig.appid_35);
            map.put("mch_id", SubmchConfig.mchId_35);
            key = SubmchConfig.key_35;
            s.setCertPassword(SubmchConfig.certPassword_35);
            s.setCertPath(SubmchConfig.certPath_35);
        }
        map.put("sub_mch_id", subMchId.trim());
        map.put("merchant_shortname", mchShortName.trim());
        map.put("service_phone", servicePhone.trim());
        map.put("contact", contact.trim());

        Map<String, String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() + 1) * 10);
        SignUtils.buildPayParams(buf, params, false);
        String preStr = buf.toString();
        String sign = MD5.encode(preStr + "&key=" + key, "utf-8");
        map.put("sign", sign.toUpperCase());
        String xml = XmlUtils.parseXML(map);
        System.out.println("reqParams:" + xml);
        String result = s.post(SubmchConfig.mchModify, xml);
        if (result != null) {
            Map<String, String> resultMap = XmlUtils.toMap(result);
            String value = resultMap.get("return_code");// 通讯结果
            if ("SUCCESS".equals(value)) {
                String execResult = resultMap.get("result_code");
                if ("SUCCESS".equals(execResult)) {
                    strReturn = "SUCCESS" + "|" + resultMap.get("sub_mch_id");
                } else if ("FAIL".equals(execResult)) {
                    strReturn = "FAIL|" + resultMap.get("result_msg");
                }

            } else if ("FAIL".equals(value)) {
                strReturn = "FAIL|" + resultMap.get("return_msg");// 一般为通信错误
            }

        }
        return strReturn;
    }

    public static String addMch(String tgId, String mchName, String shortName, String servicePhone, String contact, String contactPhone, String contactEmail, int bussinessId, String remark,String wxSource) {
        SortedMap<String, String> map = new TreeMap<String, String>();
        // map.put("appid", "wxd4b88facae91ecb3");
        // map.put("mch_id", "1270974701");
        String strReturn = null;
        String key = null;
        HttpsRequestService s = new HttpsRequestService();
        if (tgId.equals(SubmchConfig.tgId_35)) {
            map.put("appid", SubmchConfig.appid_35);
            map.put("mch_id", SubmchConfig.mchId_35);
            key = SubmchConfig.key_35;
            s.setCertPassword(SubmchConfig.certPassword_35);
            s.setCertPath(SubmchConfig.certPath_35);
        }
        map.put("merchant_name", mchName);
//        map.put("merchant_name", "福建点芯在线网络技术有限公司");
        map.put("merchant_shortname", shortName);
        map.put("service_phone", servicePhone);
        map.put("contact", contact);
        map.put("contact_phone", contactPhone);
        map.put("contact_email", contactEmail);
        map.put("business", String.valueOf(bussinessId));// 企业>餐饮/食品>普通食品
//        map.put("merchant_remark", remark);
        map.put("merchant_remark", remark);
        if(StringUtils.isNotBlank(wxSource)){
            map.put("channel_id",wxSource);
        }else{
            map.put("channel_id", "56034702");//兴业渠道号
        }
        // String key = "12345678abcdabcdabcdabcdabcdabcd";
        Map<String, String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() + 1) * 10);
        SignUtils.buildPayParams(buf, params, false);
        String preStr = buf.toString();

        String sign = MD5.encode(preStr + "&key=" + key, "utf-8");
        map.put("sign", sign.toUpperCase());
        String xml = XmlUtils.parseXML(map);
        System.out.println("reqParams:" + xml);
        // HttpsRequestService s = new HttpsRequestService();
        String result = s.post(SubmchConfig.mchAdd, xml);
        if (result != null) {
            Map<String, String> resultMap = XmlUtils.toMap(result);
            String value = resultMap.get("return_code");// 通讯结果
            if ("SUCCESS".equals(value)) {
                String execResult = resultMap.get("result_code");
                if ("SUCCESS".equals(execResult)) {
                    strReturn = "SUCCESS" + "|" + resultMap.get("sub_mch_id");
                } else if ("FAIL".equals(execResult)) {
                    strReturn = "FAIL|" + resultMap.get("result_msg");
                }

            } else if ("FAIL".equals(value)) {
                strReturn = "FAIL|" + resultMap.get("return_msg");// 一般为通信错误
            }

        }
        return strReturn;
    }

    /**
     * 商户查询
     * 
     * @param mchName
     *            商户名称
     * @param pageIndex
     *            页码
     * @param pageSize
     *            每页条数
     * @param subMchId
     *            商户识别码
     * 
     * @return
     * 
     *         <?xml version="1.0" encoding="UTF-8"?>
     *         <root><return_code><![CDATA[SUCCESS]]></return_code>
     *         <return_msg><![CDATA[]]></return_msg>
     *         <result_code><![CDATA[SUCCESS]]></result_code>
     *         <result_msg><![CDATA[查询商户资料成功]]></result_msg>
     *         <mchinfo> <mch_id>10647539</mch_id>
     *         <merchant_name><![CDATA[兴业银行股份有限公司福州分行]]></merchant_name>
     *         <merchant_shortname><![CDATA[兴业银行股份有限公司福州分行]]>
     *         </merchant_shortname> <service_phone><![CDATA[]]></service_phone>
     *         <contact><![CDATA[原智超]]></contact>
     *         <contact_phone><![CDATA[18959195219]]></contact_phone>
     *         <contact_email><![CDATA[yzhichao@qq.com]]></contact_email>
     *         <business><![CDATA[189]]></business>
     *         <merchant_remark><![CDATA[]]></merchant_remark> </mchinfo>
     *         <mchinfo> <mch_id>10979482</mch_id>
     *         <merchant_name><![CDATA[福建小明电子商务有限公司]]></merchant_name>
     *         <merchant_shortname><![CDATA[小明电商]]></merchant_shortname>
     *         <service_phone><![CDATA[4006611900]]></service_phone>
     *         <contact><![CDATA[杨斌]]></contact>
     *         <contact_phone><![CDATA[15959097675]]></contact_phone>
     *         <contact_email><![CDATA[15959097675@139.com]]></contact_email>
     *         <business><![CDATA[88]]></business>
     *         <merchant_remark><![CDATA[包装食品、散装食品]]></merchant_remark>
     *         </mchinfo> <total>1</total> </root>
     */
    public static Merchant getMchPage(String tgId, String mchName, int pageIndex, int pageSize, String subMchId) {
        SortedMap<String, String> map = new TreeMap<String, String>();
        String key = null;
        HttpsRequestService s = new HttpsRequestService();
        String parentmchId = null;
         if (tgId.equals(SubmchConfig.tgId_35)) {
            map.put("appid", SubmchConfig.appid_35);
            map.put("mch_id", SubmchConfig.mchId_35);
            key = SubmchConfig.key_35;
            s.setCertPassword(SubmchConfig.certPassword_35);
            s.setCertPath(SubmchConfig.certPath_35);
        }
        parentmchId = map.get("mch_id");// 备留
        map.put("merchant_name", mchName);
        map.put("page_index", String.valueOf(pageIndex));
        map.put("page_size", String.valueOf(pageSize));
        map.put("sub_mch_id", subMchId);
        // String key = "12345678abcdabcdabcdabcdabcdabcd";
        Map<String, String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() + 1) * 10);
        SignUtils.buildPayParams(buf, params, false);
        String preStr = buf.toString();

        String sign = MD5.encode(preStr + "&key=" + key, "utf-8");
        map.put("sign", sign.toUpperCase());
        String xml = XmlUtils.parseXML(map);
        System.out.println("reqParams:" + xml);
        // HttpsRequestService s = new HttpsRequestService();
        String result = s.post(SubmchConfig.submchmanageQuery, xml);
        // System.out.println(result);
        Merchant ret = parseXml(result, parentmchId);
        return ret;
    }

    @SuppressWarnings("unchecked")
    private static Merchant parseXml(String result, String parentMchId) {
        Merchant mch = null;
        try {
            if (result != null) {
                Map<String, Object> resultMap = XmlUtils.toMap2(result);
                if ("SUCCESS".equals(resultMap.get("result_code"))) {
                    String returncode = resultMap.get("return_code").toString();
                    if ("SUCCESS".equals(returncode)) {
                        int total = Integer.valueOf(resultMap.get("total").toString());
                        // String string =
                        // JSONObject.fromObject(map).toString();
                        if (total > 0) {
                            mch = new Merchant();
                            ArrayList<Object> arr = (ArrayList<Object>) resultMap.get("mchinfo");
                            for (int i = 0; i < arr.size(); i++) {
                                Map<String, String> tmp = (Map<String, String>) arr.get(i);
                                if (/* parentMchId.equals(tmp.get("mch_id")) */"189".equals(tmp.get("business"))) {
                                    mch.setBusiness(tmp.get("business"));
                                    mch.setContact(tmp.get("contact"));
                                    mch.setContact_email(tmp.get("contact_email"));
                                    mch.setContact_phone(tmp.get("contact_phone"));
                                    mch.setMch_id(tmp.get("mch_id"));
                                    mch.setMerchant_name(tmp.get("merchant_name"));
                                    mch.setMerchant_shortname(tmp.get("merchant_shortname"));
                                    mch.setMerchant_remark(tmp.get("merchant_remark"));
                                    mch.setService_phone(tmp.get("service_phone"));
                                } else {
                                    Merchant submch = new Merchant();
                                    submch.setBusiness(tmp.get("business"));
                                    submch.setContact(tmp.get("contact"));
                                    submch.setContact_email(tmp.get("contact_email"));
                                    submch.setContact_phone(tmp.get("contact_phone"));
                                    submch.setMch_id(tmp.get("mch_id"));
                                    submch.setMerchant_name(tmp.get("merchant_name"));
                                    submch.setMerchant_shortname(tmp.get("merchant_shortname"));
                                    submch.setMerchant_remark(tmp.get("merchant_remark"));
                                    submch.setService_phone(tmp.get("service_phone"));
                                    mch.getSubMerchantList().add(submch);
                                }

                            }
                        }
                    } else if ("FAIL".equals(returncode)) {

                    }
                } else if ("FAIL".equals(resultMap.get("result_code"))) {

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mch;
    }
}
