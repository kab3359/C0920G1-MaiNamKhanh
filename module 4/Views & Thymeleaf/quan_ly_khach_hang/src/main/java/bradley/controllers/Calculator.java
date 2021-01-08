package bradley.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Calculator {
    @GetMapping("/calculator")
    public String show(){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam String calculator, @RequestParam String num1, @RequestParam String num2,
                             Model model){
        double result = 0;
        String message = null;
        switch (calculator){
            case "addition":
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                message = "Result addition:" + result;
                break;
            case "subtraction":
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                message = "Result subtraction:" + result;
                break;
            case "multiplication":
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                message = "Result multiplication:" + result;
                break;
            case "division":
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                message = "Result division:" + result;
                break;
        }model.addAttribute("message", message);
        return "index";
    }
}
