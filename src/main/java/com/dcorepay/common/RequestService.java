package com.dcorepay.common;

/**
 * 这里定义服务层需要请求器标准接口
 */
public interface RequestService {

    //Service依赖的底层请求器必须实现这么�?��接口
    public String post(String url, Object obj);
    public String get(String url);
}
