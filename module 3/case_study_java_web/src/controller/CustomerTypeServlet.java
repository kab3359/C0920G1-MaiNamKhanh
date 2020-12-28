package controller;

import dao.CustomerDao;
import dao.CustomerTypeDao;
import model.CustomerType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerTypeServlet", urlPatterns = "/customerType")
public class CustomerTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerTypeDao CustomerTypeDao;

    public void init() {
        CustomerTypeDao = new CustomerTypeDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "/create":
//                createCustomer(request, response);
                break;
            case "/update":
//                updateCustomer(request, response);
                break;
            case "/searchById":
//                searchCustomerById(request, response);
                break;
            case "/searchByName":
//                searchCustomerByName(request, response);
                break;
        }
    }

//    private void insertCustomerType(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        userDAO.insertUser(newUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "/new":
//                showNewForm(request, response);
                break;
            case "/delete":
//                deleteCustomerById(request, response);
                break;
            case "/edit":
//                showEditForm(request, response);
                break;
            default:
                listCustomerType(request, response);
                break;
        }
    }

    private void listCustomerType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> listCustomerType = CustomerTypeDao.selectAllUsers();
        request.setAttribute("listCustomerType", listCustomerType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerType/list.jsp");
        dispatcher.forward(request, response);
    }
}
