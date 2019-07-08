/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.ItemDao;
import com.lms.models.Items;
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
public class ItemDaoImpl implements ItemDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(Items item) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<Items> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Items> mcl = session.createQuery("from Items ORDER BY posted_date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public Items selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where id = :code ");
        query.setParameter("code", id);
        List<Items> mcl = query.list();
        Items item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public List<Items> selectByCategory(int category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where category = :code ");
        query.setParameter("code", category);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> selectByTags(String tag) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where tags = :code ");
        query.setParameter("code", tag);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(Items item) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
            status = true;

        }
        return status;
    }

    @Override
    public boolean delete(int id) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Items where id = :code ");
            query.setParameter("code", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public List<Items> selectBySub(int sub) {
          Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where category = :code ");
        query.setParameter("code", sub);
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> searchKeywords(String key) {
              Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where name LIKE'%"+key+"%'");
        List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> findLatestItem() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items ORDER BY posted_date DESC ");
        query.setFirstResult(0);
        query.setMaxResults(6);
        List<Items> mcl = query.list();
        
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> findByDate(String date) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Items> mcl = session.createQuery("from Items WHERE posted_date > '"+date+"' ORDER BY posted_date DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> findByRetailer(int id) {
          Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where retailer = :code ");
        query.setParameter("code", id);
        List<Items> mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> findByPrice(int sub, double price) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items where category="+sub+" AND price <= "+price);
        List<Items> mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Items> findPopularItem() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Items ORDER BY likecounts DESC ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        List<Items> mcl = query.list();
        
        session.getTransaction().commit();
        session.close();
        return mcl;
    }
}
