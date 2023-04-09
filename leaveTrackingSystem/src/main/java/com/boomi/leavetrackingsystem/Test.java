// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem;

import com.boomi.leavetrackingsystem.model.Subject;
import com.boomi.leavetrackingsystem.model.UserInfo;
import com.boomi.leavetrackingsystem.service.AttendanceService;
import com.boomi.leavetrackingsystem.service.SubjectService;
import com.boomi.leavetrackingsystem.service.UserInfoService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author omkargujar.
 */
public class Test {

    public static void main(String[] args) {
        SubjectService subjectService = new SubjectService();
//        subjectService.addSubject(303146, "Power System II");
//        subjectService.addSubject(303147, "Control System I");
//        subjectService.addSubject(303148, "Utilization of Electric Energy");
//        subjectService.addSubject(303149, "Design of Electric Machines");
//        subjectService.addSubject(303150, "Energy Audit and Management ");
//
//        List<Subject> allSubjects = subjectService.getAllSubjects();
//        for (Subject subject : allSubjects) {
//            System.out.println(subject.toString());
//        }

        UserInfoService userInfoService = new UserInfoService();
        AttendanceService attendanceService = new AttendanceService();
        //        userInfoService.addUser(1001, "Omkar", "Gujar", LocalDate.of(1999, 11, 26), 23, "student",
        //        allSubjects);
        //        UserInfo userById = userInfoService.getUserById(1001);
        //        System.out.println(userById.isPasswordChanged());

                        Subject subjectById = subjectService.getSubjectById(303146);
                        List<Subject> subjects = new ArrayList<>();
                        subjects.add(subjectById);
                        userInfoService.addUser(101, "Ajit", "Kamble", LocalDate.of(1990, 05, 18), 32, "professor",
                        subjects);

        //        UserInfo userByUserName = userInfoService.getUserByUserName("Ajit.Kamble101");
        //        System.out.println("/////////////////////////////");
        //        System.out.println(userByUserName);
        //        System.out.println(userByUserName.getSubjects().get(0).getName());

        //        List<UserInfo> allStudents = userInfoService.getAllStudents(303146);
        //        for (UserInfo user:allStudents) {
        //            System.out.println(user.toString());
        //        }
        //        UserInfo userById = userInfoService.getUserById(1008);
        //        byte[] bytes = userById.getPassword().getBytes();
        //        byte[] decodedArray = Base64.getDecoder().decode(bytes);
        //        String decodedData = new String(decodedArray, StandardCharsets.UTF_8);
        //        System.out.println(decodedData);

        //        List<UserInfo> allUsers = userInfoService.getAllUsers();
        //        for (UserInfo user : allUsers) {
        //            String password = user.getPassword();
        //            byte[] encoded = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        //            String encodedPassword = new String(encoded);
        //            user.setPassword(encodedPassword);
        //            userInfoService.updateUser(user);
        //        }
    }
}
