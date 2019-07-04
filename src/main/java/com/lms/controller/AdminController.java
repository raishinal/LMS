/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.controller;

import com.lms.models.Cart;
import com.lms.models.Items;
import com.lms.models.SessionCount;
import com.lms.models.UserDetails;
import com.lms.service.AlertService;
import com.lms.service.CartService;
import com.lms.service.ItemService;
import com.lms.service.SessionCountService;
import com.lms.service.UserService;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
public class AdminController {
private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime before= now.minusDays(21);
    String formattedDateTime = now.format(dtf);
    String formattedBefore = before.format(dtf);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetails user;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetails userDetails;

    @Autowired
    private CartService cartService;

    @Autowired
    private AlertService alertService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private SessionCountService sessionCountService;

           @Autowired
    private SessionCount sessionCount;
    @GetMapping("/Admin/Home")
    public ModelAndView adminHome(ModelAndView mv) {
        List<Items> items= itemService.findLatestByDate(formattedBefore);
        List<UserDetails> users= userService.findUserByDate(formattedBefore);
        List<Cart> carts= cartService.findCartByDate(formattedBefore);
        mv.addObject("itemlist",items);
        mv.addObject("orderlist",carts);
        mv.addObject("userlist",users);
        mv.addObject("no_of_users",users.size());
        mv.addObject("no_of_items",items.size());
        mv.addObject("no_of_order",carts.size());
        mv.addObject("pageviewcount",sessionCountService.getCount());
        mv.addObject("pageviewcountdate",sessionCountService.getDate());
        mv.addObject("alerts",alertService.findAlertByLatest());
        mv.setViewName("admin/dashboard");

        return mv;
    }

    @GetMapping("/Admin/Register")
    public ModelAndView registerUser(ModelAndView mv) {

        mv.setViewName("admin/register");

        return mv;
    }

    @RequestMapping(value = "/Admin/RegisterUser", method = RequestMethod.POST)
    public String registerUser(
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("dob") String dob,
            @RequestParam("country") String country,
            @RequestParam("interest") String interest,
            @RequestParam("address") String address,
            @RequestParam("image") MultipartFile image,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword,
            @RequestParam("userType") String userType
    ) {

        // password
        if (password.equals(cpassword)) {
            userDetails.setPassword(passwordEncoder.encode(password));
        } else {
            return "redirect:/Admin/Register?PasswordMismatch";
        }
        // image 
        if (!image.isEmpty()) {
            if (userService.uploadImage(image)) {
                userDetails.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Admin/Register?ImageUploadFailed";
            }
        } else {
            return "redirect:/Admin/Register?ImageNotSelected";
        }

        // other form data
        userDetails.setFirstname(fname);
        userDetails.setLastname(lname);
        userDetails.setActive(0);
        userDetails.setEmail(email);
        userDetails.setPhone(phone);
        userDetails.setDob(LocalDate.parse(dob));
        userDetails.setCountry(country);
        userDetails.setInterest(interest);
        userDetails.setAddress(address);
        userDetails.setStartdate(formattedDateTime);
        userDetails.setUserName(username);
        userDetails.setUserType(userType);

        if (!userService.saveUser(userDetails)) {
            return "redirect:/Admin/Register?UserRegistrationFailed";
        }

        return "redirect:/Admin/Register?Success";
    }

     @RequestMapping(value = "/Admin/Pagecount/Reset", method = RequestMethod.GET)
    public String resetCount() {
        sessionCount.setCount(0);
        sessionCount.setId(1);
        sessionCount.setField("Index");
        sessionCount.setDate(formattedDateTime);
        
        if (sessionCountService.updateCount(sessionCount)) {
             return "redirect:/Admin/Home";
        } 
        else{
             return "redirect:/Admin/Home?countresetfailed";
        }
       
    }

    @GetMapping("/Admin/ManageUser")
    public ModelAndView user_Management(ModelAndView mv, Principal p) {
        mv.addObject("user", p.getName());
        mv.setViewName("admin/manageuser");
        mv.addObject("userlist", userService.findAllUser());
        return mv;
    }

    @GetMapping("/Admin/ManageOrder")
    public ModelAndView order_Management(ModelAndView mv, Principal p) {
        mv.addObject("user", p.getName());
        mv.addObject("userlist", userService.findAllUser());
        mv.addObject("orders",cartService.findAllCart());
        mv.setViewName("admin/orderlist");
        return mv;
    }
    @RequestMapping(value = "/Admin/Order/Delivered/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        if (cartService.deleteCart(id)) {
            return "redirect:/Admin/ManageOrder?Success";

        } else {
            return "redirect:/Admin/ManageOrder?Failed";
        }
    }

    @GetMapping("/Admin/User/Remove/{id}")
    public ModelAndView removeUser(@PathVariable int id, ModelAndView mv, Principal p) {
        mv.addObject("user", p.getName());
        mv.setViewName("admin/manageuser");
        mv.addObject("stat", userService.deleteUser(id));
        mv.addObject("userlist", userService.findAllUser());
        return mv;
    }

    @GetMapping("/Admin/User/Edit/{id}")
    public ModelAndView editUser(@PathVariable int id, ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.setViewName("admin/edituser");
        mv.addObject("user", userService.findUserById(id));
        return mv;
    }

    @RequestMapping(value = "/Admin/UpdateUser", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam("id") int id,
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
            @RequestParam("userType") String userType
    ) {

        // image 
        if (!image.isEmpty()) {
            if (userService.uploadImage(image)) {
                userDetails.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Admin/ManageUser?ImageUploadFailed";
            }
        } else {

            userDetails.setImageName(imagename);

        }
        UserDetails ud = userService.findUserById(id);

        // other form data
        userDetails.setId(id);
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
        userDetails.setUserType(userType);
        userDetails.setPassword(ud.getPassword());

        if (!userService.updateUser(userDetails)) {
            return "redirect:/Admin/ManageUser?UserRegistrationFailed";
        }

        return "redirect:/Admin/ManageUser?Success";
    }
    
     @GetMapping("/Admin/Alert/Show")
    public ModelAndView showAlerts(ModelAndView mv, Principal p) {
        mv.addObject("username", p.getName());
        mv.addObject("alerts",alertService.findAllAlerts());
        mv.setViewName("admin/alertcenter");
        return mv;
    }
    @RequestMapping(value = "/Admin/Alert/Delete/{id}", method = RequestMethod.GET)
    public String deleteAlert(@PathVariable int id) {
        if (alertService.deleteAlert(id)) {
            return "redirect:/Admin/Alert/Show?Success";

        } else {
            return "redirect:/Admin/Alert/Show?Failed";
        }
    }
}
