package net.java8.part3.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

/**
 * Created by Ciprian on 12/3/2017.
 */
public class Quiz122 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2017, 12, 2);
        LocalDate nextWorkingDay = now.with(new NextWorkingDay());
        System.out.println("Next working day is " + nextWorkingDay.getDayOfWeek() +
                ", the " + nextWorkingDay.getDayOfMonth() + " of " + nextWorkingDay.getMonth());
    }

    static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            int dayOfWeek = temporal.get(ChronoField.DAY_OF_WEEK);
            if (dayOfWeek == 5 || dayOfWeek == 6) {
                return temporal.plus(8 - dayOfWeek, ChronoUnit.DAYS);
            } else if (dayOfWeek == 7) {
                return temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            } else {
                return temporal.plus(1, ChronoUnit.DAYS);
            }

            /*return temporal.with(temporal1 -> {
                DayOfWeek dow =
                        DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                int dayToAdd = 1;
                if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
                else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
                return temporal.plus(dayToAdd, ChronoUnit.DAYS);
            });*/
        }
    }
}
