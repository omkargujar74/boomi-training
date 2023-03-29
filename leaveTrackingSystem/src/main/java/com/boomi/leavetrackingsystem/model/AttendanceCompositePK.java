// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author omkargujar.
 */
public class AttendanceCompositePK implements Serializable {

    private int _id;
    private LocalDate _date;

    public AttendanceCompositePK(int id, LocalDate date) {
        _id = id;
        _date = date;
    }

    public AttendanceCompositePK() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
