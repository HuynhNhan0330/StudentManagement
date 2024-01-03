package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.model.GiaoVienModel;
import com.example.studentmanagement.model.KhoaModel;
import com.example.studentmanagement.service.IGiaoVienService;
import com.example.studentmanagement.service.impl.GiaoVienService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-giaovien" })
public class GiaoVienAPI extends HttpServlet {

    private IGiaoVienService giaoVienService;

    public GiaoVienAPI() {
        giaoVienService = new GiaoVienService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<GiaoVienDTO> listGiaoVien = giaoVienService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listGiaoVien);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        GiaoVienDTO giaoVienNew = HttpUtil.of(req.getReader()).toModel(GiaoVienDTO.class);

        // create new data point in database
        giaoVienNew = giaoVienService.save(giaoVienNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), giaoVienNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        GiaoVienDTO giaoVienUpdate = HttpUtil.of(req.getReader()).toModel(GiaoVienDTO.class);

        // update new data point in database
        giaoVienUpdate = giaoVienService.update(giaoVienUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), giaoVienUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        GiaoVienModel giaoVienDelete = HttpUtil.of(req.getReader()).toModel(GiaoVienModel.class);

        // delete target data point in database
        giaoVienService.delete(giaoVienDelete.getMaGV());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
