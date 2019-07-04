/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.UserDao;
import com.lms.models.UserDetails;
import com.lms.models.UserRole;
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
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(UserDetails ud) {

        boolean status = false;
        UserRole ur = new UserRole();
        if (ud.getUserType().equals("ROLE_USER")) {
            ud.setActive(1);
            ur.setAuthority("ROLE_USER");
        }
        else if(ud.getUserType().equals("ROLE_RETAILER")){
            ud.setActive(1);
            ur.setAuthority("ROLE_RETAILER");
        }
        else {
            ud.setActive(0);
            ur.setAuthority("ROLE_ADMIN");
        }
        ud.setUserRole(ur);

        // making relation bidirectional
        ur.setUserDetails(ud);

        // save userlogin object into database
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(ud);
            session.getTransaction().commit();
            status = true;
        }

        return status;

    }

    @Override
    public List<UserDetails> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserDetails ORDER BY startdate DESC ");
        List<UserDetails> mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public UserDetails selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user;
        user = (UserDetails) session.get(UserDetails.class, id);
//        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public boolean delete(int id) {
        boolean status = false;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
//            sessionFactory.getCurrentSession().createQuery("delete from UserDetails where id = " + id).
            UserDetails user;
            user = (UserDetails) session.get(UserDetails.class, id);
            session.delete(user);
            session.getTransaction().commit();
            status = true;
        }
        return status;
    }

    @Override
    public UserDetails selectByUsername(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserDetails where userName = :code ");
        query.setParameter("code", userName);
        List<UserDetails> mcl = query.list();
        UserDetails item = mcl.get(0);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public List<UserRole> selectAllUserrole() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserRole> mcl = session.createCriteria(UserRole.class).list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(UserDetails ud) {
        boolean status = false;
//        UserRole ur = new UserRole();
//        if(ud.getUserType().equals("User")){
//        ud.setActive(1);
//        ur.setAuthority("ROLE_USER");
//        }
//        else{
//        ud.setActive(0);
//        ur.setAuthority("ROLE_ADMIN");
//        }
//        ud.setUserRole(ur);
//
//        // making relation bidirectional
//        ur.setUserDetails(ud);

        // save userlogin object into database
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(ud);
            session.getTransaction().commit();
            status = true;
        }

        return status;
    }

    @Override
    public List<UserDetails> selectAllByDate(String date) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserDetails> mcl = session.createQuery("from UserDetails WHERE startdate > '" + date + "' ORDER BY startdate DESC").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

}
