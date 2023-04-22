package com.college.lasalle.advancedoop.finalprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    //private static final String dbName = "final_prj_db";
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/final_prj_db?autoReconnect=true&useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "";

    private DBConnection(){}

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if(connection != null) {
                connection.close();
        }
        connection = null;
    }
}
