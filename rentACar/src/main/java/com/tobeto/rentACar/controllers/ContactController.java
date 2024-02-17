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

        mailService.sendEmail(request);
    }
}
