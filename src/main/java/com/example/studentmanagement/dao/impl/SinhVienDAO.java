package com.example.studentmanagement.dao.impl;

import com.example.studentmanagement.dao.ISinhVienDAO;
import com.example.studentmanagement.model.SinhVien;

import javax.persistence.*;
import java.util.List;

public class SinhVienDAO implements ISinhVienDAO {

    @Override
    public List<SinhVien> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<SinhVien> query = entityManager.createQuery("SELECT sv FROM SinhVien sv", SinhVien.class);
            List<SinhVien> sinhVienList = query.getResultList();

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

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(sv.maSV) FROM SinhVien sv", String.class);

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
    public SinhVien findOne(String maSinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            SinhVien sv = entityManager.find(SinhVien.class, maSinhVien);

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
    public String save(SinhVien sinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVien sv = new SinhVien();
            sv.setMaSV(sinhVien.getMaSV());
            sv.setTenSV(sinhVien.getTenSV());
            sv.setNgaySinh(sinhVien.getNgaySinh());
            sv.setGioiTinh(sinhVien.getGioiTinh());
            sv.setNamNhapHoc(sinhVien.getNamNhapHoc());
//            sv.setNganh(sinhVien.getNganh());

            entityManager.persist(sv);
            entityManager.getTransaction().commit();

            return sinhVien.getMaSV();
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
    public void update(SinhVien sinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVien sv = entityManager.find(SinhVien.class, sinhVien.getMaSV());
            sv.setTenSV(sinhVien.getTenSV());
            sv.setNgaySinh(sinhVien.getNgaySinh());
            sv.setGioiTinh(sinhVien.getGioiTinh());
            sv.setNamNhapHoc(sinhVien.getNamNhapHoc());
//            sv.setNganh(sinhVien.getNganh());

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

            SinhVien sv = entityManager.find(SinhVien.class, maSinhVien);

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
