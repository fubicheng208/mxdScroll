package com.fubic.mxd.scroll.service.impl;

import com.fubic.mxd.scroll.service.ISendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @author 11108420
 * @date 2020/5/18 18:09
 */

@Service
public class SendMailService implements ISendMailService {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Override
    public void sendEmail() {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setSubject("email测试");
        smm.setText("正文");
        smm.setTo("fubicheng208@126.com");
        smm.setFrom("651011591@qq.com");
        javaMailSender.send(smm);
    }
}
