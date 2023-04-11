// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author omkargujar.
 */
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "Id",unique = true,nullable = false)
    private int _id;
    @Column(name = "First_Name",nullable = false)
    private String _firstName;
    @Column(name = "Last_Name",nullable = false)
    private String _lastName;
    @Column(name = "DOB",nullable = false)
    private LocalDate _dateOfBirth;
    @Column(name = "Age",nullable = false)
    private int _age;
    @Column(name = "user_type",nullable = false)
    private String _userType;
    @Column(name = "username",unique = true,nullable = false)
    private String _username;
    @Column(name = "password",nullable = false)
    private String _password;
    @Type(type = "true_false")
    @Column(name = "is_password_changed",nullable = false)
    private boolean _isPasswordChanged = false;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Subject> _subjects = new ArrayList<>();

    @OneToMany(mappedBy = "_student")
    private List<Attendance> _attendance;

    public UserInfo(int id, String firstName, String lastName, LocalDate dateOfBirth, int age, String userType,
            List<Subject> subjects) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
        _dateOfBirth = dateOfBirth;
        _age = age;
        _userType = userType;
        _subjects = subjects;
    }

    public UserInfo() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return _dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        _dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        _age = age;
    }

    public List<Subject> getSubjects() {
        return _subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        _subjects = subjects;
    }

    public String getUserType() {
        return _userType;
    }

    public void setUserType(String userType) {
        _userType = userType;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public boolean isPasswordChanged() {
        return _isPasswordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        _isPasswordChanged = passwordChanged;
    }

    public List<Attendance> getAttendance() {
        return _attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        _attendance = attendance;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "_id=" + _id + ", _firstName='" + _firstName + '\'' + ", _lastName='" + _lastName + '\''
                + ", _dateOfBirth=" + _dateOfBirth + ", _age=" + _age + ", _userType='" + _userType + '\''
                + ", _username='" + _username + '\'' + ", _subjects=" + _subjects + '}';
    }
}
