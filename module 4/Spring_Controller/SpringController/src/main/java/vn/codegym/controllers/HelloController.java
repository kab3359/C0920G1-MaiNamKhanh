package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Student;
import vn.codegym.services.StudentService;
import vn.codegym.services.StudentServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloPage(Model model, ModelMap modelMap) {
        model.addAttribute("studentName", "Nguyen Van A");
        modelMap.addAttribute("studentAge", 25);
        return "hello";
    }

    @RequestMapping(value = "/modelView", method = RequestMethod.GET)
    public ModelAndView getHelloPage2(Model model, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("studentName", "Nguyen Van B");
        modelAndView.addObject("studentAge", 22);
        return modelAndView;
    }

    @RequestMapping(value = "/modelView2", method = RequestMethod.GET)
    public ModelAndView getHelloPage3(Model model, ModelMap modelMap) {
//        Student student = new Student(1, "Nguyen Van C");
//        ModelAndView modelAndView = new ModelAndView("hello");
//        modelAndView.addObject(student);
        return new ModelAndView("hello", "student", new Student(2, "AAA"));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm() {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Student student = new Student(id, name);
        return new ModelAndView("hello", "student", student);
    }

    @Autowired
    StudentService studentService ;

//    public HelloController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView studentList(){
        return new ModelAndView("list", "studentList", studentService.findAll());
    }
}
