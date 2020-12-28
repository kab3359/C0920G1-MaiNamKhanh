package dao;

import connection.MySQLConnection;
import model.Customer;
import model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
    MySQLConnection mySQLConnection = new MySQLConnection();

    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" + "  (service_id, service_name, service_area, " +
            "service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience," +
            "pool_area, number_of_floors)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id =?";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String DELETE_SERVICE_SQL = "delete from service where service_id = ?;";
    private static final String UPDATE_SERVICE_SQL = "update service set service_name = ?, service_area= ?," +
            " service_cost = ?, service_max_people = ?, rent_type_id= ?, service_type_id= ?, standard_room= ?," +
            "description_other_convenience= ?, pool_area = ?, number_of_floors = ? where customer_id = ?";
    private static final String COUNT_CUSTOMER = "SELECT count(customer_id) as count_customer FROM customer";


    public ServiceDao() {
    }


    public void insertService(Service service) throws SQLException {

        String query = "{CALL insert_service(?,?,?,?,?,?,?,?,?,?,?)}";

        // try-with-resource statement will auto close the connection.

        try (Connection connection = mySQLConnection.getConnection();

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, service.getId());
            callableStatement.setString(2, service.getName());
            callableStatement.setInt(3, service.getArea());
            callableStatement.setDouble(4, service.getCost());
            callableStatement.setInt(5, service.getMaxPeople());
            callableStatement.setInt(6, service.getRentTypeId());
            callableStatement.setInt(7, service.getServiceTypeId());
            callableStatement.setString(8, service.getStandardRoom());
            callableStatement.setString(9, service.getDescription());
            callableStatement.setDouble(10, service.getPoolArea());
            callableStatement.setInt(11, service.getNumFloor());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);

        }

    }

    public Service selectService(String id) {
        Service service = null;
        // Step 1: Establishing a Connection
        try (Connection connection = mySQLConnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numFloor = rs.getInt("number_of_floors");

                service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, description,
                        poolArea, numFloor);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
    }

    public List<Service> selectAllService() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Service> services = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = mySQLConnection.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String id = rs.getString("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numFloor = rs.getInt("number_of_floors");

                services.add(new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom,
                        description, poolArea, numFloor));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return services;
    }

    public  int countCustomer(){
        int countCustomer = 0;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(COUNT_CUSTOMER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                countCustomer = rs.getInt("count_customer");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return countCustomer;
    }

    public boolean deleteService(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_SQL);) {
            preparedStatement.setString(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxPeople());
            preparedStatement.setInt(6, service.getRentTypeId());
            preparedStatement.setInt(7, service.getServiceTypeId());
            preparedStatement.setString(8, service.getStandardRoom());
            preparedStatement.setString(9, service.getDescription());
            preparedStatement.setDouble(10, service.getPoolArea());
            preparedStatement.setInt(11, service.getNumFloor());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
