// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.service;

import com.boomi.leavetrackingsystem.dao.SubjectDao;
import com.boomi.leavetrackingsystem.model.Subject;

import java.util.List;

/**
 * @author omkargujar.
 */
public class SubjectService {

    private SubjectDao _subjectDao;

    public SubjectService() {
        _subjectDao = new SubjectDao();
    }

    public boolean addSubject(int subId, String name) {
        return _subjectDao.addSubject(subId, name);
    }

    public List<Subject> getAllSubjects() {
        return _subjectDao.getAllSubjects();
    }

    public Subject getSubjectById(int subId) {
        return _subjectDao.getSubjectById(subId);
    }
}
