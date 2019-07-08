/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.controller;

import com.lms.models.Items;
import com.lms.models.UserDetails;
import com.lms.service.CartService;
import com.lms.service.CategoryService;
import com.lms.service.ItemService;
import com.lms.service.UserService;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class RetailerController {
        private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(dtf);
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
    @Autowired
    private Items item;
    @GetMapping("/Retailer/Profile")
    public ModelAndView showProfile(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",2);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());

        mv.setViewName("/user/profile");

        return mv;
    }
    
      @GetMapping("/Retailer/ChangePassword")
    public ModelAndView changePassword(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",2);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());

        mv.setViewName("/user/changepassword");

        return mv;
    }
    
      @GetMapping("/Retailer/Items/Add")
    public ModelAndView addItemByRetailer(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",2);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());
         mv.addObject("categorylist", categoryService.findAllCategory());
         mv.addObject("tagslist", categoryService.findAllCategory());

        mv.setViewName("/user/additem");

        return mv;
    }
      @GetMapping("/Retailer/Items/Show")
    public ModelAndView showItemByRetailer(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",2);
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        
        mv.addObject("itemlist", itemService.findByRetailer(userService.findUserByUsername(p.getName()).getId()));
        mv.setViewName("/user/retaileritem");

        return mv;
    }
    
    
    
    @RequestMapping(value = "/Retailer/UpdateUser", method = RequestMethod.POST)
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
                return "redirect:/Retailer/Profile?ImageUploadFailed";
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
            return "redirect:/Retailer/Profile?UserEditFailed";
        }

        return "redirect:/Retailer/Profile?Success";
    }

  
  

    @RequestMapping(value = "/Retailer/UpdatePassword", method = RequestMethod.POST)
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
                return "redirect:/Retailer/ChangePassword?PasswordMismatch";
            }
        } else {
            return "redirect:/Retailer/ChangePassword?Previous password mismatch";
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
            return "redirect:/Retailer/ChangePassword?UserEditFailed";
        }

        return "redirect:/Retailer/ChangePassword?Success";
    }
    
     @RequestMapping(value = "/Retailer/Item/Add", method = RequestMethod.POST)
    public String registerUser(@RequestParam("name") String name,
            @RequestParam("category") int category,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("stock") int stock,
            @RequestParam("image") MultipartFile image,
            Principal p
    ) {

        // image 
        if (!image.isEmpty()) {
            if (itemService.uploadImage(image)) {
                item.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Retailer/Items/Add?ImageNotUploaded";
            }
        } else {
            return "redirect:/Retailer/Items/Add?ImageNotSelected";
        }

        // other form data
        item.setName(name);
        item.setCategory(category);
        item.setDescription(description);
        item.setStock(stock);
        item.setTags(tags);
        item.setPrice(price);
        item.setRetailer(userService.findUserByUsername(p.getName()).getId());
        item.setLikecounts(0);
        item.setPosted_date(formattedDateTime);

        if (!itemService.addItem(item)) {
            return "redirect:/Retailer/Items/Add?Failed";
        } else {
            return "redirect:/Retailer/Items/Add?Success";
        }
    }
    
    
     @RequestMapping(value = "/Retailer/Item/Edit/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable int id, ModelAndView mv,Principal p) {
         mv.addObject("username", p.getName());
        mv.addObject("user_type",2);
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("item", itemService.findItemById(id));
        mv.setViewName("user/edititem");
        return mv;
    }

    @RequestMapping(value = "/Retailer/Item/Update", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("stock") int stock,
            @RequestParam("category") int category,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("imagename") String imagename,
            @RequestParam("image") MultipartFile image,
            Principal p
    ) {

        // image 
        if (!image.isEmpty()) {
            if (itemService.uploadImage(image)) {
                item.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Retailer/Items/Show?ImageUploadFailed";
            }
        } else {

            item.setImageName(imagename);

        }
        Items i = itemService.findItemById(id);

        // other form data
        item.setId(id);
        item.setName(name);
        item.setStock(stock);
        item.setCategory(category);
        item.setTags(tags);
        item.setDescription(description);
        item.setPrice(price);
        item.setRetailer(i.getRetailer());
        item.setLikecounts(i.getLikecounts());
        item.setPosted_date(i.getPosted_date());

        if (!itemService.updateItem(item)) {
            return "redirect:/Retailer/Items/Show?failed";
        } else {

            return "redirect:/Retailer/Items/Show?Success";
        }

    }

    @RequestMapping(value = "/Retailer/Item/Delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        if (itemService.deleteItem(id)) {
            return "redirect:/Retailer/Items/Show?Success";

        } else {
            return "redirect:/Retailer/Items/Show?Failed";
        }
    }
    
    
     @GetMapping("/Retailer/Order/Show")
    public ModelAndView showOrder(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("user_type",2);
        mv.addObject("userdetail", userService.findUserByUsername(p.getName()));
        mv.addObject("status", 1);
        mv.addObject("sublist", categoryService.findSubCategory());
        int id=userService.findUserByUsername(p.getName()).getId();
        mv.addObject("order",cartService.findCartByRetailer(id));

        mv.setViewName("/user/retailerorder");

        return mv;
    }
    
       @RequestMapping(value = "/Retailer/Order/Delivered/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable int id) {
        if (cartService.deleteCart(id)) {
            return "redirect:/Retailer/Order/Show?Success";

        } else {
            return "redirect:/Retailer/Order/Show?Failed";
        }
    }



}
