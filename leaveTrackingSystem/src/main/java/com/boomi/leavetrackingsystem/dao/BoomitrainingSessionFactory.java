// Copyright (c) 2023 Boomi, Inc.
package com.boomi.leavetrackingsystem.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author omkargujar.
 */
public class BoomitrainingSessionFactory {

    private static final SessionFactory _SESSION_FACTORY;

    static {
        _SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return _SESSION_FACTORY;
    }
}
