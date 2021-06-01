package com.edu.hzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: HZW
 * @Date: 2021/5/28 10:14 AM
 */
@Controller
public class IndexController {
    // 打开前台首页
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
}
