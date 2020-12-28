package reponsive;

import connection.MySQLconnection;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailReponsive {
    MySQLconnection mySQLconnection = new MySQLconnection();
    ContractReponsive contractReponsive = new ContractReponsive();
    AttachServiceReponsive attachServiceReponsive = new AttachServiceReponsive();
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail";
    private static final String INSERT_CONTRACT_DETAIL_SQL = "INSERT INTO contract_detail" + "  (contract_detail_id, " +
            "contract_id, attach_service_id, quantity)" +
            " VALUES " + " (?, ?, ?, ?);";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_id = ?, employee_name= ?," +
            " employee_brithday = ?, employee_id_card = ?, employee_salary= ?, employee_phone= ?, employee_email= ?," +
            "employee_address= ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? where employee_id = ?";
    private static final String SELECT_CONTRACT_DETAIL_BY_ID = "SELECT * FROM contract_detail WHERE contract_detail_id = ?";
    private static final String SEARCH_EMPLOYEE_BY_NAME = "SELECT * FROM employee WHERE employee_name LIKE '%' ? '%'";

    public List<ContractDetail> selectAllContractDetail(){
        List<ContractDetail> contractDetails = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("contract_detail_id");
                Contract contractId = contractReponsive.selectContract(rs.getInt("contract_id"));
                AttachService attachServiceId = attachServiceReponsive.selectAttachService(rs.getInt("attach_service_id"));
                int quantity = rs.getInt("quantity");

                contractDetails.add(new ContractDetail(id, contractId, attachServiceId, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return contractDetails;
    }

    public void insertContractDetail(ContractDetail contractDetail) throws SQLException {
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL);) {
            preparedStatement.setInt(1, contractDetail.getId());
            preparedStatement.setInt(2, contractDetail.getContractId().getId());
            preparedStatement.setInt(3, contractDetail.getAttachServiceId().getId());
            preparedStatement.setInt(4, contractDetail.getQuantity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
    }

    public ContractDetail selectContractDetail(int id) {
        ContractDetail contractDetail = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Contract contractId = contractReponsive.selectContract(rs.getInt("contract_id"));
                AttachService attachServiceId = attachServiceReponsive.selectAttachService(rs.getInt("attach_service_id"));
                int quantity = rs.getInt("quantity");

                contractDetail = new ContractDetail(id, contractId, attachServiceId, quantity);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return contractDetail;
    }
}
