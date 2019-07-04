/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.serviceImpl;

import com.lms.dao.UserDao;
import com.lms.models.UserDetails;
import com.lms.models.UserRole;
import com.lms.service.UserService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\ListManagementSystem\\src\\main\\webapp\\resources";

    @Autowired
    private UserDao userDao;

    @Override
    public boolean uploadImage(MultipartFile image) {
        boolean status = false;

        File dir = new File(uploadDir + File.separator + "userimage");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filename = image.getOriginalFilename();
        File uploadImage = new File(dir + File.separator + filename);
        try {
            image.transferTo(uploadImage);
            status = true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    @Override
    public boolean saveUser(UserDetails ud) {
        return userDao.insert(ud);
    }

    @Override
    public List<UserDetails> findAllUser() {
        return userDao.selectAll();
    }

    @Override
    public UserDetails findUserById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.delete(id);
    }

    @Override
    public UserDetails findUserByUsername(String user) {
        return userDao.selectByUsername(user);
    }

    @Override
    public List<UserRole> findAllUserRole() {
        return userDao.selectAllUserrole();
    }

    @Override
    public boolean updateUser(UserDetails ud) {
        return userDao.update(ud);
    }

    @Override
    public List<UserDetails> findUserByDate(String date) {
        return userDao.selectAllByDate(date);
    }

}
