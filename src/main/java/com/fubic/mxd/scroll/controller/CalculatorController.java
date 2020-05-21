package com.fubic.mxd.scroll.controller;

import com.fubic.mxd.scroll.model.Weapon;
import com.fubic.mxd.scroll.repository.WeaponScrollRepository;
import com.fubic.mxd.scroll.service.ICalculateService;
import com.fubic.mxd.scroll.service.impl.CalculateService;
import com.fubic.mxd.scroll.service.impl.RMQSenderMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.NewsAddress;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mxd")
public class CalculatorController {
    private static final Logger log= LoggerFactory.getLogger(CalculateService.class);

    @Autowired
    ICalculateService calculateService;

    @Autowired
    RMQSenderMailService rmqSenderMailService;

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

//    @RequestMapping(path = "/products/add", method = RequestMethod.GET)
//    public String createProduct(Model model) {
//        model.addAttribute("product", new Product());
//        return "edit";
//    }

    @RequestMapping(value = "/weapon", method = RequestMethod.GET)
    public String calWeapon(Model model){
        model.addAttribute("result","1.五秒钟之内勿重复提交\n2.尽量不要选中所有卷轴\n3.不支持140级一下远古级武器");
        model.addAttribute("weapon", new Weapon());
        setDefaultPage(model);

        return "edit";
    }


    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(@Valid Weapon weapon, BindingResult result, Model model){
        try{
            String[] possibleScrolls = weapon.getPossibleScrolls();
            if(possibleScrolls.length==0)
                throw new Exception("未选中任何卷轴");
            if(result.hasErrors()){
                throw new Exception("请检查您的输入");
            }
            if(weapon.getGrade()!=140 && weapon.getGrade()!=150 && weapon.getGrade()!=160 && weapon.getGrade()!=200)
                throw new Exception("装备等级，装备等级为武器原始装备等级，扣减的等级不算");
            if(possibleScrolls.length >= 6){
                model.addAttribute("result","全选卷轴：结果将以email形式发送给您");
                rmqSenderMailService.sendCalculateMsg(weapon, "fubicheng208@126.com");
            }else{
                model.addAttribute("result", calculateService.getResult(weapon));
            }
        }catch (Exception e){
            model.addAttribute("result","输入有错:" + e.getMessage());
            log.error("计算卷轴页面-输入有错-计算失败:{}", e.getMessage());
        }
        setDefaultPage(model);
        return "edit";
    }

    //待添加，计算饰品
    @RequestMapping(value = "/jewelry", method = RequestMethod.GET)
    public String calJewelry(){
        return "jewelry";
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "error";
    }

    public void setDefaultPage(Model model){
        //设置是否用了X卷
        Map<String, Integer> hasXes = new HashMap<>();
        hasXes.put("是", 1);
        hasXes.put("否", 0);
        model.addAttribute("hasXes", hasXes);

        List<String> scrolls =  new ArrayList<>();
        scrolls.add("惊人卷");
        scrolls.add("RED卷");
        scrolls.add("V卷");
        scrolls.add("星火卷");
        scrolls.add("痕迹");
        scrolls.add("X卷");
        model.addAttribute("scrolls", scrolls);
    }
}
