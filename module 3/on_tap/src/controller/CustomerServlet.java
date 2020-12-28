package controller;

import model.*;
import reponsive.AttachServiceReponsive;
import reponsive.ContractDetailReponsive;
import reponsive.ContractReponsive;
import reponsive.CustomerReponsive;
import validate.UpperToCase;
import validate.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerReponsive customerReponsive = new CustomerReponsive();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                insertCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        CustomerType typeId = customerReponsive.selectCustomerType(Integer.parseInt(request.getParameter("typeId")));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        customerReponsive.updateCustomer(customer);
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<CustomerType> listCustomerType = customerReponsive.selectAllCustomerType();
        String message = "edit";
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listCustomerType", listCustomerType);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        CustomerType typeId = customerReponsive.selectCustomerType(Integer.parseInt(request.getParameter("typeId")));
        String name = request.getParameter("name");
        name = UpperToCase.capitalize(name);
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        Customer checkCustomer = customerReponsive.selectCustomer(id);
        String messageId = null;
        String messageBirthday = null;
        String messageIdCard = null;
        String messagePhone = null;
        String messageEmail = null;
        String messageDupplicate = null;
        String message = null;
        if(!Validate.checkCustomerId(id)){
            messageId = "KH-XXXX";
            message = "error";
        }if (!Validate.checkBirthday(birthday)){
            messageBirthday = "năm sinh phải nhỏ hơn năm hiện tại 18";
            message = "error";
        }if (!Validate.checkIdCard(idCard)){
            messageIdCard = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX\n" +
                    "(X là số 0-9)";
            message = "error";
        }if (!Validate.checkPhone(phone)){
            messagePhone = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc\n" +
                    "(84)+90xxxxxxx hoặc (84)+91xxxxxxx";
            message = "error";
        }if (!Validate.checkEmail(email)){
            messageEmail = "Email phải đúng định dạng abc@abc.abc";
            message = "error";
        }
        if (checkCustomer != null){
            messageDupplicate = "This ID already exits";
            message = "error";
        }if (message == null) {
            try {
                customerReponsive.insertCustomer(customer);
                message = "access";
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<CustomerType> listCustomerType = customerReponsive.selectAllCustomerType();
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listCustomerType", listCustomerType);
        request.setAttribute("messageId", messageId);
        if(message.equals("error")){
            request.setAttribute("customer", customer);
        }
        request.setAttribute("message", message);
        request.setAttribute("messageBirthday", messageBirthday);
        request.setAttribute("messageIdCard", messageIdCard);
        request.setAttribute("messagePhone", messagePhone);
        request.setAttribute("messageEmail", messageEmail);
        request.setAttribute("messageDupplicate", messageDupplicate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "show":
//                listCustomerUseService(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search_customer");
        List<Customer> listCustomer = customerReponsive.searchCustomerByName(name);
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer existingCustomer = customerReponsive.selectCustomer(id);
        List<CustomerType> listCustomerType = customerReponsive.selectAllCustomerType();
        request.setAttribute("listCustomerType", listCustomerType);
        request.setAttribute("customer", existingCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String message = null;
        if(!customerReponsive.deleteCustomer(id)){
            message = "Customer is using";
        }else {
            message = "delete";
        }

        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<CustomerType> listCustomerType = customerReponsive.selectAllCustomerType();
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listCustomerType", listCustomerType);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<CustomerType> listCustomerType = customerReponsive.selectAllCustomerType();
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listCustomerType", listCustomerType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
