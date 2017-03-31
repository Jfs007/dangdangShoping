package javamail;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;


public class SendEmailUtil {
	public static String debug="true";
	public static String auth="true";
	public static String host="smtp.qq.com";
	public static String protocol="smtp";
	public static String enable="true";
	public static String sendEmail="aaa945231689@qq.com";
	public static String sendPassword="hebyekuyxgoobegc";
	public SendEmailUtil(){}
	
	//标题，内容，及收件人的邮箱
	public boolean sendEmail(String subject,String context,String reciveEmail) {
			System.out.println("sendEmail");
		 	try {
				Properties props = new Properties();				
//				// 开启debug调试
				props.setProperty("mail.debug", debug);
//				// 发送服务器需要身份验证
				props.setProperty("mail.smtp.auth", auth);
				// 设置邮件服务器主机名
				props.setProperty("mail.host", host);
				// 发送邮件协议名称
				props.setProperty("mail.transport.protocol", protocol);    
				MailSSLSocketFactory sf = new MailSSLSocketFactory();
				sf.setTrustAllHosts(true);
				props.put("mail.smtp.ssl.enable", enable);
				props.put("mail.smtp.ssl.socketFactory", sf);    
				Session session = Session.getInstance(props);    
				Message msg = new MimeMessage(session);
				msg.setSubject(subject);
				StringBuilder builder = new StringBuilder();
				builder.append(context);
				msg.setText(builder.toString());
				msg.setFrom(new InternetAddress(sendEmail));
    
				Transport transport = session.getTransport();
				transport.connect(host, sendEmail, sendPassword);
    
				transport.sendMessage(msg, new Address[] { new InternetAddress(reciveEmail) });
				transport.close();
				return true;
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return false;
	}
}
