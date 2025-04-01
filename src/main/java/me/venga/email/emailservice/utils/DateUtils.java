package me.venga.email.emailservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class DateUtils {

    public static LocalDateTime convertStringToLocalDateTime(String date) {

        if(Objects.isNull(date)){
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return LocalDateTime.parse(date, formatter);
    }

    public static String formatDateToBr(String date) {

        if (Objects.isNull(date)){
            return "";
        }

        String[] dateArray = date.split("-");
        String formatedDate = dateArray[2] + "/" + dateArray[1] + "/" + dateArray[0];

        return formatedDate;
    }

    public static String getDateFormatted(LocalDateTime now){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(now);
    }

    public static String getDateTimeFormatted(LocalDateTime now){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dtf.format(now);
    }
}