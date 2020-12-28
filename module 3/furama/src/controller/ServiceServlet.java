package controller;

import model.*;
import reponsive.CustomerReponsive;
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

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private ServiceReponsive serviceReponsive;

    public void init() {
        serviceReponsive = new ServiceReponsive();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                insertService(request, response);
                break;
            case "update":
                updateService(request, response);
                break;
            case "search":
                searchService(request, response);
                break;
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        RentType rentTypeId = serviceReponsive.selectRentTypeById(Integer.parseInt(request.getParameter("rentTypeId")));
        ServiceType serviceTypeId = serviceReponsive.selectServiceTypeById(Integer.parseInt(request.getParameter("serviceTypeId")));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        int poolArea = Integer.parseInt(request.getParameter("poolArea"));
        int numFloor = Integer.parseInt(request.getParameter("numFloor"));

        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom,
                description, poolArea, numFloor);
        serviceReponsive.updateService(service);
        List<Service> listService = serviceReponsive.selectAllService();
        List<ServiceType> listServiceType = serviceReponsive.selectAllServiceType();
        List<RentType> listRentType = serviceReponsive.selectAllRentType();
        request.setAttribute("listServiceType", listServiceType);
        request.setAttribute("listRentType", listRentType);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String messageArea = null;
        int area = 0;
        try {
            area = Integer.parseInt(request.getParameter("area"));
        }catch (NumberFormatException e){
            messageArea = "định đạng phải là số nguyên";
        }
        double cost = 0;
        String messageCost = null;
        try {
            cost = Double.parseDouble(request.getParameter("cost"));
        }catch (NumberFormatException e){
            messageCost = "định đạng phải là số thực";
        }
        int maxPeople = 0;
        String messageMaxPeople = null;
        try {
            maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        }catch (NumberFormatException e){
            messageMaxPeople = "định đạng phải là số nguyên";
        }
        RentType rentTypeId = serviceReponsive.selectRentTypeById(Integer.parseInt(request.getParameter("rentTypeId")));
        ServiceType serviceTypeId = serviceReponsive.selectServiceTypeById(Integer.parseInt(request.getParameter("serviceTypeId")));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        int poolArea = 0;
        String messagePoolArea = null;
        try {
            poolArea = Integer.parseInt(request.getParameter("poolArea"));
        }catch (NumberFormatException e){
            messagePoolArea = "định đạng phải là số nguyên";
        }
        int numFloor = 0;
        String messageNumFloor = null;
        try {
            numFloor = Integer.parseInt(request.getParameter("numFloor"));
        }catch (NumberFormatException e){
            messageNumFloor = "định đạng phải là số nguyên";
        }
        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom,
                description, poolArea, numFloor);
        Service checkService = serviceReponsive.selectService(id);
        String messageId = null;
        String messageDupplicate = null;
        String message = null;
        if(!Validate.checkServiceId(id)){
            messageId = "DV-XXXX";
            message = "error";
        }if (!Validate.checkInt(area)){
            messageArea = "Số phải lớn hơn 0";
        }if (!Validate.checkInt(maxPeople)){
            messageMaxPeople = "Số phải lớn hơn 0";
        }if (!Validate.checkInt(poolArea)){
            messagePoolArea = "Số phải lớn hơn 0";
        }if (!Validate.checkInt(numFloor)){
            messagePoolArea = "Số phải lớn hơn 0";
        }if (!Validate.checkDouble(cost)){
            messageCost = "Số phải lớn hơn 0";
        }
        if (checkService != null){
            messageDupplicate = "This ID already exits";
            message = "error";
        }if (message == null) {
            try {
                serviceReponsive.insertService(service);
                message = "access";
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        List<Service> listService = serviceReponsive.selectAllService();
        List<ServiceType> listServiceType = serviceReponsive.selectAllServiceType();
        List<RentType> listRentType = serviceReponsive.selectAllRentType();
        request.setAttribute("listServiceType", listServiceType);
        request.setAttribute("listRentType", listRentType);
        request.setAttribute("listService", listService);
        request.setAttribute("messageId", messageId);
        request.setAttribute("messageArea", messageArea);
        request.setAttribute("messageCost", messageCost);
        request.setAttribute("messageMaxPeople", messageMaxPeople);
        request.setAttribute("messagePoolArea", messagePoolArea);
        request.setAttribute("messageNumFloor", messageNumFloor);
        if(message.equals("error")){
            request.setAttribute("service", service);
        }
        request.setAttribute("message", message);
        request.setAttribute("messageDupplicate", messageDupplicate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
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
                deleteService(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search_service");
        List<Service> listService = serviceReponsive.searchServiceByName(name);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
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
        Service existingService = serviceReponsive.selectService(id);
        List<ServiceType> listServiceType = serviceReponsive.selectAllServiceType();
        List<RentType> listRentType = serviceReponsive.selectAllRentType();
        request.setAttribute("listServiceType", listServiceType);
        request.setAttribute("listRentType", listRentType);
        request.setAttribute("service", existingService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        serviceReponsive.deleteService(id);
        String message = "delete";
        List<Service> listService = serviceReponsive.selectAllService();
        List<ServiceType> listServiceType = serviceReponsive.selectAllServiceType();
        List<RentType> listRentType = serviceReponsive.selectAllRentType();
        request.setAttribute("listServiceType", listServiceType);
        request.setAttribute("listRentType", listRentType);
        request.setAttribute("message", message);
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
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

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> listService = serviceReponsive.selectAllService();
        List<ServiceType> listServiceType = serviceReponsive.selectAllServiceType();
        List<RentType> listRentType = serviceReponsive.selectAllRentType();
        request.setAttribute("listService", listService);
        request.setAttribute("listServiceType", listServiceType);
        request.setAttribute("listRentType", listRentType);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
