package com.programmingfoundation.restservicesprovider.controllers;

import com.programmingfoundation.restservicesprovider.dto.EmailSmsDTO;
import com.programmingfoundation.restservicesprovider.service.EmailSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms-email-api")
//Developed by  Hasindu Dahnayake IT18153828
public class EmailSmsController {
    @Autowired
   private EmailSmsService emailSmsService;
    @PostMapping("/sms-emails")
    public void notifyUsers(@RequestBody EmailSmsDTO emailSmsDTO){
         emailSmsService.sendEmailSms(emailSmsDTO);
        System.out.println("Came to the end point");
    }


}
