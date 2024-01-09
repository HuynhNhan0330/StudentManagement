package com.example.studentmanagement.api;

import com.example.studentmanagement.model.PhongHocModel;
import com.example.studentmanagement.service.IPhongHocService;
import com.example.studentmanagement.service.impl.PhongHocService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-phonghoc" })
public class PhongHocAPI extends HttpServlet {
    private IPhongHocService phongHocService;

    public PhongHocAPI() {
        phongHocService = new PhongHocService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // get list object
        List<PhongHocModel> listPhongHoc = phongHocService.findAll();

        // convert list model to json for response
        ObjectMapper mapper = new ObjectMapper();
        resp.setStatus(HttpServletResponse.SC_OK);
        mapper.writeValue(resp.getOutputStream(), listPhongHoc);
        return;
    }
}
