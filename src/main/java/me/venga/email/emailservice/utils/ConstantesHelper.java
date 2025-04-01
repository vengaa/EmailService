package me.venga.email.emailservice.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class ConstantesHelper {

    public static final String DATA_ATUAL_STRING = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now(ZoneId.systemDefault()));
}
