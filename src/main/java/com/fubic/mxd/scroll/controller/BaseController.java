package com.fubic.mxd.scroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("base")
public class BaseController {
    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("hi","Welcome Handsome body");
        return "index";
    }
}
