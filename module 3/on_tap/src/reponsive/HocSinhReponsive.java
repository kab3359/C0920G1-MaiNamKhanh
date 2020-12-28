package reponsive;

import connection.MySQLconnection;
import model.Customer;
import model.CustomerType;
import model.HocSinh;
import model.LopHoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class HocSinhReponsive {
    MySQLconnection mySQLconnection = new MySQLconnection();
    private static final String SELECT_ALL_STUDENT = "select * from student join class " +
            "on student.class_id = class.class_id";
    private static final String SELECT_ALL_STUDENT_BY_ID = "select * from student join class " +
            "on student.class_id = class.class_id where student_id = ?";
    private static final String INSERT_STUDENT_SQL = "INSERT INTO student" + "  (student_id, student_name, class_id, " +
            "birthday, gender, address)" +
            " VALUES " + " (?, ?, ?, ?, ?, ?);";
    private static final String DELETE_STUDENT_SQL = "delete from student where student_id = ?;";
    private static final String UPDATE_STUDENT_SQL = "update student set student_id = ?, student_name= ?," +
            " class_id = ?, birthday = ?, gender= ?, address= ? where student_id = ?";
    private static final String SEARCH_STUDENT_BY_NAME = "SELECT * FROM student join class " +
            "on student.class_id = class.class_id WHERE student_name LIKE '%' ? '%'";
    private static final String SELECT_ALL_CLASS = "select * from class";
    private static final String SELECT_ALL_CLASS_BY_ID = "select * from class where class_id = ? ";


    public List<HocSinh> selectAllStudent(){
        List<HocSinh> hocSinhs = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                LopHoc lopHoc = new LopHoc(rs.getInt("class_id"), rs.getString("class_name"),
                        rs.getInt("class_num_room"), rs.getString("class_name_school"));
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String address = rs.getString("address");

                hocSinhs.add(new HocSinh(id, name, lopHoc, birthday, gender, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return hocSinhs;
    }

    public HocSinh selectStudent(int id) {
        HocSinh hocSinh = null;
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("student_name");
                LopHoc lopHoc = new LopHoc(rs.getInt("class_id"), rs.getString("class_name"),
                        rs.getInt("class_num_room"), rs.getString("class_name_school"));
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                hocSinh = new HocSinh(id, name, lopHoc, birthday, gender, address);
            }
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
        return hocSinh;
    }

    public void insertStudent(HocSinh hocSinh) throws SQLException {
        try (Connection connection = mySQLconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setInt(1, hocSinh.getId());
            preparedStatement.setString(2, hocSinh.getName());
            preparedStatement.setInt(3, hocSinh.getLopHoc().getId());
            preparedStatement.setString(4, hocSinh.getNgaySinh());
            preparedStatement.setString(5, hocSinh.getGioiTinh());
            preparedStatement.setString(6, hocSinh.getDiaChi());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            mySQLconnection.printSQLException(e);
        }
    }

    public boolean deleteStudent(int id){
        boolean rowDeleted = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateStudent(HocSinh hocSinh) {
        boolean rowUpdated = false;
        try {
            try (Connection connection = mySQLconnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
                preparedStatement.setInt(1, hocSinh.getId());
                preparedStatement.setString(2, hocSinh.getName());
                preparedStatement.setInt(3, hocSinh.getLopHoc().getId());
                preparedStatement.setString(4, hocSinh.getNgaySinh());
                preparedStatement.setString(5, hocSinh.getGioiTinh());
                preparedStatement.setString(6, hocSinh.getDiaChi());
                preparedStatement.setInt(7, hocSinh.getId());
                rowUpdated = preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public List<HocSinh> searchStudentByName(String name_search){
        List<HocSinh> hocSinhs = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement =
//                    connection.prepareStatement("SELECT * FROM customer WHERE customer_name LIKE '%"+ name_search + "%'");
                    connection.prepareStatement(SEARCH_STUDENT_BY_NAME);
            preparedStatement.setString(1, name_search);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                LopHoc lopHoc = new LopHoc(rs.getInt("class_id"), rs.getString("class_name"),
                        rs.getInt("class_num_room"), rs.getString("class_name_school"));
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                hocSinhs.add(new HocSinh(id, name, lopHoc, birthday, gender, address)) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinhs;
    }

    public List<LopHoc> selectAllClass(){
        List<LopHoc> lopHocs = new ArrayList<>();
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("class_id");
                String name = rs.getString("class_name");
                int room = rs.getInt("class_num_room");
                String nameSchool = rs.getString("class_name_school");

                lopHocs.add(new LopHoc(id, name, room, nameSchool));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return lopHocs;
    }

    public LopHoc selectClass(int id) {
        LopHoc lopHoc = null;
        Connection connection = mySQLconnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("class_name");
                int room = rs.getInt("class_num_room");
                String nameSchool = rs.getString("class_name_school");

                lopHoc = new LopHoc(id, name, room, nameSchool);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return lopHoc;
    }
}
