package db;

import java.sql.*;
import java.util.ResourceBundle;

public class DBHelper {

    private static final String BUNDLE_NAME = "database";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    public static final String DRIVER = "DRIVER";
    public static final String URL_DATABASE = "URL_DATABASE";
    public static final String LOGIN = "LOGIN";
    public static final String PASSWORD = "PASSWORD";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName((String) resourceBundle.getObject(DRIVER));
            connection = DriverManager.getConnection(resourceBundle.getString(URL_DATABASE), resourceBundle.getString(LOGIN), resourceBundle.getString(PASSWORD));
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
