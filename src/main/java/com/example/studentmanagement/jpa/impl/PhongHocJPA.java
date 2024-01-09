package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.jpa.IPhongHocJPA;
import com.example.studentmanagement.model.LoaiDiemModel;
import com.example.studentmanagement.model.PhongHocModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PhongHocJPA implements IPhongHocJPA {

    @Override
    public List<PhongHocModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<PhongHocModel> query = entityManager.createQuery("SELECT ph FROM PhongHocModel ph", PhongHocModel.class);
            List<PhongHocModel> phongHocList = query.getResultList();

            return phongHocList;
        } catch (Exception e1) {
            return null;
        } finally {
            try {
                if (entityManagerFactory != null) {
                    entityManagerFactory.close();
                }
                if (entityManager != null) {
                    entityManager.close();
                }
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
