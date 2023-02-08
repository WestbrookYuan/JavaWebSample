package com.yty.javaweb.oa.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private static ResourceBundle rb = ResourceBundle.getBundle("resources.jdbc");
    private static String driver = rb.getString("driver");
    private static String url = rb.getString("url");
    private static String user = rb.getString("user");
    private static String password = rb.getString("password");
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    @return connection
    * */
    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet rs) throws SQLException {
        if (rs != null){
            rs.close();
        }

        if (statement != null){
            statement.close();
        }

        if (connection != null){
            connection.close();
        }

    }
}
