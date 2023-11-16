import com.example.studentmanagement.jdbc.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        JdbcConnectionUtil jdbcConnectionUtil = new JdbcConnectionUtil();
        try {
            Connection connection = jdbcConnectionUtil.getConnection();

            // Tạo đối tượng Statement để thực hiện các truy vấn SQL
            Statement statement = connection.createStatement();

            // Thực hiện truy vấn SELECT để lấy dữ liệu từ bảng LOAIDIEM
            String query = "SELECT * FROM LOAIDIEM";
            ResultSet resultSet = statement.executeQuery(query);

            // In dữ liệu từ ResultSet
            while (resultSet.next()) {
                // Đọc giá trị từ các cột trong ResultSet
                String id = resultSet.getString("MaLoaiDiem");
                String name = resultSet.getString("TenLoaiDiem");
                // In dữ liệu
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
