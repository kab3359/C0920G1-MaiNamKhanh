package com.codegym.controller;

import com.codegym.entity.City;
import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import com.codegym.entity.Ward;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;
    @Autowired
    CityService cityService;
    @Autowired
    DistrictService districtService;
    @Autowired
    WardService wardService;

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
        model.addAttribute("city", cityService.findAll());
        return "customer/create";
    }
    @GetMapping("/listDistrict/{id}")
    public String listDistrict(@PathVariable int id, Model model){
        model.addAttribute("district", "abc");
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("city", cityService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute  Customer customer, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            model.addAttribute("status", "error");
            return "customer/list";
        }else {
            redirectAttributes.addFlashAttribute("status", "create");
            redirectAttributes.addFlashAttribute("message", "Thêm thành công");
            customerService.save(customer);
            return "redirect:/customer/";
        }
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes){
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("status", "delete");
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/customer/";
    }

    @GetMapping("/edit/{id}")
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
    public ModelAndView listCustomers(){
        List<Customer> customers = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findAll();
//        List<City> cities = cityService.findAll();
//        ArrayList<City> arrayList = null;
//        arrayList.addAll(cities);
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypeList", customerTypeList);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
