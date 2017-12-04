package net.java8.part3.chapter12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * Created by Ciprian on 12/4/2017.
 */
public class DateTimeFormattersExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017, 12, 18);
        String dateAsBasicISO = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String dateAsISOLocalDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("dateAsBasicISO: " + dateAsBasicISO);
        System.out.println("dateAsISOLocalDate: " + dateAsISOLocalDate);

        LocalDate d1 = LocalDate.parse(dateAsBasicISO, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate d2 = LocalDate.parse(dateAsISOLocalDate, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(d1.getYear() == d2.getYear());
        System.out.println(d1.getMonthValue() == d2.getMonthValue());
        System.out.println(d1.getDayOfMonth() == d2.getDayOfMonth());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String customFormatterResult = date.format(dateTimeFormatter);
        System.out.println("customFormatterResult: " + customFormatterResult);

        //Formatter for a given locale
        DateTimeFormatter formatterForLocale =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        System.out.println("Result with formatterForLocale: " + date.format(formatterForLocale));

        //Formatter using the DateTimeFormatterBuilder
        DateTimeFormatter formatterCreatedWithBuilder = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        System.out.println("Result with formatterCreatedWithBuilder: " + date.format(formatterCreatedWithBuilder));
    }
}
