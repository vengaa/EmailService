package me.venga.email.emailservice.dto.request;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record EmailRequestDTO(
        String recipient,
        String subject,
        String message,
        List<MultipartFile> attachments
) {}