package com.example.studentmanagement.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {
    String url = "jdbc:sqlite:C:/Program Files/SQLiteStudio/StudentManagementX";

    public Connection getConnection() {
        //Tạo đối tượng Connection
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
//                connection.close();
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối đến cơ sở dữ liệu.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver JDBC.");
            e.printStackTrace();
        }

        return connection;
    }
}