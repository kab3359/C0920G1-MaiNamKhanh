package controller;

import model.Customer;
import model.Employee;
import model.Service;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeReponsive employeeReponsive;

    public void init() {
        employeeReponsive = new EmployeeReponsive();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                insertEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");

        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                educationDegreeId, divisionId, username);
        employeeReponsive.updateEmployee(employee);
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        String message;
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                educationDegreeId, divisionId, username);
        Employee checkEmployee = employeeReponsive.selectEmployee(id);
        if (checkEmployee == null){
            try {
                employeeReponsive.insertEmployee(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                response.sendRedirect("employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            message = "This ID already exits";
            request.setAttribute("message", message);
            request.setAttribute("employee", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search_employee");
        List<Employee> listEmployee = employeeReponsive.searchEmployeeByName(name);
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
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
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeReponsive.selectEmployee(id);
        request.setAttribute("employee", existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        String messageDelete = null;
        if(!employeeReponsive.deleteEmployee(idDelete)){
            messageDelete = "employee đã dc sử dụng";
        }
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.setAttribute("messageDelete", messageDelete);
        request.setAttribute("idDelete", idDelete);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
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

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> listEmployee = employeeReponsive.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
