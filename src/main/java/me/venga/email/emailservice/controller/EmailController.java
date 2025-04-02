package me.venga.email.emailservice.controller;

import me.venga.email.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/email/send-txt")
    public String sendEmailText(@RequestParam String recipient, @RequestParam String subject, @RequestParam String message) {
        return emailService.sendMailText(recipient, subject, message);
    }

    @GetMapping("/email/send-html")
    public String sendEmailHtml(@RequestParam String recipient, @RequestParam String subject, @RequestParam String message) {
        return emailService.sendMailHtml(recipient, subject, message);
    }

    @PostMapping("/email/send-html-with-attachment") // Corrigido para incluir '/email'
    public String sendEmailHtmlWithAttachment(@RequestParam String recipient,
                                              @RequestParam String subject,
                                              @RequestParam String messageContent,
                                              @RequestPart MultipartFile[] files) {
        return emailService.sendMailHtmlWithAttachment(recipient, subject, messageContent, files);
    }
}
