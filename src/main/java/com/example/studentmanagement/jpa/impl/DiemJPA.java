package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.jpa.IDiemJPA;
import com.example.studentmanagement.model.DiemModel;
import com.example.studentmanagement.model.DiemModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DiemJPA implements IDiemJPA {
    @Override
    public List<DiemModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<DiemModel> query = entityManager.createQuery("SELECT di FROM DiemModel di", DiemModel.class);
            List<DiemModel> diemList = query.getResultList();

            return diemList;
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
                return null;
            }
        }
    }

    @Override
    public DiemModel findOne(String maSV, String maMH, String maLoaiDiem) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT d FROM DiemModel d WHERE d.maSV = :maSV AND d.maMH = :maMH AND d.maLoaiDiem = :maLoaiDiem";
            TypedQuery<DiemModel> query = entityManager.createQuery(jpql, DiemModel.class);
            query.setParameter("maSV", maSV);
            query.setParameter("maMH", maMH);
            query.setParameter("maLoaiDiem", maLoaiDiem);
            DiemModel di = query.getSingleResult();

            return di;
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
    public String[] save(DiemModel diemModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            DiemModel di = new DiemModel();
            di.setMaSV(diemModel.getMaSV());
            di.setMaMH(diemModel.getMaMH());
            di.setMaLoaiDiem(diemModel.getMaLoaiDiem());
            di.setDiem(diemModel.getDiem());

            entityManager.persist(di);
            entityManager.getTransaction().commit();

            return new String[] {diemModel.getMaSV(), diemModel.getMaMH(), diemModel.getMaLoaiDiem()};
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
    public void update(DiemModel diemModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            String jpql = "SELECT d FROM DiemModel d WHERE d.maSV = :maSV AND d.maMH = :maMH AND d.maLoaiDiem = :maLoaiDiem";
            TypedQuery<DiemModel> query = entityManager.createQuery(jpql, DiemModel.class);
            query.setParameter("maSV", diemModel.getMaSV());
            query.setParameter("maMH", diemModel.getMaMH());
            query.setParameter("maLoaiDiem", diemModel.getMaLoaiDiem());
            DiemModel di = query.getSingleResult();

            di.setDiem(diemModel.getDiem());

            entityManager.merge(di);
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
    public void delete(String maSV, String maMH, String maLoaiDiem) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            String jpql = "SELECT d FROM DiemModel d WHERE d.maSV = :maSV AND d.maMH = :maMH AND d.maLoaiDiem = :maLoaiDiem";
            TypedQuery<DiemModel> query = entityManager.createQuery(jpql, DiemModel.class);
            query.setParameter("maSV", maSV);
            query.setParameter("maMH", maMH);
            query.setParameter("maLoaiDiem", maLoaiDiem);
            DiemModel di = query.getSingleResult();

            entityManager.remove(di);
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
