package com.healthmetrics.core.utils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailSender {

	@Autowired
	private MessageHelper messageHelper;

	/** Base URL for the reset password link. */
	private static final String PASSWORD_RESET_BASE_URL = "/passwordReset?";

	/**
	 * Mail Session.
	 * 
	 * @return
	 */
	public static Session CustomMailSenderSession() {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("healthmetrics.gloin", "TheCakeIsALie");
			}
		});

		return session;
	}

	/**
	 * Send a new Registration notification to the default mail recipient (nimbees-alerts@gloin.es).
	 * 
	 * @param mail
	 */
//	public void sendRegistrationConfirmation(String mail) {
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date date = new Date();
//		try {
//
//			Message message = new MimeMessage(MailSender.CustomMailSenderSession());
//			message.setFrom(new InternetAddress("nimbeesnotifications@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nimbees-alerts@gloin.es"));
//			message.setSubject("Nuevo usuario " + mail + " registrado en nimBees Platform");
//			message.setText("El usuario con correo " + mail + " se registró el " + dateFormat.format(date));
//
//			Transport.send(message);
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}

	/**
	 * Sends a password reset email.
	 * 
	 * @param baseUrl
	 *            Base URL of the server.
	 * @param email
	 *            User email
	 * @param token
	 *            Password reset token
	 */
	public void sendPasswordResetEmail(String baseUrl, String email, String token) {
		try {

			Message message = new MimeMessage(MailSender.CustomMailSenderSession());
			try {
				message.setFrom(new InternetAddress("edgar.gloin@gmail.com", "EDGAR support"));
			} catch (UnsupportedEncodingException e) {
				message.setFrom(new InternetAddress("edgar.gloin@gmail.com"));
			}
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Password reset");

			String content = messageHelper.getMessageWithParams("mail.passwordrecovery.message",
					new Object[] { baseUrl + PASSWORD_RESET_BASE_URL, token });
			message.setContent(content, "text/html");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
