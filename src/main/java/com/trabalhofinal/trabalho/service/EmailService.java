package com.trabalhofinal.trabalho.service;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.RelatorioPedido;
import com.trabalhofinal.trabalho.dto.ResumoPedido;

@Service
public class EmailService {
	@Autowired
	public JavaMailSender emailSender;

	@Value("${mail.from}")
	private String mailFrom;

	@Value("${spring.mail.host}")
	private String mailHost;

	@Value("${spring.mail.port}")
	private Integer mailPort;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${spring.mail.password}")
	private String password;

	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();

		mailSender.setHost(mailHost);
		mailSender.setPort(mailPort);
		mailSender.setUsername(username);
		mailSender.setPassword(password);

		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		mailSender.setJavaMailProperties(prop);
		return mailSender;
	}

	public EmailService(JavaMailSender javaMailSender) {
		this.emailSender = javaMailSender;
	}

	public void sendMail(String destinatario, String assunto, String mensagem) {
		var mailMessage = new SimpleMailMessage();
		mailMessage.setTo(destinatario);
		mailMessage.setSubject(assunto);
		mailMessage.setText(mensagem);
		mailMessage.setFrom(mailFrom);
		try {
			emailSender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendHtmlMail(String destinatario, String assunto, RelatorioPedido relatorio) {
		
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setSubject(assunto);
			helper.setFrom(mailFrom);
			helper.setTo(destinatario);
			
			boolean html = true;
//			String htmlBody = String.format(
//					" <h1>Relatório do pedido</h1>\r\n"
//					+ "    <p>idPedido</p>%d\r\n"
//					+ "    <p>dataPedido%s</p>\r\n"
//					+ "    <p>valorTotal%d</p>\r\n"
//					+ "    <h2>Resumo:</h2>\r\n"
//					+ "    <ol>\r\n"
//					+ "        <li>idProduto%d</li>\r\n"
//					+ "        <li>nome</li>%s\r\n"
//					+ "        <li>precoVenda</li>%f\r\n"
//					+ "        <li>quantidade</li>%d\r\n"
//					+ "        <li>valorBruto</li>%d\r\n"
//					+ "        <li>valorLiquido</li>%d\r\n"
//					+ "        <li>percentualDesconto%d</li>\r\n"
//					+ "    </ol>", relatorio.getIdPedido(), relatorio.getValorTotal());
			Integer contador = 0;
			
			String htmlBody = String.format(
					" <h1>Relatório do pedido</h1>\r\n"
					+ "    <p>idPedido%d</p>\r\n"
					+ "	   <p>dataPedido%s</p>\\r\\n"
					+ "    <p>valorTotal%d</p>\r\n", 
					relatorio.getIdPedido(),
					relatorio.getDataPedido(), 
					relatorio.getValorTotal());
			String htmlFinal = "";
			relatorio.getResumo().forEach(resumo ->{
				String htmlBody2 = String.format(
						"		<h2>Resumo:</h2>\\r\\\\n"
						+ "		<li>idProduto%d</li>\r\n"
						+ "        <li>nome%s</li>\r\n"
						+ "        <li>precoVenda%s</li>\r\n"
						+ "        <li>quantidade%s</li>\r\n"
						+ "        <li>valorBruto%s</li>\r\n"
						+ "        <li>valorLiquido%d</li>\r\n"
						+ "        <li>percentualDesconto%s</li>", 
						resumo.getIdProduto(),
						resumo.getNome(),
						resumo.getPrecoVenda(),
						resumo.getQuantidade(),
						resumo.getValorBruto(),
						resumo.getValorLiquido(),
						resumo.getPercentualDesconto());
						htmlFinal.concat(htmlBody2);
			});
			
			
			helper.setText(htmlBody + htmlFinal, html);
			emailSender.send(mimeMessage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
