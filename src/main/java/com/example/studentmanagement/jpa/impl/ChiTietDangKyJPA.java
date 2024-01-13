package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.jpa.IChiTietDangKyJPA;
import com.example.studentmanagement.model.ChiTietDangKyModel;
import com.example.studentmanagement.model.GiaoVienModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class ChiTietDangKyJPA implements IChiTietDangKyJPA {
    @Override
    public List<ChiTietDangKyModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<ChiTietDangKyModel> query = entityManager.createQuery("SELECT ctdk FROM ChiTietDangKyModel ctdk", ChiTietDangKyModel.class);
            List<ChiTietDangKyModel> chiTietDangKyList = query.getResultList();

            return chiTietDangKyList;
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
    public ChiTietDangKyModel findOne(String maSV, String maLop) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT c FROM ChiTietDangKyModel c WHERE c.maSV = :maSV AND c.maLop = :maLop";
            TypedQuery<ChiTietDangKyModel> query = entityManager.createQuery(jpql, ChiTietDangKyModel.class);
            query.setParameter("maSV", maSV);
            query.setParameter("maLop", maLop);
            ChiTietDangKyModel ctdk = query.getSingleResult();

            return ctdk;
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
    public String[] save(ChiTietDangKyModel chiTietDangKyModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            ChiTietDangKyModel ctdk = new ChiTietDangKyModel();
            ctdk.setMaSV(chiTietDangKyModel.getMaSV());
            ctdk.setMaLop(chiTietDangKyModel.getMaLop());
            ctdk.setKyHoc(chiTietDangKyModel.getKyHoc());
            ctdk.setDau(chiTietDangKyModel.getDau());

            entityManager.persist(ctdk);
            entityManager.getTransaction().commit();

            return new String[] {chiTietDangKyModel.getMaSV(), chiTietDangKyModel.getMaLop()};
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
    public void update(ChiTietDangKyModel chiTietDangKyModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            String jpql = "SELECT c FROM ChiTietDangKyModel c WHERE c.maSV = :maSV AND c.maLop = :maLop";
            TypedQuery<ChiTietDangKyModel> query = entityManager.createQuery(jpql, ChiTietDangKyModel.class);
            query.setParameter("maSV", chiTietDangKyModel.getMaSV());
            query.setParameter("maLop", chiTietDangKyModel.getMaLop());
            ChiTietDangKyModel ctdk = query.getSingleResult();

            ctdk.setKyHoc(chiTietDangKyModel.getKyHoc());

            entityManager.merge(ctdk);
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
    public void delete(String maSV, String maLop) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            String jpql = "SELECT c FROM ChiTietDangKyModel c WHERE c.maSV = :maSV AND c.maLop = :maLop";
            TypedQuery<ChiTietDangKyModel> query = entityManager.createQuery(jpql, ChiTietDangKyModel.class);
            query.setParameter("maSV", maSV);
            query.setParameter("maLop", maLop);
            ChiTietDangKyModel ctdk = query.getSingleResult();

            entityManager.remove(ctdk);
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
