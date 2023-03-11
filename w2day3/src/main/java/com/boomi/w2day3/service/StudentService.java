package com.boomi.w2day3.service;

import com.boomi.w2day3.dao.StudentDao;
import com.boomi.w2day3.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() throws SQLException, ClassNotFoundException {
        this.studentDao = new StudentDao();
    }

    public boolean addStudent(int id, String name, int age) {
        return studentDao.addStudent(id, name, age);
    }

    public List<Student> getAllStudents() throws SQLException {
        return studentDao.getAllStudents();
    }

    public boolean updateStudent(int id, String name, int age) {
        return studentDao.updateStudent(id, name, age);
    }

    public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }
}
