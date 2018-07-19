package com.dcorepay.common;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

@SuppressWarnings("deprecation")
public abstract class AbstractHttpsRequestService extends AbstractRequestService implements RequestService{

	private static Logger ServerLog = Logger.getLogger(AbstractHttpsRequestService.class);

	//是否有HTTPS证书
	private boolean hasKey = true;
	//HTTPS证书的本地路径
	private String certPath="c:/apiclient_cert.35.p12";
	//HTTPS证书密码
	private String certPassword="1270974701";
	
    private SSLSocketFactory ssf;
	
	private SSLConnectionSocketFactory sslsf;
	
    public boolean isHasKey() {
		return hasKey;
	}

	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}

	public String getCertPath() {
		return certPath;
	}

	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}

	public String getCertPassword() {
		return certPassword;
	}

	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}
	
    //表示请求器是否已经做了初始化工作
    private boolean hasInit = false;
   
    protected void initSSLKey() throws Exception {
    	if(!hasInit)
    	{
	        KeyStore keyStore = null;
			try {
				keyStore = KeyStore.getInstance("PKCS12");
			} catch (KeyStoreException e1) {
				ServerLog.error(e1.toString());
			}
			FileInputStream fis=null;
	        try {
	            fis = new FileInputStream(new File(certPath));//加载本地的证书进行https加密传输
	            keyStore.load(fis, certPassword.toCharArray());//设置证书密码
	        } catch (CertificateException e) {
	        	ServerLog.error(e.toString());
	        } catch (NoSuchAlgorithmException e) {
	        	ServerLog.error(e.toString());
	        } finally {
	            if(fis!=null)
	            {
	        	fis.close();
	            }
	        }
	
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = null;
			try {
				sslcontext = SSLContexts.custom()
				        .loadKeyMaterial(keyStore, certPassword.toCharArray())
				        .build();
			} catch (KeyManagementException e) {
				ServerLog.error(e.toString());
			} catch (UnrecoverableKeyException e) {
				ServerLog.error(e.toString());
			} catch (NoSuchAlgorithmException e) {
				ServerLog.error(e.toString());
			} catch (KeyStoreException e) {
				ServerLog.error(e.toString());
			}
	        // Allow TLSv1 protocol only
	        sslsf = new SSLConnectionSocketFactory(
	                sslcontext,
	                new String[]{"TLSv1"},
	                null,
	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	
	        //根据默认超时限制初始化requestConfig
	        requestConfig = RequestConfig.custom().setSocketTimeout(getSocketTimeout()).setConnectTimeout(getConnectTimeout()).build();
	
	        hasInit = true;
    	}
        
        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
    }
    
    protected void initNoKey() throws Exception {
    	httpClient = new DefaultHttpClient();
    	if(!hasInit)
    	{
	    	try{
		    	SSLContext ctx = SSLContext.getInstance("TLS");
		        X509TrustManager tm = new X509TrustManager() {
		                @Override
		                public void checkClientTrusted(X509Certificate[] chain,
		                        String authType) throws CertificateException {
		                }
		                @Override
		                public void checkServerTrusted(X509Certificate[] chain,
		                        String authType) throws CertificateException {
		                }
		                @Override
		                public X509Certificate[] getAcceptedIssuers() {
		                    return null;
		                }
		        };
		        ctx.init(null, new TrustManager[]{tm}, null);
		        ssf = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	       	}catch(Exception e)
	    	{
	       		ServerLog.error(e.toString());
	    	}
	        //根据默认超时限制初始化requestConfig
	        requestConfig = RequestConfig.custom().setSocketTimeout(getSocketTimeout()).setConnectTimeout(getConnectTimeout()).build();
	
	        hasInit = true;
    	}
        httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, ssf));
    }
}
