package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService ;

//    @RequestMapping(value = {"","/list"}, method = RequestMethod.GET)
//    @GetMapping(value = {"","/list"}, consumes = "application/json", produces = "text/html")
    @GetMapping(value = {"","/list"})
    public ModelAndView studentList(){
        return new ModelAndView("/student/list", "studentList", studentService.findAll());
    }


    @GetMapping(value = "/create")
    public String showCreateForm() {
        return "/student/create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes) {
        studentService.save(new Student(id, name));
        redirectAttributes.addFlashAttribute("successMsg", "Create student: "+name +" success!");
        return "redirect:/student";
//        return "forward:/student";
    }

    @GetMapping(value = "/edit/{id:[1-3]}")
    public String showEditPage(@PathVariable int id){
        System.out.println("da vao edit page: id = "+id);
        return "";
    }
}
