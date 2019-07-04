/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.controller;

import com.lms.models.UserDetails;
import com.lms.service.CartService;
import com.lms.service.CategoryService;
import com.lms.service.ItemService;
import com.lms.service.UserService;
import java.security.Principal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller

public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserDetails userDetails;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @GetMapping("/User/Profile")
    public ModelAndView showProfile(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",1);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());

        mv.setViewName("/user/profile");

        return mv;
    }

    @GetMapping("/User/ChangePassword")
    public ModelAndView changePassword(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",1);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());

        mv.setViewName("/user/changepassword");

        return mv;
    }

    @RequestMapping(value = "/User/UpdateUser", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("dob") String dob,
            @RequestParam("country") String country,
            @RequestParam("interest") String interest,
            @RequestParam("address") String address,
            @RequestParam("imagename") String imagename,
            @RequestParam("image") MultipartFile image,
            @RequestParam("username") String username,
            Principal p
    ) {

        // image 
        if (!image.isEmpty()) {
            if (userService.uploadImage(image)) {
                userDetails.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/User/Profile?ImageUploadFailed";
            }
        } else {

            userDetails.setImageName(imagename);

        }
        UserDetails ud = userService.findUserByUsername(p.getName());

        // other form data
        userDetails.setId(ud.getId());
        userDetails.setFirstname(fname);
        userDetails.setLastname(lname);
        userDetails.setActive(1);
        userDetails.setEmail(email);
        userDetails.setPhone(phone);
        userDetails.setDob(LocalDate.parse(dob));
        userDetails.setCountry(country);
        userDetails.setInterest(interest);
        userDetails.setAddress(address);
        userDetails.setStartdate(ud.getStartdate());
        userDetails.setUserName(username);
        userDetails.setUserType(ud.getUserType());
        userDetails.setPassword(ud.getPassword());

        if (!userService.updateUser(userDetails)) {
            return "redirect:/User/Profile?UserEditFailed";
        }

        return "redirect:/User/Profile?Success";
    }

  
  

    @RequestMapping(value = "/User/UpdatePassword", method = RequestMethod.POST)
    public String updatePassword(
            @RequestParam("ppassword") String ppass,
            @RequestParam("password") String pass,
            @RequestParam("cpassword") String cpass,
            Principal p
    ) {
        UserDetails ud = userService.findUserByUsername(p.getName());

        if (passwordEncoder.matches(ppass, ud.getPassword())) {

            if (pass.equals(cpass)) {
                userDetails.setPassword(passwordEncoder.encode(pass));
            } else {
                return "redirect:/User/ChangePassword?PasswordMismatch";
            }
        } else {
            return "redirect:/User/ChangePassword?Previous password mismatch";
        }

        // other form data
        userDetails.setId(ud.getId());
        userDetails.setFirstname(ud.getFirstname());
        userDetails.setLastname(ud.getLastname());
        userDetails.setActive(1);
        userDetails.setEmail(ud.getEmail());
        userDetails.setPhone(ud.getPhone());
        userDetails.setDob(ud.getDob());
        userDetails.setCountry(ud.getCountry());
        userDetails.setInterest(ud.getInterest());
        userDetails.setAddress(ud.getEmail());
        userDetails.setStartdate(ud.getStartdate());
        userDetails.setUserName(ud.getUserName());
        userDetails.setImageName(ud.getImageName());
        userDetails.setUserType(ud.getUserName());

        if (!userService.updateUser(userDetails)) {
            return "redirect:/User/ChangePassword?UserEditFailed";
        }

        return "redirect:/User/ChangePassword?Success";
    }
    
      @GetMapping("/User/Order/Show")
    public ModelAndView showOrder(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",1);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("order",cartService.findCartByUsername(p.getName()));

        mv.setViewName("/user/order");

        return mv;
    }

}
