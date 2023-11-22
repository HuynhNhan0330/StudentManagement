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
        List<NganhModel> listNganh = nganhService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
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
        NganhModel nganhNew = nganhService.save(nganhModelNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), nganhNew);
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
        NganhModel nganhUpdate = nganhService.update(nganhModelUpdate);

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
        NganhModel nganhDelete = HttpUtil.of(req.getReader()).toModel(NganhModel.class);

        // delete target data point in database
        nganhService.delete(nganhDelete.getMaNganh());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
