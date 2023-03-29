// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * @author omkargujar.
 */
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column(name = "sub_id")
    private int _subId;
    @Column(name = "name")
    private String _name;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "_subjects")
    private List<UserInfo> _users = new ArrayList<>();

    public Subject(int subId, String name) {
        _subId = subId;
        _name = name;
    }

    public Subject() {
    }

    public int getSubId() {
        return _subId;
    }

    public void setSubId(int subId) {
        _subId = subId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public List<UserInfo> getUsers() {
        return _users;
    }

    public void setUsers(List<UserInfo> users) {
        _users = users;
    }

    public void addUser(UserInfo user) {
        _users.add(user);
    }
}
