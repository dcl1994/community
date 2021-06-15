package com.xiaolong.myblog.service;

/**
 * 首页重试注解
 * @author dcl
 * @since 4:17 下午 2021/6/7
 */
public interface IndexRetryService {

    void getIndexCode(int code) throws Exception;
}
