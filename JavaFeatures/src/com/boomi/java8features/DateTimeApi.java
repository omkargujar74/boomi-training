package com.boomi.java8features;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTimeApi {
    public static void main(String[] args) {

        //  Date........................

        LocalDate date = LocalDate.now();
        System.out.println("Current Date = " + date);

        LocalDate date1 = LocalDate.of(1999, 11, 26);
        System.out.println("Birthdate = " + date1);

        LocalDate date2 = LocalDate.of(1999, Month.NOVEMBER, 26);
        System.out.println("Date2 = " + date2);

        //System.out.println(ZoneId.getAvailableZoneIds());

        LocalDate america = LocalDate.now(ZoneId.of("America/Marigot"));
        System.out.println("Ameraca's Date" + america);

        Period gap = Period.between(date, date1);
        System.out.println("Gap = " + gap);

        date2 = date2.plusYears(2);
        System.out.println("2 years added to date2 = " + date2);

        date2 = date2.plus(2, ChronoUnit.DECADES);
        System.out.println("2 Decades added to date2 = " + date2);

        LocalDate dayOfNextMonth = date2.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("First day of next month of date2 = " + dayOfNextMonth);

        //  Time.......................

        LocalTime time = LocalTime.now();
        System.out.println("Current time = " + time);

        LocalTime time1 = LocalTime.now(ZoneId.of("America/Marigot"));
        System.out.println("America's Time = " + time1);

        LocalTime time2 = LocalTime.of(12, 38, 55);
        System.out.println("time2 = " + time2);

        Duration five = Duration.ofHours(5);
        time2 = time2.plus(five);
        System.out.println("Adding Duration of 5 hours to time2 = " + time2);

        Duration duration = Duration.between(time, time1);
        System.out.println("Duration = " + duration);

        // DateTime.........
        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current Date and time = " + current);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formateddatetime = current.format(formatter);
        System.out.println("Formated Date and Time = " + formateddatetime);

        Month month = current.getMonth();
        System.out.println("Curernt Month = " + month);

        int dayOfMonth = current.getDayOfMonth();
        System.out.println("Current Day of month = " + dayOfMonth);

        int currentDay = current.getDayOfYear();
        System.out.println("Current Day of year = " + currentDay);

        int year = current.getYear();
        System.out.println("Current Year = " + year);
    }
}
