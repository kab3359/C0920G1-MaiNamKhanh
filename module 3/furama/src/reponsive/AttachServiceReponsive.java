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

public class AttachServiceReponsive {
    MySQLconnection mySQLconnection = new MySQLconnection();
    private static final String SELECT_ALL_ATTACH_SERVICE = "select * from attach_service";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "  (employee_id, employee_name, employee_brithday, " +
            "employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id," +
            "education_degree_id, division_id, username)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_id = ?, employee_name= ?," +
            " employee_brithday = ?, employee_id_card = ?, employee_salary= ?, employee_phone= ?, employee_email= ?," +
            "employee_address= ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? where employee_id = ?";
    private static final String SELECT_ATTACH_SERVICE_BY_ID = "SELECT * FROM attach_service WHERE attach_service_id = ?";

    public AttachService selectAttachService(int id) {
        AttachService attachService = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("attach_service_name");
                double cost = rs.getDouble("attach_service_cost");
                String unit = rs.getString("attach_service_unit");
                String status = rs.getString("attach_service_status");

                attachService = new AttachService(id, name, cost, unit, status);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return attachService;
    }

    public List<AttachService> selectAllAttachService(){
        List<AttachService> attachServices = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("attach_service_id");
                String name = rs.getString("attach_service_name");
                double cost = rs.getDouble("attach_service_cost");
                String unit = rs.getString("attach_service_unit");
                String status = rs.getString("attach_service_status");

                attachServices.add(new AttachService(id, name, cost, unit, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return attachServices;
    }
}
