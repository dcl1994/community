package com.xiaolong.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiaolong1994
 * @title: IndexController
 * @projectName market-goods
 * @description: TODO
 * @date 2020/6/512:00 PM
 */
@Controller
public class IndexController {

    /**
     * 默认显示index界面
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }



}


