package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String show(Model model){
        model.addAttribute("studentList", this.studentService.findAll());
        return "student/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
        this.studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("student",this.studentService.findById(id));
        return "student/edit";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable int id){
     this.studentService.delete(id);
        return "redirect:";
    }
    @GetMapping("/{id}/detail")
    public String detail(Model model, @PathVariable int id){
        model.addAttribute("student",this.studentService.findById(id));
        return "student/detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("studentList", this.studentService.findByName(name));
        return "student/list";
    }
}
