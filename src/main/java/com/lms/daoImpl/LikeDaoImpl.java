/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.LikeDao;
import com.lms.models.LikeCounts;
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
public class LikeDaoImpl implements LikeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(LikeCounts lc) {
         boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(lc);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public LikeCounts select(int id) {
          Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from LikeCounts where id = :code ");
        query.setParameter("code", id);
        List<LikeCounts> mcl = query.list();
        LikeCounts item=mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean checkuser(int itemid, int userid) {
        boolean check= true;
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from LikeCounts where userid ="+userid+" AND itemid="+itemid);
        List<LikeCounts> mcl = query.list();
        if(mcl.size()==0){
            check=false;
        }
        session.getTransaction().commit();
        session.close();
        return check;
    }
}
