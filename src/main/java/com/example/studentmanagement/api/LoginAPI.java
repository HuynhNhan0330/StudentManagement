package com.example.studentmanagement.api;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.dto.TaiKhoanDTO;
import com.example.studentmanagement.model.LoaiDiemModel;
import com.example.studentmanagement.model.TaiKhoanModel;
import com.example.studentmanagement.service.ISinhVienService;
import com.example.studentmanagement.service.ITaiKhoanService;
import com.example.studentmanagement.service.impl.GiaoVienService;
import com.example.studentmanagement.service.impl.SinhVienService;
import com.example.studentmanagement.service.impl.TaiKhoanService;
import com.example.studentmanagement.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = { "/login" })

public class LoginAPI extends HttpServlet {
    private ITaiKhoanService taiKhoanService;
    private ISinhVienService sinhVienService;
    private GiaoVienService giaoVienService;

    public LoginAPI() {
        taiKhoanService = new TaiKhoanService();
        sinhVienService = new SinhVienService();
        giaoVienService = new GiaoVienService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // format font for request
        req.setCharacterEncoding("UTF-8");

        // format content type for client
        resp.setContentType("application/json");

        // binding json to string-json, mapping data with model.class
        TaiKhoanDTO taiKhoanDTO = HttpUtil.of(req.getReader()).toModel(TaiKhoanDTO.class);

        // create new data point in database
        TaiKhoanModel tk = taiKhoanService.login(taiKhoanDTO);

        ObjectMapper mapper = new ObjectMapper();

        if (tk != null) {
            switch (tk.getRole()) {
                case "1":
                    mapper.writeValue(resp.getOutputStream(), tk);
                    break;

                case "2":
                    // Giáo viên
                    GiaoVienDTO gv = giaoVienService.findAccount(tk.getMaTK());
                    mapper.writeValue(resp.getOutputStream(), gv);
                    break;

                case "3":
                    // Sinh viên
                    SinhVienDTO sv = sinhVienService.findAccount(tk.getMaTK());
                    mapper.writeValue(resp.getOutputStream(), sv);
                    break;
            }
        }
        else {
            mapper.writeValue(resp.getOutputStream(), null);
        }

        // convert model to json for response
        return;
    }
}
