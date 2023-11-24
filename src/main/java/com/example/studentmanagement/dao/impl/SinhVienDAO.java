package com.example.studentmanagement.dao.impl;

import com.example.studentmanagement.dao.ISinhVienDAO;
import com.example.studentmanagement.model.SinhVienModel;

import javax.persistence.*;
import java.util.List;

public class SinhVienDAO implements ISinhVienDAO {

    @Override
    public List<SinhVienModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<SinhVienModel> query = entityManager.createQuery("SELECT sv FROM SinhVienModel sv", SinhVienModel.class);
            List<SinhVienModel> sinhVienList = query.getResultList();

            return sinhVienList;
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
    public String findMaxMaSinhVien() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(sv.maSV) FROM SinhVienModel sv", String.class);

            String maxMaSinhVien  = null;
            try {
                maxMaSinhVien = query.getSingleResult();
                // Xử lý kết quả trả về khi có Sinh Viên trong cơ sở dữ liệu
            } catch (NoResultException e) {
                // Xử lý khi không có Sinh Viên trong cơ sở dữ liệu
            }

            return maxMaSinhVien;
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
    public SinhVienModel findOne(String maSinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            SinhVienModel sv = entityManager.find(SinhVienModel.class, maSinhVien);

            return sv;
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
    public String save(SinhVienModel sinhVienModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVienModel sv = new SinhVienModel();
            sv.setMaSV(sinhVienModel.getMaSV());
            sv.setTenSV(sinhVienModel.getTenSV());
            sv.setNgaySinh(sinhVienModel.getNgaySinh());
            sv.setGioiTinh(sinhVienModel.getGioiTinh());
            sv.setNamNhapHoc(sinhVienModel.getNamNhapHoc());
            sv.setMaNganh(sinhVienModel.getMaNganh());

            entityManager.persist(sv);
            entityManager.getTransaction().commit();

            return sinhVienModel.getMaSV();
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
    public void update(SinhVienModel sinhVienModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVienModel sv = entityManager.find(SinhVienModel.class, sinhVienModel.getMaSV());
            sv.setTenSV(sinhVienModel.getTenSV());
            sv.setNgaySinh(sinhVienModel.getNgaySinh());
            sv.setGioiTinh(sinhVienModel.getGioiTinh());
            sv.setNamNhapHoc(sinhVienModel.getNamNhapHoc());
            sv.setMaNganh(sinhVienModel.getMaNganh());

            entityManager.merge(sv);
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
    public void delete(String maSinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVienModel sv = entityManager.find(SinhVienModel.class, maSinhVien);

            entityManager.remove(sv);
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
