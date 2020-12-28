package reponsive;

import connection.MySQLconnection;
import model.Contract;
import model.ContractDetail;
import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerReponsive {
    MySQLconnection mySQLconnection = new MySQLconnection();
    private static final String SELECT_ALL_CUSTOMER = "select * from customer join customer_type " +
            "on customer.customer_type_id = customer_type.customer_type_id";
    private static final String SELECT_ALL_CUSTOMER_BY_ID = "select * from customer join customer_type " +
            "on customer.customer_type_id = customer_type.customer_type_id where customer_id = ?";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_id, customer_type_id, customer_name, " +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?, customer_name= ?," +
            " customer_birthday = ?, customer_gender = ?, customer_id_card= ?, customer_phone= ?, customer_email= ?," +
            "customer_address= ? where customer_id = ?";
    private static final String SEARCH_CUSTOMER_BY_NAME = "SELECT * FROM customer join customer_type " +
            "on customer.customer_type_id = customer_type.customer_type_id WHERE customer_name LIKE '%' ? '%'";
    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type";
    private static final String SELECT_ALL_CUSTOMER_TYPE_BY_ID = "select * from customer_type where customer_type_id = ? ";


    public List<Customer> selectAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("customer_id");
                CustomerType typeId = new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date date = null;
                try {
                    date = dt.parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
                String birthday1 = dt1.format(date);
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");

                customers.add(new Customer(id, typeId, name, birthday1, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return customers;
    }

    public Customer selectCustomer(String id) {
        Customer customer = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CustomerType typeId = new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return customer;
    }

    public void insertCustomer(Customer customer) throws SQLException {
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setInt(2, customer.getTypeId().getId());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getBirthday());
            preparedStatement.setString(5, customer.getGender());
            preparedStatement.setString(6, customer.getIdCard());
            preparedStatement.setString(7, customer.getPhone());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
    }

    public boolean deleteCustomer(String id){
        boolean rowDeleted = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
                statement.setString(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateCustomer(Customer customer) {
        boolean rowUpdated = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
                preparedStatement.setInt(1, customer.getTypeId().getId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getBirthday());
                preparedStatement.setString(4, customer.getGender());
                preparedStatement.setString(5, customer.getIdCard());
                preparedStatement.setString(6, customer.getPhone());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
                preparedStatement.setString(9, customer.getId());
    
                rowUpdated = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public List<Customer> searchCustomerByName(String name_search){
        List<Customer> customers = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM customer WHERE customer_name LIKE '%"+ name_search + "%'");
                    connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);
        preparedStatement.setString(1, name_search);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("customer_id");
                CustomerType typeId = new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name"));
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<CustomerType> selectAllCustomerType(){
        List<CustomerType> customerTypes = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");

                customerTypes.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return customerTypes;
    }

    public CustomerType selectCustomerType(int id) {
        CustomerType customerTypes = null;
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("customer_type_name");
                customerTypes = new CustomerType(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return customerTypes;
    }
}
