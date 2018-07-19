package com.dcorepay.services.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySecurityDataInfoSecuritydataQueryRequest;
import com.alipay.api.request.AntMerchantExpandIndirectCreateRequest;
import com.alipay.api.response.AlipaySecurityDataInfoSecuritydataQueryResponse;
import com.alipay.api.response.AntMerchantExpandIndirectCreateResponse;
import com.dcorepay.common.AbstractHttpsRequestService;
import com.dcorepay.dao.CibMchMapper;
import com.dcorepay.datasource.MultipleDataSource;
import com.dcorepay.entities.*;
import com.dcorepay.services.ICibMchService;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CibMchService implements ICibMchService{

	private static Logger logger = Logger.getLogger(CibMchService.class);

	@Autowired
    private CibMchMapper cibMchMapper;
	

	public List<Mch> selectListByTopBankId(Long topBankId) {
		MultipleDataSource.setDataSource("datasource");
		return cibMchMapper.selectListByTopBankId(topBankId);
	}

	public int update(Mch cibMch) {
		MultipleDataSource.setDataSource("datasource1");
		return cibMchMapper.update(cibMch);
	}


	public Map<String, String> generateCodeAli(Mch mch) {
		Map<String, String> map = new HashMap<String, String>();

		MchParentAli mchParentAli = new MchParentAli();
		try {
			Configuration confs = new PropertiesConfiguration("SubmchConfigAli.properties");
			String appid = mchParentAli.getAliAppid();
			String private_key = mchParentAli.getRsaPrivateKey();
			String alipay_public_key = mchParentAli.getAliRsaPublicKey();
			AlipayClient alipayClient = new DefaultAlipayClient(confs.getString("open_api_domain"), appid, private_key, "json", "GBK", alipay_public_key, "RSA");
			// 支付宝风控查询接口
			AlipaySecurityDataInfoSecuritydataQueryRequest securityRequest = new AlipaySecurityDataInfoSecuritydataQueryRequest();
			AlipaySecurityDataInfoSecuritydataQueryResponse securityResponse;

			// 支付宝商户入驻接口
			AntMerchantExpandIndirectCreateRequest createRequest = new AntMerchantExpandIndirectCreateRequest();
			AntMerchantExpandIndirectCreateResponse createResponse = null;

			securityRequest.setBizContent("{" + " \"biz_id\":\"" + confs.getString("security.biz_id") + "\"," + " \"system_name\":\"" + confs.getString("security.system_name") + "\"," + " \"subject\":\"" + mch.getCardNum() + "\","
					+ " \"type\":\"" + confs.getString("security.type") + "\"," + " \"ext\":\"{\\\"extend_param_key\\\":\\\"extend_param_value\\\"}\"" + " }");
			securityResponse = alipayClient.execute(securityRequest);
			if ((securityResponse == null || securityResponse.getResult() == null) || (securityResponse.isSuccess() && securityResponse.getResult().contains("noRisk"))) {
				// 商户无风险
				String externalId = mch.getExternalId(); // 二级商户编号,由受理机构定义,需要保证在受理机构下唯一
				String name = mch.getMchName(); // 二级商户名称
				String alias_name = mch.getAbbrName() + mch.getId(); // 二级商户简称
				String service_phone = mch.getCustTel(); // 客服电话
				String category_id = mch.getAliCategory().getId()+""; // 支付宝经营类目
				String  source = mch.getAliPid();
				String business_license = mch.getBusinessLicense(); // 商户证件编号
				String business_license_type = mch.getLicenseType(); // 商户证件类型

				/** 联系人信息 */
				String contactName = mch.getContact(); // 联系人名称
				String contactType = mch.getContactType(); // 联系人类型
				String id_card_no = mch.getCardNum(); // 身份证号码

				/** 商户地址信息 */
				String province_code = mch.getProvinceCode(); // 商户所在省份编码
				String city_code = mch.getCityCode(); // 商户所在城市编码
				String district_code = mch.getDistrictCode(); // 商户所在区县编码
				String address = mch.getAddress(); // 商户详细经营地址

				/** 商户对应银行所开立的结算卡信息 */
				String card_no = mch.getBankAcct(); // 银行卡号
				String card_name = mch.getAcctName(); // 银行卡持卡人姓名

				if (false) {
					map.put("result", "0");
					map.put("code", "");
					map.put("errmsg", "该商户已生成支付宝商户识别码，不能再次生成！");
				} else {
					String BizRequest = "{" + " \"external_id\":\"" + externalId + "\"," // 二级商户编号,由受理机构定义,需要保证在受理机构下唯一
							+ " \"name\":\"" + name + "\"," // 商户名称

							+ " \"service_phone\":\"" + service_phone + "\"," // 商户客服电话
							+ " \"category_id\":\"" + category_id + "\"," // 商户经营类目
							+ " \"source\":\"" + source + "\"," // 支付宝PID
							+ ((business_license == null || (business_license.trim().length() == 0)) ? "" : " \"business_license\":\"" + business_license + "\",") // 商户证件编号
							+ ((business_license_type == null || (business_license_type.trim().length() == 0)) ? "" : " \"business_license_type\":\"" + business_license_type + "\",") // 商户证件类型
							+ " \"contact_info\":[{" // 商户联系人信息
							+ " \"type\":\"" + contactType + "\"," // 联系人类型，取值范围：LEGAL_PERSON
							// 法人；CONTROLLER
							// 实际控制人；AGENT
							// 代理人；OTHER
							// 其他
							+ ((id_card_no == null || (id_card_no.trim().length() == 0)) ? "" : " \"id_card_no\":\"" + id_card_no + "\",") // 身份证号
							+ " \"name\":\"" + contactName + "\"" // 联系人名字
							+ "}],";
					if (province_code != null && province_code.trim().length() != 0 && city_code != null && city_code.trim().length() != 0 && district_code != null && district_code.trim().length() != 0 && address != null
							&& address.trim().length() != 0) {
						String temp = "" + " \"address_info\":[{" // 商户地址信息
								+ " \"province_code\":\"" + province_code + "\"," // 商户所在省份编码
								+ " \"city_code\":\"" + city_code + "\"," // 商户所在城市编码
								+ " \"district_code\":\"" + district_code + "\"," // 商户所在区县编码
								+ " \"address\":\"" + address + "\"" // 商户详细经营地址
								+ "}],";
						BizRequest += temp;
					}
					if (card_no != null && card_no.trim().length() != 0 && card_name != null && card_name.trim().length() != 0) {
						String temp = "" + " \"bankcard_info\":[{" // 商户对应银行所开立的结算卡信息
								+ " \"card_no\":\"" + card_no + "\"," // 银行卡号
								+ " \"card_name\":\"" + card_name + "\"" // 银行卡持卡人姓名
								+ "}],";
						BizRequest += temp;
					}
					BizRequest += " \"alias_name\":\"" + alias_name + "\"" // 商户简称
							+ " }";

					createRequest.setBizContent(BizRequest);
					logger.info("支付宝间连分级商户入驻请求参数：" + createRequest.getBizContent());
					createResponse = alipayClient.execute(createRequest);
					String subMerchatId = createResponse.getSubMerchantId();
					if (subMerchatId != null && StringUtils.isNotBlank(subMerchatId)) {
						map.put("result", "1");
						map.put("code", subMerchatId);
						map.put("errmsg", "");
					} else {
						map.put("result", "0");
						map.put("code", "");
						map.put("errmsg", createResponse.getSubMsg());
					}
				}
			} else if (securityResponse.isSuccess() && securityResponse.getResult().contains("hasRisk")) {
				map.put("result", "0");
				map.put("code", "");
				map.put("errmsg", "支付宝查询接口反馈：该商户存在风险，禁止开通");
			} else {
				map.put("result", "0");
				map.put("code", "");
				map.put("errmsg", "支付宝商户风控查询接口异常，请重试");
			}

		} catch (ConfigurationException e) {
			e.printStackTrace();
			map.put("result", "0");
			map.put("code", "");
			map.put("errmsg", "生成支付宝商户识别码失败" + e.toString());
		} catch (AlipayApiException e) {
			e.printStackTrace();
			map.put("result", "0");
			map.put("code", "");
			map.put("errmsg", "生成支付宝商户识别码失败" + e.toString());
		}

		return map;
	}

	public Map<String, String> getCodeOrGenerate(Mch mch) {
		Map<String, String> map = new HashMap<String, String>();
		String strReturn = null;
		String tgId = mch.getTgId();
		String mchName = mch.getMchName();
		String categoryId = mch.getCategory().getId();
		String shortName = mch.getAbbrName();
		String servicePhone = mch.getCustTel();
		String contact = mch.getContact();
		String contactPhone = mch.getMobile();
		String contactEmail = mch.getEmail();
		int bussinessId = 0;
		if (StringUtils.isNoneBlank(categoryId)) {
			bussinessId = Integer.valueOf(categoryId);
		}
		String remark = mch.getAbbrName() + mch.getId();
		Merchant oldMch = MchManager.getMchPage(tgId, mchName, 1, 30, "");// 通过名称查询是否已经存在，如果存在则直接返回，否则调用生成
		if (oldMch == null) {
			strReturn = MchManager.addMch(tgId, mchName, shortName, servicePhone, contact, contactPhone, contactEmail, bussinessId, remark,mch.getSource());
		} else {
			String mchId = oldMch.getSubMerchantList().get(0).getMch_id();
			strReturn = "SUCCESS" + "|" + mchId;
		}
		String[] arr = strReturn.split("\\|");
		if ("SUCCESS".equals(arr[0].trim())) {
			map.put("result", "1");
			map.put("code", arr[1].trim());
			map.put("errmsg", "");
			// addMessage(redirectAttributes, "生成商户识别码成功,识别码为："+arr[1].trim());
		} else if ("FAIL".equals(arr[0].trim())) {
			map.put("result", "0");
			map.put("code", "");
			map.put("errmsg", arr[1].trim());
		} else {
			map.put("errmsg", "生成操作失败！");
		}
		return map;
	}
}