package com.college.lasalle.advancedoop.finalprj.dao;

import com.college.lasalle.advancedoop.finalprj.model.Address;
import com.college.lasalle.advancedoop.finalprj.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    private final String SQL_INSERT_USER = "INSERT INTO user"
            + "(userId, firstName, lastName, username, email, age, phoneNumber, streetNumber, streetName, city, stateProvince, country, postalCode)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String SQL_SELECT_USER_BY_USERNAME = "SELECT * FROM user WHERE username = ?";

    private final String SQL_SELECT_USER_BY_ID = "SELECT * FROM user WHERE userId = ?";

//    private final String SQL_UPDATE_USER = "UPDATE user"
//            + " SET firstName = ?, lastName = ?, username = ?, email = ?, age = ?, phoneNumber = ?, streetNumber = ?, streetName = ?, city = ?, stateProvince = ?, country = ?, postalCode = ?"
//            + " WHERE userId = ?";

    private final String SQL_UPDATE_USER = "UPDATE user"
            + " SET firstName = ?, lastName = ?, email = ?, age = ?, phoneNumber = ?, streetNumber = ?, streetName = ?, city = ?, stateProvince = ?, country = ?, postalCode = ?"
            + " WHERE userId = ? AND username = ?";

    private  final String SQL_DELETE_USER = "DELETE FROM user WHERE userId = ?";

    private final String SQL_SELECT_ALL_USERS = "SELECT * FROM user ORDER BY userId ASC";

//    public UserDao() throws SQLException, ClassNotFoundException {
//        connection = DBConnection.getConnection();
//    }

    public UserDao(){}

    public boolean insert(User user) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getConnection();
        connection = DBConnection.getConnection();

        if(searchUserByUsername(user.getUsername()) == null){
            user.setUserId(User.getIdGenerator());

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);

            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setInt(6, user.getAge());
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setInt(8, user.getAddress().getStreetNumber());
            preparedStatement.setString(9, user.getAddress().getStreetName());
            preparedStatement.setString(10, user.getAddress().getCity());
            preparedStatement.setString(11, user.getAddress().getStateProvince());
            preparedStatement.setString(12, user.getAddress().getCountry());
            preparedStatement.setString(13, user.getAddress().getPostalCode());

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " inserted");

            return true;
        }

        return false;

        //DBConnection.closeConnection();

    }

    public User searchUserByUsername(String username) throws SQLException, ClassNotFoundException {

        Address address;
        User user = null;

//        Connection connection = DBConnection.getConnection();
        connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_USERNAME);

        preparedStatement.setString(1, username);

        ResultSet rs = preparedStatement.executeQuery();

        if ( rs.next() ) {
            address = new Address();
            user = new User();

            user.setUserId(rs.getInt("userId"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
            user.setPhoneNumber(rs.getString("phoneNumber"));

            address.setStreetNumber(rs.getInt("streetNumber"));
            address.setStreetName(rs.getString("streetName"));
            address.setCity(rs.getString("city"));
            address.setStateProvince(rs.getString("stateProvince"));
            address.setCountry(rs.getString("country"));
            address.setPostalCode(rs.getString("postalCode"));

            user.setAddress(address);
        }

        return user;

        //DBConnection.closeConnection();

    }

    public User searchUserById(int userId) throws SQLException, ClassNotFoundException {

        Address address;
        User user = null;

//        Connection connection = DBConnection.getConnection();
        connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);

        preparedStatement.setInt(1, userId);

        ResultSet rs = preparedStatement.executeQuery();

        if ( rs.next() ) {
            address = new Address();
            user = new User();

            user.setUserId(rs.getInt("userId"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
            user.setPhoneNumber(rs.getString("phoneNumber"));

            address.setStreetNumber(rs.getInt("streetNumber"));
            address.setStreetName(rs.getString("streetName"));
            address.setCity(rs.getString("city"));
            address.setStateProvince(rs.getString("stateProvince"));
            address.setCountry(rs.getString("country"));
            address.setPostalCode(rs.getString("postalCode"));

            user.setAddress(address);
        }

        return user;

        //DBConnection.closeConnection();

    }

    public List<User> selectAll() throws SQLException, ClassNotFoundException {

        List<User> userList = new ArrayList<>();

        Address address;
        User user;

//        Connection connection = DBConnection.getConnection();
        connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS);

        ResultSet rs = preparedStatement.executeQuery();

        while ( rs.next() ) {
            address = new Address();
            user = new User();

            user.setUserId(rs.getInt("userId"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
            user.setPhoneNumber(rs.getString("phoneNumber"));

            address.setStreetNumber(rs.getInt("streetNumber"));
            address.setStreetName(rs.getString("streetName"));
            address.setCity(rs.getString("city"));
            address.setStateProvince(rs.getString("stateProvince"));
            address.setCountry(rs.getString("country"));
            address.setPostalCode(rs.getString("postalCode"));

            user.setAddress(address);

            userList.add(user);
        }

        return userList;

        //DBConnection.closeConnection();

    }

    public boolean update(User user) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getConnection();
        connection = DBConnection.getConnection();

        if(searchUserById(user.getUserId()) != null){

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);

//            preparedStatement.setString(1, user.getFirstName());
//            preparedStatement.setString(2, user.getLastName());
//            preparedStatement.setString(3, user.getUsername());
//            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setInt(5, user.getAge());
//            preparedStatement.setString(6, user.getPhoneNumber());
//            preparedStatement.setInt(7, user.getAddress().getStreetNumber());
//            preparedStatement.setString(8, user.getAddress().getStreetName());
//            preparedStatement.setString(9, user.getAddress().getCity());
//            preparedStatement.setString(10, user.getAddress().getStateProvince());
//            preparedStatement.setString(11, user.getAddress().getCountry());
//            preparedStatement.setString(12, user.getAddress().getPostalCode());
//            preparedStatement.setInt(13, user.getUserId());

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setInt(6, user.getAddress().getStreetNumber());
            preparedStatement.setString(7, user.getAddress().getStreetName());
            preparedStatement.setString(8, user.getAddress().getCity());
            preparedStatement.setString(9, user.getAddress().getStateProvince());
            preparedStatement.setString(10, user.getAddress().getCountry());
            preparedStatement.setString(11, user.getAddress().getPostalCode());
            preparedStatement.setInt(12, user.getUserId());
            preparedStatement.setString(13, user.getUsername());

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " updated");

            return true;
        }

        return false;

        //DBConnection.closeConnection();

    }

    public boolean delete(User user) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getConnection();
        connection = DBConnection.getConnection();

        //User user = searchUserByUsername(username);

        if(searchUserById(user.getUserId()) != null){

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);

            preparedStatement.setInt(1, user.getUserId());

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " deleted");

            return true;
        }

        return false;

        //DBConnection.closeConnection();

    }

}
