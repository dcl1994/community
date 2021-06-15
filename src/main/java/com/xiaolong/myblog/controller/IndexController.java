package com.xiaolong.myblog.controller;

import com.xiaolong.myblog.service.IndexRetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 *
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
}


