package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.LoaiDiemModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaExample {
    private EntityManagerFactory entityManagerFactory;

    public JpaExample() {
        entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
    }

    public List<LoaiDiemModel> getLoaiDiemList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<LoaiDiemModel> query = entityManager.createQuery("SELECT ld FROM LoaiDiemModel ld", LoaiDiemModel.class);
        List<LoaiDiemModel> loaiDiemList = query.getResultList();

        for (LoaiDiemModel loaiDiem : loaiDiemList) {
            // Thực hiện thao tác với dữ liệu
            System.out.println("MaLoaiDiem: " + loaiDiem.getMaLoaiDiem() + ", TenLoaiDiem: " + loaiDiem.getTenLoaiDiem());
        }

        return loaiDiemList;
    }
}
