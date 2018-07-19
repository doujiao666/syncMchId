package com.dcorepay.common;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;

public class HttpRequestService extends AbstractRequestService implements RequestService{

	@Override
	public String post(String url, Object obj) {
		 this.httpClient = HttpClients.custom().build();
		//根据默认超时限制初始化requestConfig
		requestConfig = RequestConfig.custom().setSocketTimeout(getSocketTimeout()).setConnectTimeout(getConnectTimeout()).build();
		return super.post(url, obj);
	}
	
	public String get(String url) {
		 this.httpClient = HttpClients.custom().build();
		//根据默认超时限制初始化requestConfig
		requestConfig = RequestConfig.custom().setSocketTimeout(getSocketTimeout()).setConnectTimeout(getConnectTimeout()).build();
		return super.get(url);
	}
}