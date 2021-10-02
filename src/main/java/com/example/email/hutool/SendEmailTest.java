package com.example.email.hutool;

import com.alibaba.fastjson.JSONObject;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
 
public class SendEmailTest {

	public static void main(String[] args) throws Exception {
		sendEmail(null, null);
	}

	public static void sendEmail(JSONObject config,String email) throws Exception {
		///MailcapCommandMap mailcapCommandMap = new MailcapCommandMap();
		//mailcapCommandMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		//mailcapCommandMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		//mailcapCommandMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		//mailcapCommandMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		//mailcapCommandMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		//Thread.currentThread().setContextClassLoader(AssetProofOpenSubmitAction.class.getClassLoader());
 
		Properties props = new Properties();
	    props.put("mail.transport.protocol", "smtp");  //smtp服务器
	    props.put("mail.smtp.host", "smtp.qq.com");     //主机host
	    props.put("mail.smtp.auth", "true");    //
	    props.put("mail.smtp.port", "25");    //端口
 
	    Session session = Session.getDefaultInstance(props, new Authenticator()
	    {
	      protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication("liu729754701@qq.com","uhfiytdmkdnhbbjc");
	      }
	    });
		
	    
		session.setDebug(true);
	   
		
		Message message = createAttachMail(session);
		Transport.send(message);
 
	}
	
	
	
	
	
	
	public static MimeMessage createAttachMail(Session session)
			throws Exception {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("liu729754701@qq.com"));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress("liuwenqiang@shsnc.com"));
				message.setSubject("只包含文本的简单邮件");
				message.setContent("你好啊123123123！", "text/html;charset=UTF-8");
				return message;
			}
 
	
}