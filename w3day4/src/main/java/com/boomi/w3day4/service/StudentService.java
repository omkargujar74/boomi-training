// Copyright (c) 2023 Boomi, Inc.
package com.boomi.w3day4.service;

import com.boomi.w3day4.dao.StudentDao;
import com.boomi.w3day4.model.Student;

import java.util.List;

/**
 * @author omkargujar.
 */
public class StudentService {

    StudentDao _studentDao;

    public StudentService() {
        _studentDao = new StudentDao();
    }

    public boolean addStudent(int id, String name, int age) {
        return _studentDao.addStudent(id, name, age);
    }

    public List<Student> getAllStudents() {
        return _studentDao.getAllStudents();
    }

    public boolean updateStudent(int id, String name, int age) {
        return _studentDao.updateStudent(id, name, age);
    }

    public boolean deleteStudent(int id) {
        return _studentDao.deleteStudent(id);
    }

    public Student getStudentByID(int id) {
        return _studentDao.getStudentByID(id);
    }
}
