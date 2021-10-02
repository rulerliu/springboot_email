package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * MailService实现类
 */
@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) throws MailException {
        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 邮件发送者
        message.setTo(to); // 邮件接受者
        message.setSubject(subject); // 主题
        message.setText(content); // 内容

        mailSender.send(message);*/

        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人(取yml文件配置好的发件人)
        message.setFrom(from);
        //邮件主题
        message.setSubject(subject);
        //邮件接收人（用户注册时传的邮件地址）
        message.setTo(to);
        //邮件内容（我这里发送的内容是获取的随机数的验证码）
        message.setText(content);
        //发送邮件
        mailSender.send(message);
    }
}