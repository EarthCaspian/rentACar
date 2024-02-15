package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.services.MailService;
import com.tobeto.rentACar.services.dtos.contact.ContactMailRequest;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contact")
@AllArgsConstructor
@CrossOrigin
public class ContactController {

    private final MailService mailService;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody ContactMailRequest request) throws MessagingException {

        String to = "seenduygu@gmail.com";
        String subject = "Contact Us Mail";
        String mailContent = "<!DOCTYPE html>\n" +
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
                "    <p><strong>Subject:</strong> " + request.getSubject() +
                "</p>\n" +
                "    <p><strong>Message:</strong> " + request.getMessage() + "</p>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendEmail(to, subject, mailContent);
    }
}
