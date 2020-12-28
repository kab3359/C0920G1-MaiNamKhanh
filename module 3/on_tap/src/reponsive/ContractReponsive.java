package reponsive;

import connection.MySQLconnection;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractReponsive {
    MySQLconnection mySQLconnection = new MySQLconnection();
    EmployeeReponsive employeeReponsive = new EmployeeReponsive();
    CustomerReponsive customerReponsive = new CustomerReponsive();
    ServiceReponsive serviceReponsive = new ServiceReponsive();

    private static final String SELECT_ALL_CONTRACT = "select * from contract";
    private static final String INSERT_CONTRACT_SQL = "INSERT INTO contract" + "  (contract_id, contract_start_date, contract_end_date, " +
            "contract_deposit, contract_total_money, employee_id, customer_id, service_id)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_CONTRACT_SQL = "delete from contract where contract_id = ?;";
    private static final String UPDATE_CONTRACT_SQL = "update contract set contract_id = ?, contract_start_date= ?," +
            " contract_end_date = ?, contract_deposit = ?, contract_total_money= ?, employee_id= ?, customer_id= ?," +
            "service_id= ? where contract_id = ?";
    private static final String SELECT_CONTRACT_BY_ID = "SELECT * FROM contract WHERE contract_id = ?";
    private static final String SEARCH_CUSTOMER_BY_NAME = "SELECT * FROM customer WHERE customer_name LIKE '%' ? '%'";
    private static final String SELECT_ALL_CUSTOMER_USE_SERVICE = "SELECT * FROM customer JOIN contract on " +
            "customer.customer_id = contract.customer_id LEFT JOIN contract_detail on " +
            "contract_detail.contract_id = contract.contract_id left JOIN attach_service on " +
            "contract_detail.attach_service_id = attach_service.attach_service_id WHERE now() between contract.contract_start_date AND contract.contract_end_date";

    public List<Contract> selectAllContract(){
        List<Contract> contracts = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("contract_id");
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                Date date = dt.parse(startDate);
                Date date1 = dt.parse(endDate);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
                String beginDate = dt1.format(date);
                String endDay = dt1.format(date1);
                double deposit = rs.getDouble("contract_deposit");
                double totalMoney = rs.getDouble("contract_total_money");
                Employee employeeId = employeeReponsive.selectEmployee(rs.getInt("employee_id"));
                Customer customerId = customerReponsive.selectCustomer(rs.getString("customer_id"));
                Service serviceId = serviceReponsive.selectService(rs.getString("service_id"));

                contracts.add(new Contract(id, beginDate, endDay, deposit, totalMoney, employeeId, customerId, serviceId));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }return contracts;
    }

    public void insertContract(Contract contract) throws SQLException {
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_SQL);) {
            preparedStatement.setInt(1, contract.getId());
            preparedStatement.setString(2, contract.getStartDate());
            preparedStatement.setString(3, contract.getEndDate());
            preparedStatement.setDouble(4, contract.getDeposit());
            preparedStatement.setDouble(5, contract.getTotalMoney());
            preparedStatement.setInt(6, contract.getEmployeeId().getId());
            preparedStatement.setString(7, contract.getCustomerId().getId());
            preparedStatement.setString(8, contract.getServiceId().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
    }

    public Contract selectContract(int id) {
        Contract contract = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
//                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
//                Date date = dt.parse(startDate);
//                Date date1 = dt.parse(endDate);
//                SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
//                String beginDate = dt1.format(date);
//                String endDay = dt1.format(date1);
                double deposit = rs.getDouble("contract_deposit");
                double totalMoney = rs.getDouble("contract_total_money");
                Employee employeeId = employeeReponsive.selectEmployee(rs.getInt("employee_id"));
                Customer customerId = customerReponsive.selectCustomer(rs.getString("customer_id"));
                Service serviceId = serviceReponsive.selectService(rs.getString("service_id"));

                contract = new Contract(id, startDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return contract;
    }

    public boolean updateContract(Contract contract) {
        boolean rowUpdated = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_SQL);) {
                preparedStatement.setInt(1, contract.getId());
                preparedStatement.setString(2, contract.getStartDate());
                preparedStatement.setString(3, contract.getEndDate());
                preparedStatement.setDouble(4, contract.getDeposit());
                preparedStatement.setDouble(5, contract.getTotalMoney());
                preparedStatement.setInt(6, contract.getEmployeeId().getId());
                preparedStatement.setString(7, contract.getCustomerId().getId());
                preparedStatement.setString(8, contract.getServiceId().getId());
                preparedStatement.setInt(9, contract.getId());

                rowUpdated = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean deleteContract(int id){
        boolean rowDeleted = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_SQL);) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public List<Contract> selectAllCustomerUseService(){
        ContractDetailReponsive contractDetailReponsive = new ContractDetailReponsive();
        List<Contract> contracts = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_USE_SERVICE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int idContract = rs.getInt("contract_id");
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                Date date = null;
                try {
                    date = dt.parse(startDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date date1 = null;
                try {
                    date1 = dt.parse(endDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
                String beginDate = dt1.format(date);
                String endDay = dt1.format(date1);
                double deposit = rs.getDouble("contract_deposit");
                double totalMoney = rs.getDouble("contract_total_money");
                Employee employeeId = employeeReponsive.selectEmployee(rs.getInt("employee_id"));
                Customer customerId = customerReponsive.selectCustomer(rs.getString("customer_id"));
                Service serviceId = serviceReponsive.selectService(rs.getString("service_id"));
                ContractDetail contractDetail = contractDetailReponsive.selectContractDetail(rs.getInt("contract_detail_id"));
                contracts.add(new Contract(idContract, beginDate, endDay, deposit, totalMoney, employeeId, customerId, serviceId, contractDetail));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return contracts;
    }
}
