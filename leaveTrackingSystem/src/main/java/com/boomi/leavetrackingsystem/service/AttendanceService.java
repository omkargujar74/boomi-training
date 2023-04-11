// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.service;

import com.boomi.leavetrackingsystem.dao.AttendanceDao;
import com.boomi.leavetrackingsystem.model.Attendance;
import com.boomi.leavetrackingsystem.model.UserInfo;

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
        UserInfoService userInfoService = new UserInfoService();
        UserInfo userById = userInfoService.getUserById(attendance.getId());
        attendance.setStudent(userById);
        boolean status = _attendanceDao.createAttendance(attendance);
        if (status) {
            List<Attendance> studentAttendance = userById.getAttendance();
            studentAttendance.add(attendance);
            status = userInfoService.updateUser(userById);
        }
        return status;
    }

    public boolean markAttendance(LocalDate attendanceDate, int id, String subName, boolean attendance) {
        Attendance attendanceByDateId = _attendanceDao.getAttendanceByDateId(attendanceDate, id);
        switch (subName) {
            case "Power System II":
                attendanceByDateId.setPowerSystemII(attendance);
                break;

            case "Control System I":
                attendanceByDateId.setControlSystemI(attendance);
                break;

            case "Utilization of Electric Energy":
                attendanceByDateId.setUtilizationOfElectricEnergy(attendance);
                break;

            case "Design of Electric Machines":
                attendanceByDateId.setDesignOfElectricMachines(attendance);
                break;

            case "Energy Audit and Management":
                attendanceByDateId.setEnergyAuditAndManagement(attendance);
                break;
        }
        return _attendanceDao.markAttendance(attendanceByDateId);
    }

    public Attendance getAttendanceByDateId(LocalDate date,int id) {
        return _attendanceDao.getAttendanceByDateId(date, id);
    }
        public List<Attendance> getAttendanceByDate(LocalDate date) {
        return _attendanceDao.getAttendanceByDate(date);
    }

    public boolean deleteAttendance(Attendance attendance) {
        return _attendanceDao.deleteAttendance(attendance);
    }
}
