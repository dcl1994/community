package com.xiaolong.myblog.controller;

import com.xiaolong.myblog.service.IndexRetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xiaolong1994
 */
@RestController
public class IndexController {

    @Resource
    private IndexRetryService indexRetryService;

    /**
     * 默认显示index界面
     */
    @GetMapping("/index")
    public void index() throws Exception {
        int code = 0;
        indexRetryService.getIndexCode(code);
    }

//    public static void main(String[] args) {
//
//        List<String> list = Arrays.asList("a,b,c","1,2,3");
//        //将每个元素转成一个新的且不带逗号的元素
//        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",",""));
//        s1.forEach(System.out::println);
//
//        Stream<String> s3 = list.stream().flatMap( s ->{
//            //将每个元素转换成一个steam
//            String[] split = s.split(",");
//            Stream<String> s2 = Arrays.stream(split);
//            return s2;
//        });
//
//
//    }

}


