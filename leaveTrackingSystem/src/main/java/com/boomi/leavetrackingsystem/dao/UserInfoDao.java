// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.dao;

import com.boomi.leavetrackingsystem.model.Subject;
import com.boomi.leavetrackingsystem.model.UserInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author omkargujar.
 */
public class UserInfoDao {

    private SessionFactory _sessionFactory;

    public UserInfoDao() {
        _sessionFactory = boomitrainingSessionFactory.getSessionFactory();
    }

    public boolean addUser(UserInfo user, List<Subject> subjects) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(user);
        try {
            Serializable save = session.save(user);
            for (Subject subject : subjects) {
                subject.addUser(user);
                session.update(subject);
            }
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

    public UserInfo getUserById(int id) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserInfo user = null;

        try {
            user = session.get(UserInfo.class, id);
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public UserInfo getUserByUserName(String username) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserInfo user = null;

        try {
            Query query = session.createQuery("FROM UserInfo U where U._username = :username");
            query.setParameter("username", username);
            List list = query.list();
            user = (UserInfo) list.get(0);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public boolean changePassword(String username, String password) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            UserInfo userByUserName = this.getUserByUserName(username);
            userByUserName.setPassword(password);
            userByUserName.setPasswordChanged(true);
            session.update(userByUserName);
            status = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public List<UserInfo> getAllStudents(int sub_id) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserInfo> students = new ArrayList<>();

        try {
            Query query = session.createQuery("From UserInfo U where U._userType =:type");
            query.setParameter("type", "student");
            List list = query.list();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                UserInfo student = (UserInfo) iterator.next();
                List<Subject> subjects = student.getSubjects();
                for (Subject subject : subjects) {
                    if (sub_id == subject.getSubId()) {
                        students.add(student);
                    }
                }
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    public List<UserInfo> getAllProfessor() {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserInfo> professors = new ArrayList<>();

        try {
            Query<UserInfo> query = session.createQuery("From UserInfo U where U._userType =:type");
            query.setParameter("type", "professor");
            professors = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return professors;
    }

    public List<UserInfo> getAllUsers() {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<UserInfo> users = new ArrayList<>();

        try {
            Query query = session.createQuery("From UserInfo");
            List list = query.list();
            System.out.println(list.size());
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                users.add((UserInfo) iterator.next());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    public boolean updateUser(UserInfo user) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(user);
            transaction.commit();
            status = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public boolean deleteUser(int id) {
        boolean status = false;
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("Delete From UserInfo U where U.id=:id");
            query.setParameter("id", id);
            //Query query1 = session.createQuery("Delete From Attendance A where A._id=:id");
            //query1.setParameter("id", id);
            int row = query.executeUpdate();
            if (row > 0) {
                status = true;
                //query1.executeUpdate();
            }
            transaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }

    public boolean checkUserByUserName(String username) {
        Session session = _sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        boolean status = false;

        try {
            Query query = session.createQuery("FROM UserInfo U where U._username = :username");
            query.setParameter("username", username);
            List list = query.list();
            status = !list.isEmpty();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return status;
    }
}
