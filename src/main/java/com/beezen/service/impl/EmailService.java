package com.beezen.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import com.beezen.domain.Utilisateurs;
import com.beezen.exeption.CustomException;
import com.beezen.service.IEmailService;


@Service
public class EmailService implements IEmailService{
	
	@Autowired
    public JavaMailSender emailSender;
	
	public void sendSimpleMessage(Utilisateurs u) throws MessagingException {
		TemplateEngine templateEngine = getTemplateEngine();
		
		Map<String, Object> model = new HashMap<>();
		model.put("today", String.valueOf(new Date()));
		model.put("usermail", u.getEmail());
		
        try {
        	MimeMessage message = emailSender.createMimeMessage();
    		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
    		Context context = new Context();
    		context.setVariables(model);
    		String html = templateEngine.process("email-test", context);
    		helper.setText(html, true);
    		helper.setTo(u.getEmail());
            message.setSubject("E-mail TEST Beezen");

          emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

	
	@Override
	public void sendTestEmail(Utilisateurs u) throws CustomException, MessagingException {
		JavaMailSender javaMailSender =new JavaMailSenderImpl();;
		TemplateEngine templateEngine = getTemplateEngine();

		Map<String, Object> model = new HashMap<>();
		model.put("today", String.valueOf(new Date()));
		model.put("usermail", u.getEmail());

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Context context = new Context();
		context.setVariables(model);
		String html = templateEngine.process("email-test", context);
		helper.setTo(u.getEmail());
		helper.setText(html, true);
		helper.setSubject("E-mail TEST Beezen");
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("beezenrh@gmail.com");
		mailSender.setPassword("beezenRH2018");
//		Properties props = mailSender.getJavaMailProperties();
	//	props.put("mail.smtp.port", 587);
//		props.put("mail.transport.protocol", "smtp");
	//	props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.debug", "true");
		mailSender.send(message);
	}

	@Override
	public void sendLinkEmail(Utilisateurs u, String url) throws MessagingException, CustomException {
TemplateEngine templateEngine = getTemplateEngine();
		
		Map<String, Object> model = new HashMap<>();
		model.put("today", String.valueOf(new Date()));
		model.put("usermail", u.getEmail());
		model.put("resetUrl", url);
        try {
        	MimeMessage message = emailSender.createMimeMessage();
    		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
    		Context context = new Context();
    		context.setVariables(model);
    		String html = templateEngine.process("email-template", context);
    		helper.setText(html, true);
    		helper.setTo(u.getEmail());
    		message.setSubject("Réinitialisation de votre mot passe Beezen - [" + u.getUsername() + "]");

          emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
		
	}
	private TemplateEngine getTemplateEngine() {
		ClassLoaderTemplateResolver tres = new ClassLoaderTemplateResolver();

		tres.setPrefix("email/");
		tres.setSuffix(".html");
		tres.setCacheable(false);
		tres.setTemplateMode("HTML5");
		tres.setCharacterEncoding("UTF-8");
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(tres);
		return templateEngine;
	}

//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	     
//	    mailSender.setUsername("my.gmail@gmail.com");
//	    mailSender.setPassword("password");
//	     
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
	     
	    
	    /******/
//	    mailSender.setHost(p.getAdressesmtp());
//	    mailSender.setUsername(p.getLogin());
//		mailSender.setPassword(p.getMdp());
	    /******/
//		System.out.println("Aucune securité");
//	    
//		System.out.println("StartTLS");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.port", p.getPort());
//
//		// ****for test
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setUsername("timtamtom.cogis@gmail.com");
//		mailSender.setPassword("Cogis03tim");
//
//		props.put("mail.smtp.port", 465);
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.debug", "true");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.socketFactory.fallback", "false");
//	    
//		System.out.println("SSl+TLS");
//		props.put("mail.smtp.auth", "true");
//		// SSL require 465 port number
//		props.put("mail.smtp.port", p.getPort());
//		props.put("mail.smtp.ssl.enable", "true");
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//	    
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.debug", p.isDebug() + "");
//		props.put("mail.smtp.socketFactory.fallback", "false");
	    /******/
	    
	    
	    
//	    
//	    return mailSender;
//	}
}
