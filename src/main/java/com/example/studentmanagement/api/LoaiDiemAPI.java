package com.example.studentmanagement.api;

import com.example.studentmanagement.jdbc.JdbcConnectionUtil;
import com.example.studentmanagement.jpa.JpaExample;
import com.example.studentmanagement.model.LoaiDiem;
import com.example.studentmanagement.service.ILoaiDiemService;
import com.example.studentmanagement.service.impl.LoaiDiemService;
import com.example.studentmanagement.utils.HttpUtil;
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

@WebServlet(urlPatterns = { "/api-admin-loaidiem" })
public class LoaiDiemAPI extends HttpServlet {

    private ILoaiDiemService loaiDiemService;

    public LoaiDiemAPI() {
        loaiDiemService = new LoaiDiemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<LoaiDiem> listLoaiDiem = loaiDiemService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listLoaiDiem);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        LoaiDiem loaiDiemNew = HttpUtil.of(req.getReader()).toModel(LoaiDiem.class);

        // create new data point in database
        loaiDiemNew = loaiDiemService.save(loaiDiemNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), loaiDiemNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        LoaiDiem loaidiemUpdate = HttpUtil.of(req.getReader()).toModel(LoaiDiem.class);

        // update new data point in database
        loaidiemUpdate = loaiDiemService.update(loaidiemUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), loaidiemUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        LoaiDiem loaiDiemDelete = HttpUtil.of(req.getReader()).toModel(LoaiDiem.class);

        // delete target data point in database
        loaiDiemService.delete(loaiDiemDelete.getMaLoaiDiem());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
