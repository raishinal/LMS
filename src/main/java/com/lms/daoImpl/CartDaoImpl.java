/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.CartDao;
import com.lms.models.Cart;
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
public class CartDaoImpl implements CartDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(Cart c) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<Cart> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Cart> mcl = session.createQuery("from Cart ORDER BY orderdate DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Cart> selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Cart where id = :code ");
        query.setParameter("code", id);
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
            Query query = session.createQuery("delete from Cart where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public List<Cart> selectByUsername(String user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Cart where username = :code ");
        query.setParameter("code", user);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Cart> selectByDate(String date) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Cart> mcl = session.createQuery("from Cart WHERE orderdate > '"+date+"' ORDER BY orderdate DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Cart> selectByRetailer(int id) {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Cart where retailer = :code ");
        query.setParameter("code", id);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

}
