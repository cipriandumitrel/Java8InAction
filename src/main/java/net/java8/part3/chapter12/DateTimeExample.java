package net.java8.part3.chapter12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Ciprian on 12/2/2017.
 */

public class DateTimeExample {

    public static void main(String[] args) {
        //Reading local date using LocalDate
        localDateUsage();

        //Using LocalTime
        localTimeUsage();

        //Creating LocalDate and LocalTime using parse method
        localDateAndLocalTimeCreationUsingParse();

        //Using LocalDateTime
        localDateTimeUsage();

        //Using java.time.Instant
        usageOfInstant();

        //Using java.time.Duration
        usageOfDurationAndPeriod();

        //Manipulating dates
        mutateDateObjects();

        //Using TemporalAdjusters
        useTemporalAdjusters();
    }

    private static void useTemporalAdjusters() {
        LocalDate date1 = LocalDate.of(2017, 12, 3);
        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Next sunday is: " + date2.getDayOfMonth() + "th of " + date2.getMonth());
        System.out.println("The last day of " + date3.getMonth() + " is the " + date3.getDayOfMonth() + "st");
    }

    private static void mutateDateObjects() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println("Mutated date: " + date4.getYear() + "-" + date4.getMonthValue() + "-" + date4.getDayOfMonth());

        LocalDate date5 = date1.plusWeeks(1);
        LocalDate date6 = date5.minusYears(3);
        LocalDate date7 = date6.plus(6, ChronoUnit.MONTHS);
        System.out.println("Mutated date v1: " + date7.getYear() + "-" + date7.getMonthValue() + "-" + date7.getDayOfMonth());
    }

    private static void usageOfDurationAndPeriod() {
        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Instant now = Instant.now();
        Duration d1 = Duration.between(instant, now);
        System.out.println("Duration d1 in seconds: " + d1.getSeconds());
        LocalTime time = LocalTime.of(13, 45, 20);
        Duration d2 = Duration.between(LocalTime.of(13, 45, 10), time);
        System.out.println("Duration d2 in seconds: " + d2.getSeconds());
        Period period = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
        System.out.println("Period in days: " + period.getDays());
    }

    private static void localDateTimeUsage() {
        LocalDate localDate = LocalDate.of(2016, 11, 28);
        LocalTime localTime = LocalTime.of(13, 45, 20);
        LocalDateTime dt1 = LocalDateTime.of(2016, Month.NOVEMBER, 28, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime dt3 = localDate.atTime(13, 45, 20);
        LocalDateTime dt4 = localDate.atTime(localTime);
        LocalDateTime dt5 = localTime.atDate(localDate);
        System.out.println("dt1: " + dt1);
        LocalDate date = dt1.toLocalDate();
        LocalTime time = dt2.toLocalTime();
        System.out.println("date: " + date);
        System.out.println("time: " + time);
    }

    private static void localDateUsage() {
        //Reading local date using LocalDate
        LocalDate date = LocalDate.of(2016, 11, 28);
        int year = date.getYear();
        System.out.println("Year is: " + year);
        Month month = date.getMonth();
        System.out.println("Month is: " + month.name());
        int day = date.getDayOfMonth();
        System.out.println("Day is: " + day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("Day of week is: " + dayOfWeek);
        int len = date.lengthOfMonth();
        System.out.println(month.name() + " has " + len + " days.");
        boolean leap = date.isLeapYear();
        System.out.println(year + " has " + date.lengthOfYear() + " days.");
        System.out.println(year + ((leap) ? " is" : " is not") + " a leap year.");
        System.out.println("Today us " + LocalDate.now().toString());

        //Reading local date using a TemporalField
        int yearUsingTF = date.get(ChronoField.YEAR);
        int monthUsingTF = date.get(ChronoField.MONTH_OF_YEAR);
        int dayUsingTF = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println("Date using TemporalField: " + yearUsingTF + "-" + monthUsingTF + "-" + dayUsingTF);
    }

    private static void localTimeUsage() {
        LocalTime localTime = LocalTime.of(16, 5, 30);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        System.out.println("Time is: " + hour + ":" + minute + ":" + second);
    }

    private static void localDateAndLocalTimeCreationUsingParse() {
        LocalDate localDateUsingParse = LocalDate.parse("2017-12-02");
        LocalTime localTimeUsingParse = LocalTime.parse("13:45");
        System.out.println("Local date using parse: " + localDateUsingParse.toString());
        System.out.println("Local time using parse: " + localTimeUsingParse.toString());
    }

    private static void usageOfInstant() {
        Instant instant = Instant.ofEpochSecond(3);
        System.out.println("instant:" + instant);
        System.out.println(LocalDateTime.ofInstant(instant, ZoneOffset.UTC));
        Instant now = Instant.now();
        System.out.println(LocalDateTime.ofInstant(now, ZoneOffset.UTC));
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println("instant2: " + instant2);
        System.out.println("instant3: " + instant3);
        System.out.println("instant4: " + instant4);
    }
}
