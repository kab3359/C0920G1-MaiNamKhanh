package bradley.controllers;

import bradley.model.Customer;
import bradley.service.CustomerService;
import bradley.service.CustomerServiceFactory;
import bradley.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/money")
    public String showForm(){
        return "customers/chuyen_doi_tien_te";
    }

    @PostMapping("/money")
    public String showForm(HttpServletRequest request, Model model){
        double usd = Double.parseDouble(request.getParameter("usd"));
        double rs = usd * 23000;
        model.addAttribute("rs", rs);
        return "customers/chuyen_doi_tien_te";
    }
}
