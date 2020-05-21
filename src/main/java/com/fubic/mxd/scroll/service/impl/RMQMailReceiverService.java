package com.fubic.mxd.scroll.service.impl;

import com.fubic.mxd.scroll.dto.WeaponEmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RMQMailReceiverService {
    public static final Logger log = LoggerFactory.getLogger(RMQMailReceiverService.class);

    @Autowired
    CalculateService calculateService;

    @Autowired
    SendMailService sendMailService;

    /**
    * @Description: 根据RabbitMQ收到的消息，执行武器卷轴计算, 并发送结果给用户邮箱
    * @Param:
    * @return:
    * @Author: fubicheng
    * @Date: 2020/5/21
    */
    @RabbitListener(queues = {"${mq.mxd.success.email.queue}"}, containerFactory = "singleListenerContainer")
    public void consumeWeaponEmailMsg(WeaponEmailDTO weaponEmailDTO){
        try{
            log.info("计算卷轴任务-接收到武器数据为：{}", weaponEmailDTO);
            String result = calculateService.getResult(weaponEmailDTO.getWeapon());
            sendMailService.sendCalculateWeaponEmail(weaponEmailDTO.getEmail(), result);
            log.info("计算卷轴任务-发送计算结果邮件-成功");
        }catch (Exception e){
            log.error("计算卷轴任务-失败：", e.fillInStackTrace());
        }
    }
}
