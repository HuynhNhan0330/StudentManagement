package com.example.studentmanagement.api;

import com.example.studentmanagement.model.KhoaModel;
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
import java.util.Map;

@WebServlet(urlPatterns = { "/api-admin-khoa" })
public class KhoaAPI extends HttpServlet {

    private IKhoaService khoaService;

    public KhoaAPI() {
        khoaService = new KhoaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<KhoaModel> listKhoa = khoaService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        resp.setStatus(HttpServletResponse.SC_OK);
        mapper.writeValue(resp.getOutputStream(), listKhoa);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        KhoaModel khoaNew = HttpUtil.of(req.getReader()).toModel(KhoaModel.class);

        // create new data point in database
        Map<String, Object> results = khoaService.save(khoaNew);
        khoaNew = (KhoaModel) results.get("khoa");

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (khoaNew == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), khoaNew);
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
        KhoaModel khoaUpdate = HttpUtil.of(req.getReader()).toModel(KhoaModel.class);

        // update new data point in database
        khoaUpdate = khoaService.update(khoaUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), khoaUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        KhoaModel khoaDelete = HttpUtil.of(req.getReader()).toModel(KhoaModel.class);

        // delete target data point in database
        Boolean isDelete = khoaService.delete(khoaDelete.getMaKhoa());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (isDelete)
            resp.setStatus(HttpServletResponse.SC_OK);
        else
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
