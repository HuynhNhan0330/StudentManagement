package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.DiemDTO;
import com.example.studentmanagement.dto.LichHocDTO;
import com.example.studentmanagement.jpa.ILopHocJPA;
import com.example.studentmanagement.model.DiemModel;
import com.example.studentmanagement.service.ILopHocService;
import com.example.studentmanagement.service.impl.LopHocService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/api-admin-lichhoc/sv/*", "/api-admin-lichhoc/gv/*" })

public class LichHocAPI extends HttpServlet {

    private ILopHocService lopHocService;

    public LichHocAPI() { lopHocService = new LopHocService(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();

        String requestURI = req.getRequestURI();

        if (requestURI.startsWith("/api-admin-lichhoc/sv/"))
        {
            String maSV = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            List<LichHocDTO> listLichHoc = lopHocService.findScheduleOfStudent(maSV);

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listLichHoc);
        }
        else if (requestURI.startsWith("/api-admin-lichhoc/gv/"))
        {
            String maGV = requestURI.substring(requestURI.lastIndexOf("/") + 1);

            List<LichHocDTO> listLichHoc = lopHocService.findScheduleOfLecturer(maGV);

            resp.setStatus(HttpServletResponse.SC_OK);
            mapper.writeValue(resp.getOutputStream(), listLichHoc);
        }

        return;
    }
}
