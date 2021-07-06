package com.xiaolong.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaolong1994
 */
@RestController
public class IndexController {

    /**
     * 默认显示index界面
     */
    @GetMapping("/index")
    public String index(){
        return "打印一行文字,显示XXXX";
    }

}


