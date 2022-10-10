package com.mail;

import com.mail.dto.MailRequest;
import com.mail.dto.MailResponse;
import com.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SendMailApplication {

    @Autowired
    private EmailSenderService service;

    @Autowired
    private EmailService emailService;//template


    public static void main(String[] args) {
        SpringApplication.run(SendMailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {
        service.sendMailWithAttachment("viethoang2001gun@gmail.com",
                "This is the Email Body...",
                "This is Email Subject",
                "D:\\Themes\\Anime\\1.jpg");
    }

    @PostMapping("/sendingEmail")
    public MailResponse sendEmail(@RequestBody MailRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Bangalore,India");
        return emailService.sendEmail(request, model);

    }
}
