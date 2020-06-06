package com.xiaolong.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaolong1994
 * @title: IndexController
 * @projectName market-goods
 * @description: TODO
 * @date 2020/6/512:00 PM
 */
@Controller
public class IndexController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name",required = false,defaultValue = "小龙") String name, Model
            model){
        model.addAttribute("name",name);
        return "hello";
    }

}


