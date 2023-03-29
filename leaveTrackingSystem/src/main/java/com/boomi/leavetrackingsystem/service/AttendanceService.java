// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.service;

import com.boomi.leavetrackingsystem.dao.AttendanceDao;
import com.boomi.leavetrackingsystem.model.Attendance;

import java.time.LocalDate;
import java.util.List;

/**
 * @author omkargujar.
 */
public class AttendanceService {

    private AttendanceDao _attendanceDao;

    public AttendanceService() {
        _attendanceDao = new AttendanceDao();
    }

    public boolean createAttendance(Attendance attendance) {
        System.out.println(attendance.getId());
        return _attendanceDao.createAttendance(attendance);
    }

    public boolean markAttendance(Attendance attendance) {
        return _attendanceDao.markAttendance(attendance);
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return _attendanceDao.getAttendanceByDate(date);
    }
}
