package com.xiaolong.community.service.impl;

import com.xiaolong.community.common.PreventSubmit;
import com.xiaolong.community.service.IndexRetryService;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * retry重试
 *
 * @author dcl
 * @since 4:18 下午 2021/6/7
 */
@Service
public class IndexRetryServiceImpl implements IndexRetryService {

//    @Override
//    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
//    public void getIndexCode(int code) throws Exception{
//        System.out.println("被调用了" + LocalTime.now());
//        getCode(code);
//    }
//    public void getCode(int code) throws Exception {
//        if (code == 0) {
//            throw new Exception("出了点小问题");
//        }
//    }

    /**
     * 重试之后如果还报错就执行，抛出异常 or 写入日志
     *
     * @param e
     */
    @Recover
    public void recover(Exception e) {
        System.out.println("回调方法执行了！！！"+e.getMessage());
    }



    @Override
    @PreventSubmit(value = 2, sleep = 2000)
    public void getIndexCode(int code) throws Exception {
        System.out.println("被调用了" + LocalTime.now());
        getCode(0);
    }

    public void getCode(int code) throws Exception {
        if (code == 0) {
            throw new Exception("出了点小问题");
        }
        System.out.println("调用成功了");
    }
}
