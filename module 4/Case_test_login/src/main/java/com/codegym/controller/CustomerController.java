package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;
//
//    @GetMapping({"", "/list"})
//    public String show(Model model){
//        model.addAttribute("customers", customerService.findAll());
//        return "customer/list";
//    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute  Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }
        customerService.save(customer);
        return "redirect:";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable String id){
        customerService.delete(id);
        return "redirect:/customer/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable String id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/edit";
    }

    @GetMapping("/searchByType")
    public String searchByType(@RequestParam int id, Model model){
        CustomerType customerType = customerTypeService.findById(id);
        List<Customer> customers = customerService.findAllByCustomerType(customerType);
        model.addAttribute("customerList", customers);
        return "customer/list";
    }

//    @GetMapping({"","/list"})
//    public String listCustomers(@PageableDefault(size = 2)Pageable pageable,Model model){
//       model.addAttribute("customers", customerService.findAll(pageable));
//       return "customer/list";
//    }

    @GetMapping({"","/list"})
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, @PageableDefault(size = 2) Pageable pageable,
                                      @RequestParam Optional<String> address){
        Page<Customer> customers;
        if(s.isPresent()){
            customers = customerService.findAllByNameContaining(s.get(), pageable);
        }else if(address.isPresent()) {
            customers = customerService.findAllByAddressContaining(address.get(), pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
