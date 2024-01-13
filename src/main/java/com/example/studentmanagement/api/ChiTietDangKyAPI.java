package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.DiemDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.model.DiemModel;
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
import java.util.Map;

@WebServlet(urlPatterns = { "/api-admin-chitietdangky", "/api-admin-chitietdangky/sv/*" })
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

        ObjectMapper mapper = new ObjectMapper();
        String requestURI = req.getRequestURI();

        if (requestURI.equals("/api-admin-chitietdangky")) {
            // binding json to string-json, mapping data with model.class
            ChiTietDangKyModel chiTietDangKyNew = HttpUtil.of(req.getReader()).toModel(ChiTietDangKyModel.class);

            // create new data point in database
//            chiTietDangKyNew = chiTietDangKyService.save(chiTietDangKyNew);

            // convert model to json for response
            mapper.writeValue(resp.getOutputStream(), chiTietDangKyNew);
        }
        else if (requestURI.startsWith("/api-admin-chitietdangky/sv/"))
        {
            LopHocDTO lopHoc = HttpUtil.of(req.getReader()).toModel(LopHocDTO.class);

            String maSV = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            Map<String, Object> results = chiTietDangKyService.save(maSV, lopHoc);
            DiemDTO diem =  (DiemDTO) results.get("ctdk");

            if (diem == null) {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                mapper.writeValue(resp.getOutputStream(), results.get("thongBao"));
            }
            else {
                resp.setStatus(HttpServletResponse.SC_OK);
                mapper.writeValue(resp.getOutputStream(), diem);
            }

            resp.setStatus(HttpServletResponse.SC_OK);
//            mapper.writeValue(resp.getOutputStream(), listDiem);
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

        ObjectMapper mapper = new ObjectMapper();
        String requestURI = req.getRequestURI();

        if (requestURI.startsWith("/api-admin-chitietdangky/sv/")) {
            String maSV = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            // binding data json to string-json, mapping data with model class
            LopHocDTO lopHocDelete = HttpUtil.of(req.getReader()).toModel(LopHocDTO.class);

            // delete target data point in database
            chiTietDangKyService.delete(maSV, lopHocDelete);

            mapper.writeValue(resp.getOutputStream(), "{}");
        }

        // convert model to json for response
        return;
    }
}
