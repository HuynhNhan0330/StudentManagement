package com.example.studentmanagement.api;

import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.service.IChiTietDangKyService;
import com.example.studentmanagement.service.impl.ChiTietDangKyService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-chitietdangky" })
public class ChiTietDangKyAPI extends HttpServlet {

    private IChiTietDangKyService chiTietDangKyService;

    public ChiTietDangKyAPI() {
        chiTietDangKyService = new ChiTietDangKyService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<ChiTietDangKyModel> listChiTietDangKy = chiTietDangKyService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listChiTietDangKy);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        ChiTietDangKyModel chiTietDangKyNew = HttpUtil.of(req.getReader()).toModel(ChiTietDangKyModel.class);

        // create new data point in database
        chiTietDangKyNew = chiTietDangKyService.save(chiTietDangKyNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), chiTietDangKyNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        ChiTietDangKyModel chiTietDangKyUpdate = HttpUtil.of(req.getReader()).toModel(ChiTietDangKyModel.class);

        // update new data point in database
        chiTietDangKyUpdate = chiTietDangKyService.update(chiTietDangKyUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), chiTietDangKyUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        ChiTietDangKyModel chiTietDangKyDelete = HttpUtil.of(req.getReader()).toModel(ChiTietDangKyModel.class);

        // delete target data point in database
        chiTietDangKyService.delete(chiTietDangKyDelete.getMaSV(), chiTietDangKyDelete.getMaLop());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
