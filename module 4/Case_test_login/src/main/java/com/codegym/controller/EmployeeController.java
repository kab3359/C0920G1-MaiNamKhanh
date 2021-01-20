package com.codegym.controller;

import com.codegym.service.DivisionService;
import com.codegym.service.EducationDegreeService;
import com.codegym.service.EmployeeService;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    DivisionService divisionService;

    @GetMapping({"","/list"})
    public String showList(Model model){
        model.addAttribute("listEmployee", employeeService.findAll());
        return "employee/list";
    }
}
