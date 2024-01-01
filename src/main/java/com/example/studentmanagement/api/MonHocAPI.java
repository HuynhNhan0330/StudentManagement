package com.example.studentmanagement.api;

import com.example.studentmanagement.model.GiaoVienModel;
import com.example.studentmanagement.model.MonHocModel;
import com.example.studentmanagement.service.IGiaoVienService;
import com.example.studentmanagement.service.IMonHocService;
import com.example.studentmanagement.service.impl.GiaoVienService;
import com.example.studentmanagement.service.impl.MonHocService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = { "/api-admin-monhoc" })
public class MonHocAPI extends HttpServlet {

    private IMonHocService monHocService;

    public MonHocAPI() {
        monHocService = new MonHocService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<MonHocModel> listMonHoc = monHocService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        resp.setStatus(HttpServletResponse.SC_OK);
        mapper.writeValue(resp.getOutputStream(), listMonHoc);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        MonHocModel monHocNew = HttpUtil.of(req.getReader()).toModel(MonHocModel.class);

        // create new data point in database
        Map<String, Object> results = monHocService.save(monHocNew);

        monHocNew = (MonHocModel) results.get("monHoc");

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (monHocNew == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), monHocNew);
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
        MonHocModel monHocUpdate = HttpUtil.of(req.getReader()).toModel(MonHocModel.class);

        // update new data point in database
        monHocUpdate = monHocService.update(monHocUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), monHocUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        MonHocModel monHocDelete = HttpUtil.of(req.getReader()).toModel(MonHocModel.class);

        // delete target data point in database
        Boolean isDelete = monHocService.delete(monHocDelete.getMaMH());

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
