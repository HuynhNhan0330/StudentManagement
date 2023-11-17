package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.Khoa;
import com.example.studentmanagement.model.Nganh;
import com.example.studentmanagement.service.IKhoaService;
import com.example.studentmanagement.service.impl.KhoaService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-nganh" })
public class NganhAPI extends HttpServlet {

//    private IKhoaService khoaService;

//    public KhoaAPI() {
//        khoaService = new KhoaService();
//    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // format font for request
//        req.setCharacterEncoding("UTF-8");
//
//        // format content type for client
//        resp.setContentType("application/json");
//
//        // get list object
//        List<Khoa> listKhoa = khoaService.findAll();
//
//        // convert list model to json for response
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(resp.getOutputStream(), listKhoa);
//        return;
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        NganhDTO nganhDTONew = HttpUtil.of(req.getReader()).toModel(NganhDTO.class);

        // create new data point in database
//        khoaNew = khoaService.save(khoaNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(resp.getOutputStream(), khoaNew);
        return;
    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // format font for request
//        req.setCharacterEncoding("UTF-8");
//
//        // format content type for client
//        resp.setContentType("application/json");
//
//        // binding json to string-json, mapping data with model.class
//        Khoa khoaUpdate = HttpUtil.of(req.getReader()).toModel(Khoa.class);
//
//        // update new data point in database
//        khoaUpdate = khoaService.update(khoaUpdate);
//
//        // convert model to json for response
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(resp.getOutputStream(), khoaUpdate);
//        return;
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        // format font for request
//        req.setCharacterEncoding("UTF-8");
//
//        // format content for client
//        resp.setContentType("application/json");
//
//        // binding data json to string-json, mapping data with model class
//        Khoa khoaDelete = HttpUtil.of(req.getReader()).toModel(Khoa.class);
//
//        // delete target data point in database
//        khoaService.delete(khoaDelete.getMaKhoa());
//
//        // convert model to json for response
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(resp.getOutputStream(), "{}");
//        return;
//    }
}
