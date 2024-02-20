package com.example.checkin.service;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Service;
@Service
public class EmailBasicService {
    public void sendHtmlEmail(String host, String port, final String userName, final String password, String toAddress,
                              String subject, String htmlContent) throws AddressException, MessagingException {

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

// sets SMTP server properties
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", "465");

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.transport.protocol", "smtp");

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.user", userName);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        try {
// creates a new session with Authenticator
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

// creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(userName));
            InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());

// set HTML content
            msg.setContent(htmlContent, "text/html; charset=utf-8");

// sends the e-mail
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
