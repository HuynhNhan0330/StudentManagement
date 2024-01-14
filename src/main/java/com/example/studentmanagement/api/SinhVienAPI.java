package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.model.SinhVienModel;
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
import java.util.Map;

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
        List<SinhVienDTO> listSinhVien = sinhVienService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        resp.setStatus(HttpServletResponse.SC_OK);
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
        SinhVienDTO sinhVienNew = HttpUtil.of(req.getReader()).toModel(SinhVienDTO.class);

        // create new data point in database
        Map<String, Object> results = sinhVienService.save(sinhVienNew);

        sinhVienNew = (SinhVienDTO) results.get("sinhVien");

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (sinhVienNew == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), sinhVienNew);
        }

        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        SinhVienDTO sinhVienModelUpdate = HttpUtil.of(req.getReader()).toModel(SinhVienDTO.class);

        // update new data point in database
        Map<String, Object> results = sinhVienService.update(sinhVienModelUpdate);

        sinhVienModelUpdate = (SinhVienDTO) results.get("sinhVien");

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (sinhVienModelUpdate == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), sinhVienModelUpdate);
        }
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
        Boolean isDelete = sinhVienService.delete(sinhVienDelete);

        if (isDelete)
            resp.setStatus(HttpServletResponse.SC_OK);
        else
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
