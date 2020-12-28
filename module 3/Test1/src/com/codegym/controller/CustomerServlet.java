package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "searchById":
                searchCustomerById(request, response);
                break;
            case "searchByName":
                searchCustomerByName(request, response);
                break;
        }
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        boolean checkNameCustomer = false;
        for (Customer customer: CustomerDao.getAllCustomer()){
            if (customer.getName().contains(request.getParameter("search"))){
                customers.add(customer);
                checkNameCustomer = true;
            }
        }
        if(checkNameCustomer){
            request.setAttribute("listCustomer", customers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/searchCustomerByName.jsp");
            dispatcher.forward(request, response);
        }else {
            String message = "This name not already exits";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/index.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void searchCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("search"));
        Customer customer = CustomerDao.getCustomer(id);
        if (customer != null){
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/searchCustomerById.jsp");
            dispatcher.forward(request, response);
        }else {
            String message = "This ID not already exits";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer checkCustomer = CustomerDao.getCustomer(id);
        if (checkCustomer == null){
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Customer newCustomer = new Customer(id, name, phone ,email);
            CustomerDao.addCustomer(newCustomer);
            try {
                response.sendRedirect("customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            String message = "This ID already exits";
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Customer exitCustomer = new Customer(id, name, phone, email);
            request.setAttribute("message", message);
            request.setAttribute("customer", exitCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newCustomer.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Customer updateCustomer = new Customer(id, name, phone, email);
        CustomerDao.addCustomer(updateCustomer);
        response.sendRedirect("customer");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "new":
                showNewForm(request, response);
                break;
            case "delete":
                deleteCustomerById(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    public void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = CustomerDao.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/index.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomer(idCustomer);
        response.sendRedirect("customer");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerEdit = CustomerDao.getCustomer(id);
        request.setAttribute("customer", customerEdit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        dispatcher.forward(request, response);
    }
}
