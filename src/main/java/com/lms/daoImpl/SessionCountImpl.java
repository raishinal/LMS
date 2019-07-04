/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.SessionCountDao;
import com.lms.models.SessionCount;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roslm
 */
@Repository
public class SessionCountImpl implements SessionCountDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(SessionCount sc) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(sc);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public int getCount() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<SessionCount> mcl = session.createQuery("from SessionCount").list();
        SessionCount ses= mcl.get(0);
        int count = ses.getCount();
        session.getTransaction().commit();
        session.close();
        return count;
    }

    @Override
    public boolean resetCount(int id) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from SessionCount where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public boolean updateCount(SessionCount sc) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(sc);
            session.getTransaction().commit();
            status = true;

        }
        return status;
    }

    @Override
    public SessionCount getsessioncount(int id) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where id = :code ");
        query.setParameter("code", id);
        List<SessionCount> mcl = query.list();
        SessionCount sc=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return sc;
    }

    @Override
    public String getDate() {
          Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<SessionCount> mcl = session.createQuery("from SessionCount").list();
        SessionCount ses= mcl.get(0);
        String date = ses.getDate();
        session.getTransaction().commit();
        session.close();
        return date;
    }

}
