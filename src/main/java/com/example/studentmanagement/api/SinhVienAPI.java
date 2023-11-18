package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVien;
import com.example.studentmanagement.service.ISinhVienService;
import com.example.studentmanagement.service.impl.SinhVienService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-sinhvien" })
public class SinhVienAPI extends HttpServlet {

    private ISinhVienService sinhVienService;

    public SinhVienAPI() {
        sinhVienService = new SinhVienService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<SinhVien> listSinhVien = sinhVienService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listSinhVien);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        SinhVienDTO sinhVienDTONew = HttpUtil.of(req.getReader()).toModel(SinhVienDTO.class);

        // create new data point in database
        SinhVien sinhVienNew = sinhVienService.save(sinhVienDTONew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), sinhVienNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        SinhVienDTO sinhVienDTOUpdate = HttpUtil.of(req.getReader()).toModel(SinhVienDTO.class);

        // update new data point in database
        SinhVien sinhVienUpdate = sinhVienService.update(sinhVienDTOUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), sinhVienUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        SinhVienDTO sinhVienDelete = HttpUtil.of(req.getReader()).toModel(SinhVienDTO.class);

        // delete target data point in database
        sinhVienService.delete(sinhVienDelete.getMaSV());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
