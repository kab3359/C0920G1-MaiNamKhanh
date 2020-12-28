package reponsive;

import connection.MySQLconnection;
import model.Employee;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReponsive {
    MySQLconnection mySQLconnection = new MySQLconnection();
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "  (employee_id, employee_name, employee_brithday, " +
            "employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id," +
            "education_degree_id, division_id, username)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_id = ?, employee_name= ?," +
            " employee_brithday = ?, employee_id_card = ?, employee_salary= ?, employee_phone= ?, employee_email= ?," +
            "employee_address= ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? where employee_id = ?";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE employee_id = ?";
    private static final String SEARCH_EMPLOYEE_BY_NAME = "SELECT * FROM employee WHERE employee_name LIKE '%' ? '%'";

    public List<Employee> selectAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_brithday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");

                employees.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                        educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return employees;
    }

    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_brithday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");

                employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                        educationDegreeId, divisionId, username);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return employee;
    }

    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getBirthday());
            preparedStatement.setString(4, employee.getIdCard());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, employee.getPositionId());
            preparedStatement.setInt(10, employee.getEducationDegreeId());
            preparedStatement.setInt(11, employee.getDivisionId());
            preparedStatement.setString(12, employee.getUsername());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
    }

    public boolean deleteEmployee(int id){
        boolean rowDeleted = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) {
        boolean rowUpdated = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
                preparedStatement.setInt(1, employee.getId());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setString(3, employee.getBirthday());
                preparedStatement.setString(4, employee.getIdCard());
                preparedStatement.setDouble(5, employee.getSalary());
                preparedStatement.setString(6, employee.getPhone());
                preparedStatement.setString(7, employee.getEmail());
                preparedStatement.setString(8, employee.getAddress());
                preparedStatement.setInt(9, employee.getPositionId());
                preparedStatement.setInt(10, employee.getEducationDegreeId());
                preparedStatement.setInt(11, employee.getDivisionId());
                preparedStatement.setString(12, employee.getUsername());
                preparedStatement.setInt(13, employee.getId());

                rowUpdated = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public List<Employee> searchEmployeeByName(String name_search){
        List<Employee> employees = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, name_search);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_brithday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");

                employees.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                        educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
