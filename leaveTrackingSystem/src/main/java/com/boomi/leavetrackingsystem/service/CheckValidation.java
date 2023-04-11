// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

/**
 * @author omkargujar.
 */
public class CheckValidation {

    public boolean ageValidation(LocalDate dob, int age) {
        boolean status = false;
        if (age >= 15) {
            LocalDate now = LocalDate.now();
            System.out.println(now);
            Period period = Period.between(dob, now);
            status = (period.getYears() == age);
        }
        return status;
    }

    public boolean passwordValidation(String password) {
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*.])[a-zA-Z0-9!@#$%^&*.]{8,16}";
        Pattern passwordValidation = Pattern.compile(regex);
        return passwordValidation.matcher(password).matches();
    }
}
