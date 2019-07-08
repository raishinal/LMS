/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.controller;

import com.lms.models.Items;
import com.lms.models.LikeCounts;
import com.lms.models.SessionCount;
import com.lms.models.UserDetails;
import com.lms.service.CategoryService;
import com.lms.service.ItemService;
import com.lms.service.LikeService;
import com.lms.service.SessionCountService;
import com.lms.service.UserService;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roslm
 */
@Controller
public class HomeController {

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
    private SessionCountService sessionCountService;
    @Autowired
    private SessionCount sessionCount;
    @Autowired
    private LikeService likeService;
     @Autowired
    private Items item;

    @Autowired
    LikeCounts likeCounts;

    @GetMapping("/Index")
    public ModelAndView showIndex(ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;

                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        int count = sessionCountService.getCount();
        count = count + 1;
        sessionCount.setCount(count);
        sessionCount.setId(1);
        sessionCount.setField("Index");
        sessionCount.setDate(sessionCountService.getDate());

        if (sessionCountService.updateCount(sessionCount)) {
            mv.addObject("count", "countfailure");
        } else {
            mv.addObject("count", "countsuccess");
        }
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("items", itemService.findLatestItems());
        mv.addObject("popularitems",itemService.findPopularItems());

        mv.setViewName("index");

        return mv;
    }

    @GetMapping("/About")
    public ModelAndView showAbout(ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.setViewName("about");

        return mv;
    }

    @GetMapping("/Contact")
    public ModelAndView showContact(ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.setViewName("contact");

        return mv;
    }

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public ModelAndView searchItem(@RequestParam("key") String key,
            ModelAndView mv,
            Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("subitem", itemService.findItemByKey(key));
        mv.setViewName("categories");
        return mv;
    }

    @GetMapping("/Category/Show")
    public ModelAndView showCategory(ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.setViewName("categories");
        return mv;
    }

    @GetMapping("/Category/Item/Show/{sub}")
    public ModelAndView showProductByCategory(@PathVariable int sub, ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        List<Items> items = itemService.findItemBySub(sub);

        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("subitem", items);
        mv.addObject("subid", sub);
        mv.setViewName("categories");
        return mv;
    }

    @RequestMapping(value = "/Category/Item/Filter/{sub}", method = RequestMethod.GET)
    public ModelAndView filterProduct(@RequestParam("price") double price,
            @PathVariable int sub, ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        List<Items> items = itemService.filterByPrice(sub, price);

        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("subitem", items);
        mv.setViewName("categories");
        return mv;
    }

    @RequestMapping(value = "/Category/Item/FilterPrice/{sub}", method = RequestMethod.GET)
    public ModelAndView customfilterProduct(@RequestParam("customprice") double customprice,
            @PathVariable int sub, ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);
        List<Items> items = itemService.filterByPrice(sub, customprice);

        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("subitem", items);
        mv.setViewName("categories");
        return mv;
    }

    @GetMapping("/Item/{id}")
    public ModelAndView showItem(@PathVariable int id, ModelAndView mv, Principal p) {
        int ustatus = 0;
        int type = 0;
        try {
            if (p.getName() != null) {
                ustatus = 1;
                mv.addObject("username", p.getName());

                if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_USER")) {
                    type = 1;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_RETAILER")) {
                    type = 2;
                } else if (userService.findUserByUsername(p.getName()).getUserRole().getAuthority().equals("ROLE_ADMIN")) {
                    type = 3;
                }
                mv.addObject("user_type", type);
                if(likeService.checkUserItem(id, userService.findUserByUsername(p.getName()).getId())){
                    mv.addObject("likecheck",0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        mv.addObject("status", ustatus);

        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.addObject("item", itemService.findItemById(id));
        mv.setViewName("item");
        return mv;
    }

    @RequestMapping("/Item/get_time")
    @ResponseBody
    String getTime() {
        Date d = new Date();
        return d.toString();
    }

     @RequestMapping(value="/User/Item/Like/{id}", method=RequestMethod.GET)
//    @ResponseBody
    public String addLike(@PathVariable int id,Principal p) {
        Items i=itemService.findItemById(id);
        item.setId(id);
        item.setName(i.getName());
        item.setStock(i.getStock());
        item.setCategory(i.getCategory());
        item.setTags(i.getTags());
        item.setDescription(i.getDescription());
        item.setPrice(i.getPrice());
        item.setRetailer(0);
        item.setImageName(i.getImageName());
        int counts = i.getLikecounts();
        counts=counts+1;
        item.setLikecounts(counts);
        item.setPosted_date(i.getPosted_date());
        if(itemService.updateItem(item)){
            likeCounts.setDate(formattedDateTime);
        likeCounts.setItemid(id);
        likeCounts.setUserid(userService.findUserByUsername(p.getName()).getId());
        if(likeService.addItem(likeCounts)){
            return "redirect:/Item/"+id+"?success";
        }
        else{
            return "redirect:/Item/"+id+"?failed";
        }
        }
        else{
            return "redirect:/Item/"+id+"?failed_item_update";
        }
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        return "accessDenied";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth1);
        if (auth1 != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth1);
        }
        return "redirect:/Index";
    }

    @GetMapping("/Register")
    public ModelAndView registerUser(ModelAndView mv) {
        mv.addObject("sublist", categoryService.findSubCategory());
        mv.setViewName("registration");

        return mv;
    }

    @RequestMapping(value = "/UserRegistration", method = RequestMethod.POST)
    public String registerUser(
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("dob") String dob,
            @RequestParam("country") String country,
            @RequestParam("interest") String interest,
            @RequestParam("address") String address,
            @RequestParam("userType") String userType,
            @RequestParam("image") MultipartFile image,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword
    ) {

        // password
        if (password.equals(cpassword)) {
            userDetails.setPassword(passwordEncoder.encode(password));
        } else {
            return "redirect:/Register?PasswordMismatch";
        }
        // image 
        if (!image.isEmpty()) {
            if (userService.uploadImage(image)) {
                userDetails.setImageName(image.getOriginalFilename());
            } else {
                return "redirect:/Register?ImageUploadFailed";
            }
        } else {
            return "redirect:/Register?ImageNotSelected";
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
            return "redirect:/Register?UserRegistrationFailed";
        }

        return "redirect:/Register?Success";
    }
}
