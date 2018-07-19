package com.dcorepay.common;


//import com.dotcore.log.ServerLog;

public class HttpsRequestService extends AbstractHttpsRequestService implements RequestService{
	
	public String post(String url, Object xmlObj){
    	try {
        	if(isHasKey())
        	{	
        		initSSLKey();
        	}
        	else
        	{
        		initNoKey();
        	}
		} catch (Exception e) {
			//ServerLog.error(e.toString());
		}
    	String result = super.post(url, xmlObj);
        return result;
    }
	
	public String get(String url){
    	try {
        	if(isHasKey())
        		initSSLKey();
        	else
        		initNoKey();
		} catch (Exception e) {
			//ServerLog.error(e.toString());
		}
    	String result = super.get(url);
        return result;
    }

}
