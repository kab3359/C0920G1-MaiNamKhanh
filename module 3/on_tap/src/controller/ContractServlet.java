package controller;

import model.*;
import reponsive.ContractReponsive;
import reponsive.CustomerReponsive;
import reponsive.EmployeeReponsive;
import reponsive.ServiceReponsive;
import validate.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractReponsive contractReponsive = new ContractReponsive();
    EmployeeReponsive employeeReponsive = new EmployeeReponsive();
    CustomerReponsive customerReponsive = new CustomerReponsive();
    ServiceReponsive serviceReponsive = new ServiceReponsive();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertContract(request, response);
                break;
            case "update":
                updateContract(request, response);
                break;
            case "search":
//                listCustomerByKeyword(request, response);
                break;
            default:
                listContract(request, response);
                break;
        }
    }

    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Employee employeeId = employeeReponsive.selectEmployee(Integer.parseInt(request.getParameter("employeeId")));
        Customer customerId = customerReponsive.selectCustomer(request.getParameter("customerId"));
        Service serviceId = serviceReponsive.selectService(request.getParameter("serviceId"));
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
        contractReponsive.updateContract(contract);
        List<Contract> listContract = contractReponsive.selectAllContract();
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        List<Service> listService = serviceReponsive.selectAllService();
        request.setAttribute("listContract", listContract);
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Employee employeeId = employeeReponsive.selectEmployee(Integer.parseInt(request.getParameter("employeeId")));
        Customer customerId = customerReponsive.selectCustomer(request.getParameter("customerId"));
        Service serviceId = serviceReponsive.selectService(request.getParameter("serviceId"));
        String message;
        Contract contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
        try {
            contractReponsive.insertContract(contract);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("contract");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
//                listCustomerByKeyword(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "cusUseSer":
                listCustomerUseService(request, response);
                break;
            default:
                listContract(request, response);
                break;
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        contractReponsive.deleteContract(id);
        List<Contract> listContract = contractReponsive.selectAllContract();
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        List<Service> listService = serviceReponsive.selectAllService();
        request.setAttribute("listContract", listContract);
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
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
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        List<Service> listService = serviceReponsive.selectAllService();
        int id = Integer.parseInt(request.getParameter("id"));
        Contract existingContract = contractReponsive.selectContract(id);
        request.setAttribute("contract", existingContract);
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> listContract = contractReponsive.selectAllContract();
        List<Customer> listCustomer = customerReponsive.selectAllCustomer();
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        List<Service> listService = serviceReponsive.selectAllService();
        request.setAttribute("listContract", listContract);
        request.setAttribute("listCustomer", listCustomer);
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomerUseService(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> listContract = contractReponsive.selectAllCustomerUseService();
        request.setAttribute("listContract", listContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list1.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
