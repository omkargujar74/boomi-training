// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.service;

import com.boomi.leavetrackingsystem.dao.UserInfoDao;
import com.boomi.leavetrackingsystem.model.Subject;
import com.boomi.leavetrackingsystem.model.UserInfo;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author omkargujar.
 */
public class UserInfoService {

    private UserInfoDao _userInfoDao;

    public UserInfoService() {
        _userInfoDao = new UserInfoDao();
    }

    public boolean addUser(int id, String firstName, String lastName, LocalDate dateOfBirth, int age, String userType,
            List<Subject> subjects) {
        UserInfo user = new UserInfo(id, firstName, lastName, dateOfBirth, age, userType, subjects);
        String password = user.getDateOfBirth().toString();
        byte[] encoded = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        String encodedPassword = new String(encoded);
        user.setPassword(encodedPassword);
        return _userInfoDao.addUser(user, subjects);
    }

    public UserInfo getUserById(int id) {
        return _userInfoDao.getUserById(id);
    }

    public UserInfo getUserByUserName(String username) {
        return _userInfoDao.getUserByUserName(username);
    }

    public boolean changePassword(String username, String password) {
        boolean status = false;
        Pattern passwordValidation = Pattern.compile(
                "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*.])[a-zA-Z0-9!@#$%^&*.]{8,16}");
        if (passwordValidation.matcher(password).matches()) {
            byte[] encoded = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
            String encodedPassword = new String(encoded);
            status = _userInfoDao.changePassword(username, encodedPassword);
        }
        return status;
    }

    public List<UserInfo> getAllStudents(int sub_id) {
        return _userInfoDao.getAllStudents(sub_id);
    }

    public List<UserInfo> getAllUsers() {
        return _userInfoDao.getAllUsers();
    }

    public boolean updateUser(UserInfo user) {
        return _userInfoDao.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return _userInfoDao.deleteUser(id);
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