package com.dcorepay.common;


import java.io.IOException;
import java.net.SocketTimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;



public abstract class AbstractRequestService implements RequestService{
	
	//请求器的配置
    protected RequestConfig requestConfig;
    //HTTP请求�?
    protected CloseableHttpClient httpClient;
    //连接超时时间，默�?0�?
    private int socketTimeout = 5000;
    //传输超时时间，默�?0�?
    private int connectTimeout = 5000;
    //发�?数据字符�?
    private String charset = "UTF-8";
    //发�?数据类型
    private String contentType = "text/xml";
	
    public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String post(String url, Object obj){

        String result = null;
        HttpPost httpPost = new HttpPost(url);
        StringEntity postEntity = new StringEntity(obj.toString(), this.charset);
        httpPost.addHeader("Content-Type", this.contentType);
        httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(requestConfig);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200)
            {
	            HttpEntity entity = response.getEntity();
	            result = EntityUtils.toString(entity, this.charset);
            }
            else
            {
            	//ServerLog.error("response code:" + response.getStatusLine().getStatusCode());
//            	Header header[] = response.getAllHeaders();
//            	for(int i = 0; i < header.length; i++)
//            	{
//            		ServerLog.info(header[i].toString());
//            	}
            }
        } catch (ConnectionPoolTimeoutException e) {
        	//ServerLog.error(e.toString());
        } catch (ConnectTimeoutException e) {
        	//ServerLog.error(e.toString());
        } catch (SocketTimeoutException e) {
        	//ServerLog.error(e.toString());
        } catch (Exception e) {
        	//ServerLog.error(e.toString());
        } finally {
            httpPost.abort();
        	try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return result;
	}
    
    public String get(String url){
        String result = null;
        HttpGet httpGet = new HttpGet(url);
        //设置请求器的配置
        httpGet.setConfig(requestConfig);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200)
            {
            	HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, this.charset);
            }
            else
            {
            	//ServerLog.error("response code:" + response.getStatusLine().getStatusCode());
            }
        } catch (ConnectionPoolTimeoutException e) {
        	//ServerLog.error(e.toString());
        } catch (ConnectTimeoutException e) {
        	//ServerLog.error(e.toString());
        } catch (SocketTimeoutException e) {
        	//ServerLog.error(e.toString());
        } catch (Exception e) {
        	//ServerLog.error(e.toString());
        } finally {
        	httpGet.abort();
        	try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return result;
	}
}