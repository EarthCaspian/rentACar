package com.tobeto.rentACar.core.services;

import com.tobeto.rentACar.services.dtos.contact.ContactMailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${mail.username}")
    private String username;

    public void sendEmail(ContactMailRequest request) throws MessagingException {
        String to = username;
        String subject = "Contact Us Mail";
        String mailContent = generateMailContent(request);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom(username);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(mailContent, true);

        javaMailSender.send(mimeMessage);
    }

    private String generateMailContent(ContactMailRequest request) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"tr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Contact Form Submission</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h2>Contact Form Submission</h2>\n" +
                "    <p><strong>Name:</strong> " + request.getName() + "</p>\n" +
                "    <p><strong>Surname:</strong> " + request.getSurname() + "</p>\n" +
                "    <p><strong>Email:</strong> " + request.getEmail() + "</p>\n" +
                "    <p><strong>Subject:</strong> " + request.getSubject() + "</p>\n" +
                "    <p><strong>Message:</strong> " + request.getMessage() + "</p>\n" +
                "</body>\n" +
                "</html>";
    }
}
