package com.programmingfoundation.restservicesprovider.service;

import com.programmingfoundation.restservicesprovider.dto.EmailSmsDTO;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.twilio.Twilio;

import com.twilio.type.PhoneNumber;
@Service
//Developed by  Hasindu Dahanayake IT18153828
//Sending the Email and SMS using JAVA mail API and 3 rd party service Twillo
public class EmailSmsServiceImpl  implements EmailSmsService{

    @Override
    public void sendEmailSms(EmailSmsDTO emailSmsDTO) {


        //Using the Java Mail Api to send the email

        //Storing the mail address of the user which we need to send the mail
        String to =emailSmsDTO.getEmail();

        Properties props = new Properties();

        props.put("mail.smtp.host", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");

        //Establishing a session with required user details

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("firealarmmonitor4@gmail.com", "firealarm12");

            }

        });

        try {

            //Creating a Message object to set the email content

            MimeMessage msg = new MimeMessage(session);





            InternetAddress[] address = InternetAddress.parse(to, true);



            msg.setRecipients(Message.RecipientType.TO, address);


            msg.setSubject("FIRE ALARM MONITOR FIRE ALERT") ;

            msg.setSentDate(new Date());


            System.out.println("++Important++" + emailSmsDTO);

            msg.setText("                                  " + "Sensor is active!" + "                               "+"\n"+"\n"+"\n" +"Fire Alarm Name:  " +emailSmsDTO.getSensorName()+"\t\t\t   " +"Co2 Level: " +emailSmsDTO.getCoLevel()+"\n\n"+ "Smoke Level" + emailSmsDTO.getSmokeLevel()+"\t" + "Room Number: "+ emailSmsDTO.getRoomNumber() +"\t"+ "Floor Number: "+emailSmsDTO.getFloorNumber()
            );



            msg.setHeader("XPriority", "1");

            Transport.send(msg);

            System.out.println("Mail has been sent successfully");

        } catch (MessagingException mex) {

            System.out.println("Unable to send an email" + mex);

        }

        //Using the Twillo 3 rd party service to send SMS
          String ACCOUNT_SID = "ACeef0acbfd7a3940768ec08768ffa06a2";
          String AUTH_TOKEN = "98661d09732193b81a04de7e300d6dd6";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+94"+Integer.toString(emailSmsDTO.getContactNumber())),
                new PhoneNumber("+12025191380"),
                "FIRE ALARM MONITOR ALERT" + "Senosr is active" +
                        "Sensor Name: " + emailSmsDTO.getSensorName()+
                "Floor Number: " + emailSmsDTO.getFloorNumber() +
                "Room Number: " +emailSmsDTO.getRoomNumber()+
                "Co2 Level: " +emailSmsDTO.getCoLevel()+
        "Smoke Level: "+emailSmsDTO.getSmokeLevel()).create();

        System.out.println(message.getSid());
        System.out.println("SMS SENT");




    }
}
