package com.newroztech.dizli.notifiactionmodule.email.configurations;

import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

	@Value("${mail.from-email}")
	private String from;


	private final JavaMailSender javaMailSender;
	private static  final Logger logger = LoggerFactory.getLogger(EmailService.class);

	@Async
	public void sendEmail(String to, String subject, String body) {
				try {
					MimeMessage message = javaMailSender.createMimeMessage();
					message.setFrom(new InternetAddress(from));
					message.setRecipients(Message.RecipientType.TO, new Address[]{new InternetAddress(to)});
					message.setSubject(subject);
					message.setContent(body, "text/html");
					javaMailSender.send(message);
				} catch (MessagingException e) {
					logger.error("Error sending email: " + e.getMessage(), e);
				}
	}
}
