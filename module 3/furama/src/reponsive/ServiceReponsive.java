package reponsive;

import connection.MySQLconnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceReponsive {
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";
    private static final String SELECT_ALL_RENT_TYPE_BY_ID = "select * from rent_type where rent_type_id = ?";
    private static final String SELECT_ALL_TYPE_SERVICE = "select * from service_type";
    private static final String SELECT_ALL_TYPE_SERVICE_BY_ID = "select * from service_type where service_type_id = ?";
    private static final String SELECT_ALL_TYPE_BY_ID = "select * from service join rent_type " +
            "on rent_type.rent_type_id = service.rent_type_id join service_type " +
            "on service_type.service_type_id = service.service_type_id where service_id = ?";
    MySQLconnection mySQLconnection = new MySQLconnection();
    private static final String SELECT_ALL_SERVICE = "select * from service join rent_type " +
            "on rent_type.rent_type_id = service.rent_type_id join service_type " +
            "on service_type.service_type_id = service.service_type_id";
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" + "  (service_id, service_name, service_area, " +
            "service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience," +
            "pool_area, number_of_floors)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_SERVICE_SQL = "delete from service where service_id = ?;";
    private static final String UPDATE_SERVICE_SQL = "update service set service_id = ?, service_name= ?," +
            " service_area = ?, service_cost = ?, service_max_people= ?, rent_type_id= ?, service_type_id= ?," +
            "standard_room= ?, description_other_convenience = ?, pool_area = ?, number_of_floors = ? where service_id = ?";
    private static final String SELECT_SERVICE_BY_ID = "SELECT * FROM service WHERE service_id = ?";
    private static final String SEARCH_SERVICE_BY_NAME = "select * from service join rent_type " +
            "on rent_type.rent_type_id = service.rent_type_id join service_type " +
            "on service_type.service_type_id = service.service_type_id WHERE service_name LIKE '%' ? '%'";


    public List<Service> selectAllService(){
        List<Service> services = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                RentType rentTypeId = new RentType(rs.getInt("rent_type_id"), rs.getString("rent_type_name"),
                        rs.getDouble("rent_type_cost")) ;
                ServiceType serviceTypeId = new ServiceType(rs.getInt("service_type_id"),
                        rs.getString("service_type_name"));
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                int poolAres = rs.getInt("pool_area");
                int numFloor = rs.getInt("number_of_floors");

                services.add(new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom,
                        description, poolAres, numFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return services;
    }

    public Service selectService(String id) {
        Service service = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_BY_ID);) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                RentType rentTypeId = new RentType(rs.getInt("rent_type_id"), rs.getString("rent_type_name"),
                        rs.getDouble("rent_type_cost")) ;
                ServiceType serviceTypeId = new ServiceType(rs.getInt("service_type_id"),
                        rs.getString("service_type_name"));
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                int poolAres = rs.getInt("pool_area");
                int numFloor = rs.getInt("number_of_floors");
                service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom,
                        description, poolAres, numFloor);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return service;
    }

    public void insertService(Service service) throws SQLException {
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxPeople());
            preparedStatement.setInt(6, service.getRentTypeId().getId());
            preparedStatement.setInt(7, service.getServiceTypeId().getId());
            preparedStatement.setString(8, service.getStandardRoom());
            preparedStatement.setString(9, service.getDescription());
            preparedStatement.setInt(10, service.getPoolArea());
            preparedStatement.setInt(11, service.getNumFloor());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
    }

    public boolean deleteService(String id){
        boolean rowDeleted = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_SQL);) {
                statement.setString(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateService(Service service) {
        boolean rowUpdated = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE_SQL);) {
                preparedStatement.setString(1, service.getId());
                preparedStatement.setString(2, service.getName());
                preparedStatement.setInt(3, service.getArea());
                preparedStatement.setDouble(4, service.getCost());
                preparedStatement.setInt(5, service.getMaxPeople());
                preparedStatement.setInt(6, service.getRentTypeId().getId());
                preparedStatement.setInt(7, service.getServiceTypeId().getId());
                preparedStatement.setString(8, service.getStandardRoom());
                preparedStatement.setString(9, service.getDescription());
                preparedStatement.setInt(10, service.getPoolArea());
                preparedStatement.setInt(11, service.getNumFloor());
                preparedStatement.setString(12, service.getId());

                rowUpdated = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public List<Service> searchServiceByName(String name_search){
        List<Service> services = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SEARCH_SERVICE_BY_NAME);
            preparedStatement.setString(1, name_search);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                RentType rentTypeId = new RentType(rs.getInt("rent_type_id"), rs.getString("rent_type_name"),
                        rs.getDouble("rent_type_cost")) ;
                ServiceType serviceTypeId = new ServiceType(rs.getInt("service_type_id"),
                        rs.getString("service_type_name"));
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                int poolAres = rs.getInt("pool_area");
                int numFloor = rs.getInt("number_of_floors");
                services.add(new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom,
                        description, poolAres, numFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public List<RentType> selectAllRentType(){
        List<RentType> rentTypes = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("rent_type_id");
                String name = rs.getString("rent_type_name");
                double cost = rs.getDouble("rent_type_cost");
                rentTypes.add(new RentType(id, name, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return rentTypes;
    }

    public RentType selectRentTypeById(int id) {
        RentType rentType = null;
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("rent_type_name");
                double cost = rs.getDouble("rent_type_cost");
                rentType = new RentType(id, name, cost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return rentType;
    }

    public List<ServiceType> selectAllServiceType(){
        List<ServiceType> serviceTypes = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_SERVICE);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("service_type_id");
                String name = rs.getString("service_type_name");
                serviceTypes.add(new ServiceType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return serviceTypes;
    }

    public ServiceType selectServiceTypeById(int id) {
        ServiceType serviceType = null;
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TYPE_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("service_type_name");
                serviceType = new ServiceType(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return serviceType;
    }
}
