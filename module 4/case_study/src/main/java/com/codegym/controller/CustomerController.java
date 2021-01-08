package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("customerList", customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }
}
