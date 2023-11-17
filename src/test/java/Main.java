import com.example.studentmanagement.dao.ILoaiDiemDAO;
import com.example.studentmanagement.dao.impl.LoaiDiemDAO;
import com.example.studentmanagement.jdbc.JdbcConnectionUtil;
import com.example.studentmanagement.jpa.JpaExample;
import com.example.studentmanagement.model.LoaiDiem;
import com.example.studentmanagement.service.impl.LoaiDiemService;
import com.example.studentmanagement.utils.Helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LoaiDiemDAO ldDAO = new LoaiDiemDAO();

        System.out.println(ldDAO.findMaxMaLoaiDiem());
    }
}
