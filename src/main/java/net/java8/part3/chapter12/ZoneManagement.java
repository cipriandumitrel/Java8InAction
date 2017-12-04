package net.java8.part3.chapter12;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ciprian on 12/4/2017.
 */

public class ZoneManagement {

    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate localDate = LocalDate.of(2017, 12, 4 );
        ZonedDateTime zdt1 = localDate.atStartOfDay(romeZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(zdt1.format(formatter));

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        System.out.println(zdt2.format(formatter));

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);
        System.out.println(zdt3.format(formatter));
    }
}
