package controller;

import common.Validate;
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

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceDao serviceDao;

    public void init() {
        serviceDao = new ServiceDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertService(request, response);
                    break;
                case "edit":
                    updateService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numFloor = Integer.parseInt(request.getParameter("numFloor"));

        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, description,
                poolArea, numFloor);
        serviceDao.updateService(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numFloor = Integer.parseInt(request.getParameter("numFloor"));
        String message;
        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, description,
                poolArea, numFloor);
        Service checkService = serviceDao.selectService(id);
        if(!Validate.checkServiceId(id)){
            message = "DV-XXXX";
            request.setAttribute("message", message);
            request.setAttribute("service", service);
            RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
            dispatcher.forward(request, response);
        }else if (checkService == null){
            serviceDao.insertService(service);
            response.sendRedirect("service");
        }else {
            message = "This ID already exits";
            request.setAttribute("message", message);
            request.setAttribute("service", service);
            RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteService(request, response);
                    break;
                default:
                    listService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Service> listService = serviceDao.selectAllService();
        request.setAttribute("listService", listService);
//        request.setAttribute("countCustomer", serviceDao.countCustomer());
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        serviceDao.deleteService(id);

        List<Service> listService = serviceDao.selectAllService();
        request.setAttribute("listService", listService);
//        request.setAttribute("countCustomer", customerDao.countCustomer());
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Service service = serviceDao.selectService(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        request.setAttribute("service", service);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }
}
