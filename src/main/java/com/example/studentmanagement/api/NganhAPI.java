package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.model.NganhModel;
import com.example.studentmanagement.service.INganhService;
import com.example.studentmanagement.service.impl.NganhService;
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

@WebServlet(urlPatterns = { "/api-admin-nganh" })
public class NganhAPI extends HttpServlet {

    private INganhService nganhService;

    public NganhAPI() {
        nganhService = new NganhService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<NganhDTO> listNganh = nganhService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        resp.setStatus(HttpServletResponse.SC_OK);
        mapper.writeValue(resp.getOutputStream(), listNganh);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        NganhModel nganhModelNew = HttpUtil.of(req.getReader()).toModel(NganhModel.class);

        // create new data point in database
        Map<String, Object> results = nganhService.save(nganhModelNew);
        NganhDTO nganhNew = (NganhDTO) results.get("nganh");

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (nganhNew == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), nganhNew);
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
        NganhModel nganhModelUpdate = HttpUtil.of(req.getReader()).toModel(NganhModel.class);

        // update new data point in database
        NganhDTO nganhUpdate = nganhService.update(nganhModelUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), nganhUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        NganhDTO nganhDelete = HttpUtil.of(req.getReader()).toModel(NganhDTO.class);

        // delete target data point in database
        Boolean isDelete = nganhService.delete(nganhDelete.getMaNganh());

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
