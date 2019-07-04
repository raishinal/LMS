/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.AlertDao;
import com.lms.models.Alerts;
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
public class AlertDaoImpl implements AlertDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(Alerts al) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(al);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<Alerts> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Alerts> mcl = session.createQuery("from Alerts ORDER BY date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Alerts> selectById(int id) {
             Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Alerts where id = :code ");
        query.setParameter("code", id);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Alerts> selectByLatest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Alerts ORDER BY date DESC ");
        query.setFirstResult(0);
        query.setMaxResults(6);
        List mcl = query.list();
        
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean delete(int id) {
          boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Alerts where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

}
