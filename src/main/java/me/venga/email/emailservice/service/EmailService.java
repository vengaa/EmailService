package me.venga.email.emailservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    String sendMailText(String recipient, String subject, String message);
    String sendMailHtml(String recipient, String subject, String messageContent);
    String sendMailHtmlWithAttachment(String recipient, String subject, String messageContent, MultipartFile[] files);
    String loadTemplate() throws Exception;
}
