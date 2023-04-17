// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.dao;

import com.boomi.leavetrackingsystem.model.Attendance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author omkargujar.
 */
public class AttendanceDao {

    private SessionFactory _sessionFactory;

    public AttendanceDao() {
        _sessionFactory = BoomitrainingSessionFactory.getSessionFactory();
    }

    public boolean createAttendance(Attendance attendance) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Serializable save = session.save(attendance);
            System.out.println(save);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public boolean markAttendance(Attendance attendance) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(attendance);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Attendance> attendanceList = new ArrayList<>();

        try {
            Query query = session.createQuery("FROM Attendance A where A._date = :date");
            query.setParameter("date", date);
            List list = query.list();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                attendanceList.add((Attendance) iterator.next());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return attendanceList;
    }

    public List<Attendance> getAttendanceById(int id) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Attendance> attendanceList = new ArrayList<>();

        try {
            Query<Attendance> query = session.createQuery("FROM Attendance A where A._id = :id ORDER BY _date");
            query.setParameter("id", id);
            attendanceList = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return attendanceList;
    }

    public Attendance getAttendanceByDateId(LocalDate date, int id) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Attendance> attendanceList = new ArrayList<>();
        Attendance attendance = null;

        try {
            Query<Attendance> query = session.createQuery("FROM Attendance A where A._date = :date and A._id=:id");
            query.setParameter("date", date);
            query.setParameter("id", id);
            attendanceList = query.list();
            attendance = attendanceList.get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return attendance;
    }

    public boolean deleteAttendance(Attendance attendance) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(attendance);
            status = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public boolean deleteAttendanceByDate(LocalDate date) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("DELETE FROM Attendance A WHERE A._date=:date");
            query.setParameter("date", date);
            int rows = query.executeUpdate();
            if (rows > 0) {
                status = true;
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }
}
