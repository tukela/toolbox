package com.hl.kit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: honglei
 * @Date: 2019/3/26 17:03
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Controller
public class UserController {
    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "/index";
    }
}
