package dao;

import connection.MySQLConnection;
import model.Employee;
import model.Service;

import java.sql.*;

public class EmployeeDao {
    MySQLConnection mySQLConnection = new MySQLConnection();

    public EmployeeDao(){};

    public void insertEmployee(Employee employee) throws SQLException {

        String query = "{CALL insert_employee(?,?,?,?,?,?,?,?,?,?,?)}";

        // try-with-resource statement will auto close the connection.

        try (Connection connection = mySQLConnection.getConnection();

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, employee.getId());
            callableStatement.setString(2, employee.getName());
            callableStatement.setString(3, employee.getBirthday());
            callableStatement.setString(4, employee.getIdCard());
            callableStatement.setDouble(5, employee.getSalary());
            callableStatement.setString(6, employee.getPhone());
            callableStatement.setString(7, employee.getEmail());
            callableStatement.setInt(8, employee.getPositionId());
            callableStatement.setInt(9, employee.getEducationDegreeId());
            callableStatement.setInt(10, employee.getDivisionId());
            callableStatement.setString(11, employee.getUsername());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            mySQLConnection.printSQLException(e);

        }

    }

    public Employee selectEmployee(int id) {
        String query = "{CALL insert_employee_by_id(?)}";
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = mySQLConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, employee.getId());

            System.out.println(callableStatement);

            ResultSet rs = callableStatement.executeQuery();
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

            mySQLConnection.printSQLException(e);

        }

        return employee;
    }
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
//            preparedStatement.setString(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                String name = rs.getString("service_name");
//                int area = rs.getInt("service_area");
//                double cost = rs.getDouble("service_cost");
//                int maxPeople = rs.getInt("service_max_people");
//                int rentTypeId = rs.getInt("rent_type_id");
//                int serviceTypeId = rs.getInt("service_type_id");
//                String standardRoom = rs.getString("standard_room");
//                String description = rs.getString("description_other_convenience");
//                double poolArea = rs.getDouble("pool_area");
//                int numFloor = rs.getInt("number_of_floors");
//
//                service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, description,
//                        poolArea, numFloor);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return service;
//    }
}
