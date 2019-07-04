/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.daoImpl;

import com.lms.dao.CategoryDao;
import com.lms.models.Category;
import java.util.ArrayList;
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
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(Category cat) {
     
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Category> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Category> mcl  = session.createQuery("from Category").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Category> selectMain() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Category> mcl = new ArrayList();
        List result = session.createQuery("from Category").list();
        for (Category cat : (List<Category>) result) {
          if(cat.getPid()==0){
              mcl.add(cat);
          }
        }
        session.getTransaction().commit();
        session.close();
        return mcl;
    }
    @Override
    public List<Category> selectSub() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Category> mcl = new ArrayList();
        List result = session.createQuery("from Category").list();
        for (Category cat : (List<Category>) result) {
          if(cat.getPid()>0){
              mcl.add(cat);
          }
        }
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Category> selectById(int id) {
         Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Category where id = :code ");
query.setParameter("code", id);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Category> selectByPid() {
               Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Category where pid = 0");
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(Category cat) {
        boolean status=false;
 try( Session session = sessionFactory.getCurrentSession()) {
           session.beginTransaction();
            session.update(cat);
            session.getTransaction().commit();
            status = true;
           
        }
 return status;
    }

    @Override
    public boolean delete(int id) {
        
          Category cat=new Category();
        cat.setId(id);
        boolean status=false;
 try( Session session = sessionFactory.getCurrentSession()) {
           session.beginTransaction();
            session.delete(cat);
            session.getTransaction().commit();
            session.close();
            status = true;
          
        }
 return status;
    }
    
}
