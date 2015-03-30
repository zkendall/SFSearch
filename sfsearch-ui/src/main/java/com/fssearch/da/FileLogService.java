package com.fssearch.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssearch.ui.FileDto;

public class FileLogService {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/fileLog.sqlite");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS log (path TEXT, name TEXT, size INTEGER, sizeBig INTEGER);");
        return connection;

    }

    public static List<FileDto> queryAllLog() throws SQLException {
        Connection connection = null;
        ArrayList<FileDto> result = new ArrayList<>();
        try {
            connection = getConnection();
            Statement statement = null;
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from log");
            while (rs.next()) {
                result.add(new FileDto(rs.getString("name"), rs.getString("path"), rs.getBigDecimal("size")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return result;
    }
}
