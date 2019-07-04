/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service;

import com.lms.models.UserDetails;
import com.lms.models.UserRole;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */
public interface UserService {

    boolean uploadImage(MultipartFile image);

    boolean saveUser(UserDetails ud);

    public List<UserDetails> findAllUser();

    public List<UserRole> findAllUserRole();

    public UserDetails findUserById(int id);

    public UserDetails findUserByUsername(String user);
    public List<UserDetails> findUserByDate(String date);

    public boolean deleteUser(int id);
    public boolean updateUser(UserDetails ud);

}
