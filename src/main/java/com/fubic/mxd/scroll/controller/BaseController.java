package com.fubic.mxd.scroll.controller;

import com.fubic.mxd.scroll.service.impl.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("base")
public class BaseController {

    @Autowired
    private SendMailService sendMailService;
    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("hi","Welcome Handsome body");
        return "index";
    }

    @RequestMapping("/email")
    @ResponseBody
    public String sendEmail(){
        sendMailService.sendEmail();
        return "success";
    }
}
