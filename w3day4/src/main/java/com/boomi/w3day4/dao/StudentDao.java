// Copyright (c) 2023 Boomi, Inc.
package com.boomi.w3day4.dao;

import com.boomi.w3day4.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author omkargujar.
 */
public class StudentDao {

    SessionFactory _sessionFactory;

    public StudentDao() {
        _sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public boolean addStudent(int id, String name, int age) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Serializable save = session.save(new Student(id, name, age));
            if (save != null) {
                status = true;
            }
            transaction.commit();
        } catch (PersistenceException e) {
            System.out.println("Please Enter unique student ID.....");
            if (transaction != null) {
                transaction.rollback();
            }
            return status;
        }
        session.close();
        return status;
    }

    public List<Student> getAllStudents() {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students = new ArrayList<>();
        try {
            List fromStudent = session.createQuery("From Student S ORDER BY S.name").list();
            Iterator iterator = fromStudent.iterator();
            while (iterator.hasNext()) {
                Student student = (Student) iterator.next();
                students.add(student);
            }
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    public boolean updateStudent(int id, String name, int age) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        boolean status = false;
        try {
            Student student = session.get(Student.class, id);
            student.setAge(age);
            student.setName(name);
            session.update(student);
            status = true;
            transaction.commit();
        } catch (PersistenceException e) {
            System.out.println("Failed to update student");
            e.printStackTrace();
            return status;
        } finally {
            session.close();
        }
        return status;
    }

    public boolean deleteStudent(int id) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        boolean status = false;
        try {
            Student student = session.get(Student.class, id);
            session.delete(student);
            transaction.commit();
            status = true;
        } catch (PersistenceException e) {
            System.out.println("Failed to delete student");
            e.printStackTrace();
            return status;
        } finally {
            session.close();
        }
        return status;
    }

    public Student getStudentByID(int id) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = null;
        try {
            student = session.get(Student.class, id);
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }
}
