// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.service;

import com.boomi.leavetrackingsystem.dao.UserInfoDao;
import com.boomi.leavetrackingsystem.model.Subject;
import com.boomi.leavetrackingsystem.model.UserInfo;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

/**
 * @author omkargujar.
 */
public class UserInfoService {

    private UserInfoDao _userInfoDao;
    private CheckValidation _checkValidation;

    public UserInfoService() {
        _userInfoDao = new UserInfoDao();
        _checkValidation = new CheckValidation();
    }

    public boolean addUser(int id, String firstName, String lastName, LocalDate dateOfBirth, int age, String userType,
            List<Subject> subjects) {
        boolean status = false;
        if (_checkValidation.ageValidation(dateOfBirth, age)) {
            UserInfo user = new UserInfo(id, firstName, lastName, dateOfBirth, age, userType, subjects);
            System.out.println(user.getSubjects());
            user.setPasswordChanged(false);
            String password = user.getDateOfBirth().toString();
            byte[] encoded = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
            String encodedPassword = new String(encoded);
            user.setPassword(encodedPassword);
            String username = user.getFirstName() + "." + user.getLastName() + user.getId();
            user.setUsername(username.toLowerCase());
            status = _userInfoDao.addUser(user, subjects);
        }
        return status;
    }

    public UserInfo getUserById(int id) {
        return _userInfoDao.getUserById(id);
    }

    public UserInfo getUserByUserName(String username) {
        return _userInfoDao.getUserByUserName(username);
    }

    public boolean changePassword(String username, String password) {
        boolean status = false;
        if (_checkValidation.passwordValidation(password)) {
            byte[] encoded = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
            String encodedPassword = new String(encoded);
            status = _userInfoDao.changePassword(username, encodedPassword);
        }
        return status;
    }

    public List<UserInfo> getAllStudents(int sub_id) {
        return _userInfoDao.getAllStudents(sub_id);
    }

    public List<UserInfo> getAllProfessor() {
        return _userInfoDao.getAllProfessor();
    }

    public List<UserInfo> getAllUsers() {
        return _userInfoDao.getAllUsers();
    }

    public boolean updateUser(UserInfo user) {
        boolean status = false;
        if (_checkValidation.ageValidation(user.getDateOfBirth(), user.getAge())) {
            status = _userInfoDao.updateUser(user);
        }
        return status;
    }

    public boolean deleteUser(int id) {
        return _userInfoDao.deleteUser(id);
    }

    public boolean checkUserByUserName(String username) {
        return _userInfoDao.checkUserByUserName(username);
    }

    public UserInfo getUserWithDecodePassword(String username) {
        UserInfo userByUserName = _userInfoDao.getUserByUserName(username);
        byte[] bytes = userByUserName.getPassword().getBytes();
        byte[] decodedArray = Base64.getDecoder().decode(bytes);
        String decodedPassword = new String(decodedArray, StandardCharsets.UTF_8);
        userByUserName.setPassword(decodedPassword);
        return userByUserName;
    }
}