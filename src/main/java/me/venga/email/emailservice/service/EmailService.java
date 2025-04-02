package me.venga.email.emailservice.service.impl;

import me.venga.email.emailservice.dto.request.EmailRequestDTO;

public interface EmailService {
    String sendMailText(EmailRequestDTO emailRequest);
    String sendMailHtml(EmailRequestDTO emailRequest);
}
