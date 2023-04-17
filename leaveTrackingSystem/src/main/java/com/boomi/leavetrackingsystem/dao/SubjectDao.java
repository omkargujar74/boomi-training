// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.dao;

import com.boomi.leavetrackingsystem.model.Subject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author omkargujar.
 */
public class SubjectDao {

    private SessionFactory _sessionFactory;

    public SubjectDao() {
        _sessionFactory = BoomitrainingSessionFactory.getSessionFactory();
    }

    public boolean addSubject(int subId, String name) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Serializable save = session.save(new Subject(subId, name));
            if (save != null) {
                status = true;
            }
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public List<Subject> getAllSubjects() {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Subject> students = new ArrayList<>();

        try {
            List fromSubject = session.createQuery("From Subject").list();
            Iterator iterator = fromSubject.iterator();
            while (iterator.hasNext()) {
                students.add((Subject) iterator.next());
            }
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    public Subject getSubjectById(int subId) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Subject subject = null;

        try {
            subject = session.get(Subject.class, subId);
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return subject;
    }
}
