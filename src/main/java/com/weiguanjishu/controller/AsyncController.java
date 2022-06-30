package com.weiguanjishu.controller;

import com.weiguanjishu.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author onlyone
 * @create 2022/6/28
 */
@RestController
@RequestMapping("/wx/tomge/async/")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    /**
     * 访问地址：http://127.0.0.1:8090/wx/tomge/async/run?count=10
     */
    @RequestMapping("/run")
    public Object run(@RequestParam(value = "count") Integer count) {

        for (int i = 1; i <= count; i++) {
            asyncService.execute(i);
        }
        return "success";

    }
}
