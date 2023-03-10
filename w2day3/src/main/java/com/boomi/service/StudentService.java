package com.boomi.service;

import com.boomi.dao.StudentDao;

import java.sql.SQLException;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() throws SQLException, ClassNotFoundException {
        this.studentDao = new StudentDao();
    }

    public boolean addStudent(int id,String name,int age){
       return studentDao.addStudent(id,name,age);
    }
}
