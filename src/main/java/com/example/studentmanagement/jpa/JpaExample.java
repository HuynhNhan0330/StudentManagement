package com.example.studentmanagement.jpa;

import com.example.studentmanagement.model.LoaiDiem;

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

    public List<LoaiDiem> getLoaiDiemList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<LoaiDiem> query = entityManager.createQuery("SELECT ld FROM LoaiDiem ld", LoaiDiem.class);
        List<LoaiDiem> loaiDiemList = query.getResultList();

        for (LoaiDiem loaiDiem : loaiDiemList) {
            // Thực hiện thao tác với dữ liệu
            System.out.println("MaLoaiDiem: " + loaiDiem.getMaLoaiDiem() + ", TenLoaiDiem: " + loaiDiem.getTenLoaiDiem());
        }

        return loaiDiemList;
    }
}
