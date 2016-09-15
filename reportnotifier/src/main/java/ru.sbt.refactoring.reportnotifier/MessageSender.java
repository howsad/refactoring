package ru.sbt.refactoring.reportnotifier;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Alexander Ushakov on 15.09.2016.
 */
public class MessageSender {
    private static final String DEFAULT_MAIL_SERVER = "mail.google.com";
    private static final boolean HTML_FORMAT = true;
    private static final String DEFAULT_SUBJECT = "Monthly department salary report";

    private final String mailServer;
    private final String subject;

    public MessageSender() {
        this(DEFAULT_MAIL_SERVER, DEFAULT_SUBJECT);
    }

    public MessageSender(String mailServer, String subject) {
        this.mailServer = mailServer;
        this.subject = subject;
    }

    public void sendMessage(String recipients, String htmlMessageText) throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailServer);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);
        helper.setText(htmlMessageText, HTML_FORMAT);
        helper.setSubject(subject);

        mailSender.send(message);
    }
}
