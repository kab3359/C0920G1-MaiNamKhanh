package dao;

import connection.MySQLConnection;
import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDao {
    MySQLConnection mySQLConnection = new MySQLConnection();
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer_type" + "  (customer_type_id, customer_type_name) " +
            " VALUES " + " (?, ?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer_type where id =?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer_type";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer_type where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer_type set customer_type_id = ?, customer_type_name= ?" +
            "where id = ?";

    public CustomerTypeDao() {
    }


    public void insertCustomerType(CustomerType customerType) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customerType.getTypeId());
            preparedStatement.setString(2, customerType.getTypeName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public CustomerType selectCustomerType(int id) {
        CustomerType customerType = null;
        // Step 1: Establishing a Connection
        try (Connection connection = mySQLConnection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("customer_type_name");

                customerType = new CustomerType(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerType;
    }

    public List<CustomerType> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<CustomerType> customerType = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = mySQLConnection.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");


                customerType.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerType;
    }

    public boolean deleteCustomerType(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateCustomerType(CustomerType customerType) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            preparedStatement.setInt(1, customerType.getTypeId());
            preparedStatement.setString(2, customerType.getTypeName());

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
