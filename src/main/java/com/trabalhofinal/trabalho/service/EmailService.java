
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

	public void sendMail(String destinatario, String assunto, RelatorioPedido relatorio) {
		var mailMessage = new SimpleMailMessage();
		mailMessage.setTo(destinatario);
		mailMessage.setSubject(assunto);
	
		String body = "\nRelatório do pedido"
				+ "\nId pedido = " + relatorio.getIdPedido()
				+ "\ndataPedido = " + relatorio.getDataPedido()
				+ "\nvalorTotal = " + relatorio.getResumo().get(0).getValorBruto()
				+ "\nresumo: \n\n"
				+ "\nNome: " + relatorio.getResumo().get(0).getNome()
				+ "\nPreço de venda: " + relatorio.getResumo().get(0).getPrecoVenda()
				+ "\nQuantidade: " + relatorio.getResumo().get(0).getQuantidade()
				+ "\nValor bruto: " + relatorio.getResumo().get(0).getValorBruto()
				+ "\nValor líquido: " + relatorio.getResumo().get(0).getValorLiquido()
				+ "\nPercentual de desconto: " + relatorio.getResumo().get(0).getPercentualDesconto();
		mailMessage.setText(body);
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
			
			String htmlBody = String.format(
					" <h1>Relatório do pedido</h1>"
					+ "    <p>Id do Pedido: %d</p>"
					+ "	   <p>Data do pedido: %s</p>"
					+ "    <p>valorTotal: %f</p>"
					+ "	   <h2>Resumo:</h2>"
					+ "	   <li>Id do Produto: %d</li>"
					+ "    <li>Nome: %s</li>"
					+ "    <li>Preço de venda: %f</li>"
					+ "    <li>Quantidade: %d</li>"
					+ "    <li>ValorBruto: %f</li>"
					+ "    <li>ValorLiquido: %f</li>"
					+ "    <li>Percentual de Desconto: %f</li>", 
					relatorio.getIdPedido(),
					relatorio.getDataPedido(),
					relatorio.getValorTotal(),
					relatorio.getResumo().get(0).getIdProduto(),
					relatorio.getResumo().get(0).getNome(),
					relatorio.getResumo().get(0).getPrecoVenda(),
					relatorio.getResumo().get(0).getQuantidade(),
					relatorio.getResumo().get(0).getValorBruto(),
					relatorio.getResumo().get(0).getValorLiquido(),
					relatorio.getResumo().get(0).getPercentualDesconto());
			boolean html = true;
			helper.setText(htmlBody, html);
			emailSender.send(mimeMessage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

