package com.example.studentmanagement.api;

import com.example.studentmanagement.model.LopHocModel;
import com.example.studentmanagement.service.ILopHocService;
import com.example.studentmanagement.service.impl.LopHocService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-lophoc" })
public class LopHocAPI extends HttpServlet {

    private ILopHocService lopHocService;

    public LopHocAPI() {
        lopHocService = new LopHocService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<LopHocModel> listLopHoc = lopHocService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), listLopHoc);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        LopHocModel lopHocNew = HttpUtil.of(req.getReader()).toModel(LopHocModel.class);

        // create new data point in database
        lopHocNew = lopHocService.save(lopHocNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), lopHocNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        LopHocModel lopHocUpdate = HttpUtil.of(req.getReader()).toModel(LopHocModel.class);

        // update new data point in database
        lopHocUpdate = lopHocService.update(lopHocUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), lopHocUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        LopHocModel lopHocDelete = HttpUtil.of(req.getReader()).toModel(LopHocModel.class);

        // delete target data point in database
        lopHocService.delete(lopHocDelete.getMaLop());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
