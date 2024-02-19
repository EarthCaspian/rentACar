package com.tobeto.rentACar.controllers;

import com.tobeto.rentACar.core.services.MailService;
import com.tobeto.rentACar.services.dtos.contact.ContactMailRequest;
import com.tobeto.rentACar.services.dtos.contact.JoinUsMailRequest;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contact")
@AllArgsConstructor
@CrossOrigin
public class ContactController {

    private final MailService mailService;

    @PostMapping("/sendContactPageEmail")
    public void sendContactPageEmail(@RequestBody ContactMailRequest request) throws MessagingException {

        mailService.sendContactPageEmail(request);
    }

    @PostMapping("/sendJoinUsEmail")
    public void sendJoinUsEmail(@RequestBody JoinUsMailRequest request) throws MessagingException {

        mailService.sendJoinUsEmail(request);
    }

}
