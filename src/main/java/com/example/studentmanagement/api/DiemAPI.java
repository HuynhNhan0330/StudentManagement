package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.DiemDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.model.DiemModel;
import com.example.studentmanagement.service.IDiemService;
import com.example.studentmanagement.service.impl.DiemService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-diem", "/api-admin-diem/*", "/api-admin-diem/sv/*" })
public class DiemAPI extends HttpServlet {

    private IDiemService diemService;

    public DiemAPI() {
        diemService = new DiemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        String requestURI = req.getRequestURI();
        if (requestURI.equals("/api-admin-diem")) {
            // get list object
            List<DiemModel> listDiem = diemService.findAll();

            // convert list model to json for response
            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listDiem);
        }
        else if (requestURI.startsWith("/api-admin-diem/sv/"))
        {
            String maSV = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            List<DiemDTO> listDiem = diemService.findByStudent(maSV);

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listDiem);
        }
        else if (requestURI.startsWith("/api-admin-diem/"))
        {
            String maLop = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            List<DiemDTO> listDiem = diemService.findByClass(maLop);

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listDiem);
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
        DiemModel diemNew = HttpUtil.of(req.getReader()).toModel(DiemModel.class);

        // create new data point in database
        diemNew = diemService.save(diemNew);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), diemNew);
        return;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        DiemDTO diemUpdate = HttpUtil.of(req.getReader()).toModel(DiemDTO.class);

        // update new data point in database
        diemUpdate = diemService.update(diemUpdate);

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), diemUpdate);
        return;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content for client
        resp.setContentType("application/json");

        // binding data json to string-json, mapping data with model class
        DiemModel diemDelete = HttpUtil.of(req.getReader()).toModel(DiemModel.class);

        // delete target data point in database
        diemService.delete(diemDelete.getMaSV(), diemDelete.getMaMH(), diemDelete.getMaLoaiDiem());

        // convert model to json for response
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), "{}");
        return;
    }
}
