package me.venga.email.emailservice.controller;

import me.venga.email.emailservice.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/emails")
@Tag(name = "Email Service", description = "Endpoints para envio de e-mails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Enviar E-mail de Texto", description = "Envia um e-mail simples com conteúdo de texto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "E-mail enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    @PostMapping("/send-text")
    public String sendEmailText(@RequestParam String recipient, @RequestParam String subject, @RequestParam String message) {
        return emailService.sendMailText(recipient, subject, message);
    }

    @Operation(summary = "Enviar E-mail HTML", description = "Envia um e-mail com conteúdo HTML.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "E-mail HTML enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    @PostMapping("/send-html")
    public String sendEmailHtml(@RequestParam String recipient, @RequestParam String subject, @RequestParam String message) {
        return emailService.sendMailHtml(recipient, subject, message);
    }

    @Operation(summary = "Enviar E-mail HTML com Anexos", description = "Envia um e-mail HTML com arquivos anexados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "E-mail HTML com anexos enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    @PostMapping("/send-html-attachments")
    public String sendEmailHtmlWithAttachment(
            @RequestParam String recipient,
            @RequestParam String subject,
            @RequestParam String messageContent,
            @RequestPart MultipartFile[] files) {
        return emailService.sendMailHtmlWithAttachment(recipient, subject, messageContent, files);
    }
}
