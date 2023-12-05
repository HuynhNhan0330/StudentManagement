package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.jpa.ILoaiDiemJPA;
import com.example.studentmanagement.model.LoaiDiemModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoaiDiemJPA implements ILoaiDiemJPA {

    @Override
    public List<LoaiDiemModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<LoaiDiemModel> query = entityManager.createQuery("SELECT ld FROM LoaiDiemModel ld", LoaiDiemModel.class);
            List<LoaiDiemModel> loaiDiemList = query.getResultList();

            return loaiDiemList;
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

    @Override
    public String findMaxMaLoaiDiem() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(ld.maLoaiDiem) FROM LoaiDiemModel ld", String.class);
            String maxMaLoaiDiem  = query.getSingleResult();

            return maxMaLoaiDiem;
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

    @Override
    public LoaiDiemModel findOne(String maLoaiDiem) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            LoaiDiemModel ld = entityManager.find(LoaiDiemModel.class, maLoaiDiem);

            return ld;
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
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
                System.out.println(e2.getMessage());
                return null;
            }
        }
    }

    @Override
    public String save(LoaiDiemModel loaiDiem) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            LoaiDiemModel ld = new LoaiDiemModel();
            ld.setMaLoaiDiem(loaiDiem.getMaLoaiDiem());
            ld.setTenLoaiDiem(loaiDiem.getTenLoaiDiem());
            ld.setTiLe(loaiDiem.getTiLe());

            entityManager.persist(ld);
            entityManager.getTransaction().commit();

            return loaiDiem.getMaLoaiDiem();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
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
                System.out.println(e2.getMessage());
                return null;
            }
        }
    }

    @Override
    public void update(LoaiDiemModel loaiDiem) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            LoaiDiemModel ld = entityManager.find(LoaiDiemModel.class, loaiDiem.getMaLoaiDiem());
            ld.setTenLoaiDiem(loaiDiem.getTenLoaiDiem());
            ld.setTiLe(loaiDiem.getTiLe());

            entityManager.merge(ld);
            entityManager.getTransaction().commit();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        } finally {
            try {
                if (entityManagerFactory != null) {
                    entityManagerFactory.close();
                }
                if (entityManager != null) {
                    entityManager.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    @Override
    public void delete(String maLoaiDiem) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            LoaiDiemModel ld = entityManager.find(LoaiDiemModel.class, maLoaiDiem);

            entityManager.remove(ld);
            entityManager.getTransaction().commit();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        } finally {
            try {
                if (entityManagerFactory != null) {
                    entityManagerFactory.close();
                }
                if (entityManager != null) {
                    entityManager.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
