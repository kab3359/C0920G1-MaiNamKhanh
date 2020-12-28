package controller;

import dao.CustomerDao;
import dao.ServiceDao;
import model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/home")
public class Servlet extends HttpServlet {
    private ServiceDao serviceDao;
    private CustomerDao customerDao;

    public void init() {
        serviceDao = new ServiceDao();
        customerDao = new CustomerDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    insertService(request, response);
//                    break;
//                case "edit":
//                    updateService(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "new":
//                    showNewForm(request, response);
                break;
            case "edit":
//                    showEditForm(request, response);
                break;
            case "delete":
//                    deleteService(request, response);
                break;
            case "customer":
                listService(request, response, "customer");
                break;
            case "service":
                listService(request, response, "service");
            default:
                home(request, response);
                break;

        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private <T> void listService(HttpServletRequest request, HttpServletResponse response, String type) {
        List<T> list;
        RequestDispatcher dispatcher = null;
       if(type.equals("service")) {
           list = (List<T>) serviceDao.selectAllService();
           request.setAttribute("listService", list);
           dispatcher = request.getRequestDispatcher("service/list.jsp");
       } else if(type.equals("customer")){
            list = (List<T>) customerDao.selectAllUsers();
            request.setAttribute("listCustomer", list);
            dispatcher = request.getRequestDispatcher("customer/list.jsp");
        }
        try {
            assert dispatcher != null;
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

