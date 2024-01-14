package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.LopHocDTO;
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
import java.util.Map;

@WebServlet(urlPatterns = { "/api-admin-lophoc", "/api-admin-lophoc/*", "/api-admin-lophoc/gv/*" })
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

        ObjectMapper mapper = new ObjectMapper();

        String requestURI = req.getRequestURI();
        if (requestURI.equals("/api-admin-lophoc")) {
            // get list object
            List<LopHocDTO> listLopHoc = lopHocService.findAll();

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listLopHoc);
        } else if (requestURI.startsWith("/api-admin-lophoc/gv/")){
            String maGV = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            List<LopHocDTO> listLopHoc = lopHocService.findByLecturer(maGV);

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listLopHoc);
        } else {
            String maLop = requestURI.substring(requestURI.lastIndexOf("/") + 1);
            LopHocDTO lopHocDTO = lopHocService.findOne(maLop);

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), lopHocDTO);
        }

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
        Map<String, Object>  results = lopHocService.save(lopHocNew);
        LopHocDTO lopHocDTO = (LopHocDTO) results.get("lopHoc");

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();

        if (lopHocDTO == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), lopHocDTO);
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
        LopHocModel lopHocUpdate = HttpUtil.of(req.getReader()).toModel(LopHocModel.class);

        // update new data point in database
//        lopHocUpdate = lopHocService.update(lopHocUpdate);

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
