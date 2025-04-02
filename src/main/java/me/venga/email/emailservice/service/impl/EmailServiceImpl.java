package me.venga.email.emailservice.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import me.venga.email.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendMailText(String recipient, String subject, String message) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(recipient);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
            return "Microservice: Email Sent";
        } catch (Exception e) {
            return "Error to send email: " + e.getLocalizedMessage();
        }
    }

    @Override
    public String sendMailHtml(String recipient, String subject, String messageContent) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(sender);
            helper.setSubject(subject);
            helper.setTo(recipient);

            // Carrega o template do e-mail HTML
            String template = loadTemplate();
            template = template.replace("#{nome}", recipient);
            template = template.replace("#{message}", messageContent);

            helper.setText(template, true);  // Define o corpo do e-mail como HTML
            javaMailSender.send(mimeMessage);
            return "Microservice: HTML Email Sent";
        } catch (Exception exception) {
            System.out.println("Failed to send email: " + exception.getMessage());
            return "Error to send HTML email: " + exception.getLocalizedMessage();
        }
    }

    @Override
    public String sendMailHtmlWithAttachment(String recipient, String subject, String messageContent, MultipartFile[] files) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(sender);
            helper.setSubject(subject);
            helper.setTo(recipient);

            // Carrega o template do e-mail HTML
            String template = loadTemplate();
            template = template.replace("#{nome}", recipient);
            template = template.replace("#{message}", messageContent);

            helper.setText(template, true);  // Define o corpo do e-mail como HTML

            // Anexa os arquivos se presentes
            if (files != null && files.length > 0) {
                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        helper.addAttachment(file.getOriginalFilename(), file);
                    }
                }
            }

            javaMailSender.send(mimeMessage);
            return "Microservice: HTML Email with Attachments Sent";
        } catch (Exception exception) {
            System.out.println("Failed to send email with attachments: " + exception.getMessage());
            return "Error to send HTML email with attachments: " + exception.getLocalizedMessage();
        }
    }

    @Override
    public String loadTemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("template-email.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
