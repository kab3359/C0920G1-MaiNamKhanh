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
    @Autowired
    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customer")
    public ModelAndView showInfo(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customers = customerService.findOne(id);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @PostMapping("/customers")
    public void showInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setEmail(req.getParameter("email"));
        customer.setAddress(req.getParameter("address"));

        Long id = Long.valueOf(req.getParameter("id"));
        customer.setId(id);
        customerService.save(customer);

        resp.sendRedirect("/customers");
    }
}
