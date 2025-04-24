package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;


public class FormatDatesApp {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        //TimeZone timeZone = TimeZone.getTimeZone("US/Mountain");
        LocalDateTime today = LocalDateTime.now();
        //LocalDateTime today = LocalDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter fmt1 =
                DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter fmt2 =
                DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter fmt3 =
                DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm");
        DateTimeFormatter fmt4 =
                DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy h:mm z").withZone(ZoneId.of("GMT"));

        System.out.println(today.format(fmt1));
        System.out.println(date);
        System.out.println(today.format(fmt2));
        System.out.println(today.format(fmt3));
        System.out.println(today.format(fmt4));




    }
}
