/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.controller;

import com.lms.models.Alerts;
import com.lms.models.Cart;
import com.lms.models.Items;
import com.lms.service.AlertService;
import com.lms.service.CartService;
import com.lms.service.CategoryService;
import com.lms.service.ItemService;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author roslm
 */
@Controller
public class OrderController {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String formattedDateTime = now.format(dtf);

    @Autowired
    private Items item;
    @Autowired
    private Cart cart;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;
    @Autowired
    AlertService alertService;

    @RequestMapping(value = "/User/Order/{id}", method = RequestMethod.GET)
    public String userPurchase(
            @PathVariable int id,
            @RequestParam("no") int number,
            Principal p) {
        Items it = itemService.findItemById(id);
        int quantity = it.getStock();
        
        quantity = quantity - number;
        if(quantity<0){
            return "redirect:/User/Order/Show?no_item_in_stock";
        }
        if(quantity<=5){
            Alerts al= new Alerts();
            al.setTitle("Low on Supplies");
            al.setCause(it.getName());
            al.setRelatedid(id);
            al.setDetail("the supplies are low please all new to stock");
            al.setDate(formattedDateTime);
            if(alertService.addAlert(al)){
                
            }
        }
        item.setId(it.getId());
        item.setName(it.getName());
        item.setStock(quantity);
        item.setCategory(it.getCategory());
        item.setTags(it.getTags());
        item.setDescription(it.getDescription());
        item.setPrice(it.getPrice());
        item.setImageName(it.getImageName());
        item.setPosted_date(it.getPosted_date());
        if (!itemService.updateItem(item)) {
            return "redirect:/User/Order/Show?Failure in updating item";
        } else {

        }

        cart.setUsername(p.getName());
        cart.setProductid(it.getId());
        cart.setQuantity(number);
        cart.setPrice(it.getPrice());
        cart.setProductname(it.getName());
        cart.setProductimage(it.getImageName());
        cart.setOrderdate(formattedDateTime);
        if (cartService.addCart(cart)) {

        } else {
            return "redirect:/User/Order/Show?Error in adding to cart";
        }

        return "redirect:/User/Order/Show?Purchase Success";

    }

}
