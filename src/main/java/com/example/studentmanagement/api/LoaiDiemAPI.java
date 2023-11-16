package com.example.studentmanagement.api;

import com.example.studentmanagement.jdbc.JdbcConnectionUtil;
import com.example.studentmanagement.jpa.JpaExample;
import com.example.studentmanagement.model.LoaiDiem;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/LoaiDiemAPI" })
public class LoaiDiemAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<LoaiDiem> LoaiDiemList = new ArrayList<>();

        try {
            JdbcConnectionUtil jdbcConnectionUtil = new JdbcConnectionUtil();
            Connection connection = jdbcConnectionUtil.getConnection();

            JpaExample jpaExample = new JpaExample();
            List<LoaiDiem> jpaLoaiDiemList = jpaExample.getLoaiDiemList();
            LoaiDiemList.addAll(jpaLoaiDiemList);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Lỗi sql");
//            e.printStackTrace();
        }

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), LoaiDiemList);

        return;
    }
}
