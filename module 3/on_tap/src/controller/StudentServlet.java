package controller;

import model.Customer;
import model.CustomerType;
import model.HocSinh;
import model.LopHoc;
import reponsive.CustomerReponsive;
import reponsive.HocSinhReponsive;
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
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private HocSinhReponsive hocSinhReponsive = new HocSinhReponsive();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                insertStudent(request, response);
                break;
            case "update":
//                updateCustomer(request, response);
                break;
            case "search":
//                searchCustomer(request, response);
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        LopHoc lopHoc = hocSinhReponsive.selectClass(Integer.parseInt(request.getParameter("idClass")));
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        HocSinh hocSinh = new HocSinh(id, name, lopHoc, birthday, gender, address);
        HocSinh checkStudent = hocSinhReponsive.selectStudent(id);
        String message = null;
        String messageDupplicate = null;
        if (checkStudent != null){
            messageDupplicate = "This ID already exits";
            message = "error";
        }if (message == null) {
            try {
                hocSinhReponsive.insertStudent(hocSinh);
                message = "access";
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        List<HocSinh> listStudent = hocSinhReponsive.selectAllStudent();
        List<LopHoc> listClass = hocSinhReponsive.selectAllClass();
        request.setAttribute("listStudent", listStudent);
        request.setAttribute("listClass", listClass);
        request.setAttribute("message", message);
        request.setAttribute("messageDupplicate", messageDupplicate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
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
//                deleteCustomer(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "show":
//                listCustomerUseService(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<HocSinh> listStudent = hocSinhReponsive.selectAllStudent();
        List<LopHoc> listClass = hocSinhReponsive.selectAllClass();
        request.setAttribute("listStudent", listStudent);
        request.setAttribute("listClass", listClass);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
