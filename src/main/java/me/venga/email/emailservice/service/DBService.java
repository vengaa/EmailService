package me.venga.email.emailservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Value("${spring.mail.username}")
    private String username;

    public void instanciaDB() {
//        Dados para inserir no banco default
    }
}
