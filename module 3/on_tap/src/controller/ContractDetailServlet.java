package controller;

import model.*;
import reponsive.AttachServiceReponsive;
import reponsive.ContractDetailReponsive;
import reponsive.ContractReponsive;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    ContractReponsive contractReponsive = new ContractReponsive();
    AttachServiceReponsive attachServiceReponsive = new AttachServiceReponsive();
    ContractDetailReponsive contractDetailReponsive = new ContractDetailReponsive();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertContractDetail(request, response);
                break;
            case "update":
//                updateContract(request, response);
                break;
            case "search":
//                listCustomerByKeyword(request, response);
                break;
            default:
//                listContract(request, response);
                break;
        }
    }

    private void insertContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contractId = contractReponsive.selectContract(Integer.parseInt(request.getParameter("contractId")));
        AttachService attachServiceId = attachServiceReponsive.selectAttachService(Integer.parseInt(request.getParameter("attachServiceId")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(id, contractId, attachServiceId, quantity);
        try {
            contractDetailReponsive.insertContractDetail(contractDetail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("contractDetail");
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
//                showEditForm(request, response);
                break;
            case "delete":
//                deleteContract(request, response);
                break;
            default:
                listContractDetail(request, response);
                break;
        }
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> listContractDetail = contractDetailReponsive.selectAllContractDetail();
        List<Contract> listContract = contractReponsive.selectAllContract();
        List<AttachService> listAttachService = attachServiceReponsive.selectAllAttachService();
        request.setAttribute("listContractDetail", listContractDetail);
        request.setAttribute("listContract", listContract);
        request.setAttribute("listAttachService", listAttachService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contractDetail/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
