// Copyright (c) 2023 Boomi, Inc.
package com.boomi.w3day4;

import com.boomi.w3day4.model.Student;
import com.boomi.w3day4.service.StudentService;

import java.util.List;

/**
 * @author omkargujar.
 */
public class TestHibernate {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> allStudents = studentService.getAllStudents();
        for (Student student : allStudents) {
            System.out.println(student.toString());
        }
    }
}
