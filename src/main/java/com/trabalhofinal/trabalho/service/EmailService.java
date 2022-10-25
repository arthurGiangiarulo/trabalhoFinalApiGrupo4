//package com.trabalhofinal.trabalho.service;
//
//import java.util.Properties;
//
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import com.trabalhofinal.trabalho.dto.RelatorioPedido;
//
//@Service
//public class EmailService {
//	@Autowired
//	public JavaMailSender emailSender;
//
//	@Value("${mail.from}")
//	private String mailFrom;
//
//	@Value("${spring.mail.host}")
//	private String mailHost;
//
//	@Value("${spring.mail.port}")
//	private Integer mailPort;
//
//	@Value("${spring.mail.username}")
//	private String username;
//
//	@Value("${spring.mail.password}")
//	private String password;
//
//	public JavaMailSender javaMailSender() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		Properties prop = new Properties();
//
//		mailSender.setHost(mailHost);
//		mailSender.setPort(mailPort);
//		mailSender.setUsername(username);
//		mailSender.setPassword(password);
//
//		prop.put("mail.smtp.auth", true);
//		prop.put("mail.smtp.starttls.enable", true);
//		mailSender.setJavaMailProperties(prop);
//		return mailSender;
//	}
//
//	public EmailService(JavaMailSender javaMailSender) {
//		this.emailSender = javaMailSender;
//	}
//
//	public void sendMail(String destinatario, String assunto, String mensagem) {
//		var mailMessage = new SimpleMailMessage();
//		mailMessage.setTo(destinatario);
//		mailMessage.setSubject(assunto);
//		mailMessage.setText(mensagem);
//		mailMessage.setFrom(mailFrom);
//		try {
//			emailSender.send(mailMessage);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void sendHtmlMail(String destinatario, String assunto, RelatorioPedido relatorio) {
//		MimeMessage mimeMessage = emailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
//		try {
//			helper.setSubject(assunto);
//			helper.setFrom(mailFrom);
//			helper.setTo(destinatario);
//			
//			boolean html = true;
//			String htmlBody = String.format("<b>Hey %d<b>,<br><i>%dI am the API</i>", relatorio.getIdPedido(), relatorio.getValorTotal());
//			helper.setText(htmlBody, html);
//			emailSender.send(mimeMessage);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
