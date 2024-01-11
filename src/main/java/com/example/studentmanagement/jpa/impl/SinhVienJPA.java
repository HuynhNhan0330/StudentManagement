package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.dto.SinhVienDTO;
import com.example.studentmanagement.jpa.ISinhVienJPA;
import com.example.studentmanagement.model.SinhVienModel;

import javax.persistence.*;
import java.util.List;

public class SinhVienJPA implements ISinhVienJPA {

    @Override
    public List<SinhVienDTO> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<SinhVienDTO> query = entityManager.createQuery("SELECT new com.example.studentmanagement.dto.SinhVienDTO(sv.maSV, sv.maNganh, ng.tenNganh, tk.maTK, tk.tenTK, tk.ngaySinh, tk.email, tk.phone, tk.role, sv.namNhapHoc, sv.gioiTinh) FROM SinhVienModel sv JOIN TaiKhoanModel tk ON sv.maTK = tk.maTK JOIN NganhModel ng ON sv.maNganh = ng.maNganh", SinhVienDTO.class);
            List<SinhVienDTO> sinhVienList = query.getResultList();

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
    public SinhVienDTO findOne(String maSinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.SinhVienDTO(sv.maSV, sv.maNganh, ng.tenNganh, tk.maTK, tk.tenTK, tk.ngaySinh, tk.email, tk.phone, tk.role, sv.namNhapHoc, sv.gioiTinh) FROM SinhVienModel sv JOIN TaiKhoanModel tk ON sv.maTK = tk.maTK JOIN NganhModel ng ON sv.maNganh = ng.maNganh WHERE sv.maSV = :maSinhVien";
            TypedQuery<SinhVienDTO> query = entityManager.createQuery(jpql, SinhVienDTO.class);
            query.setParameter("maSinhVien", maSinhVien);
            SinhVienDTO sv = query.getSingleResult();

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
    public String save(SinhVienDTO sinhVienDTO) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVienModel sv = new SinhVienModel();
            sv.setMaSV(sinhVienDTO.getMaSV());
            sv.setGioiTinh(sinhVienDTO.getGioiTinh());
            sv.setNamNhapHoc(sinhVienDTO.getNamNhapHoc());
            sv.setMaNganh(sinhVienDTO.getMaNganh());
            sv.setMaTK(sinhVienDTO.getMaTK());

            entityManager.persist(sv);
            entityManager.getTransaction().commit();

            return sinhVienDTO.getMaSV();
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
    public void update(SinhVienDTO sinhVienDTO) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVienModel sv = entityManager.find(SinhVienModel.class, sinhVienDTO.getMaSV());
            sv.setGioiTinh(sinhVienDTO.getGioiTinh());
            sv.setNamNhapHoc(sinhVienDTO.getNamNhapHoc());
            sv.setMaNganh(sinhVienDTO.getMaNganh());
            sv.setMaTK(sinhVienDTO.getMaTK());

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
    public Boolean delete(String maSinhVien) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            SinhVienModel sv = entityManager.find(SinhVienModel.class, maSinhVien);

            entityManager.remove(sv);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e1) {
            System.out.println(e1.getMessage());

            return false;
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
    public SinhVienDTO findAccount(String maTK) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.SinhVienDTO(sv.maSV, sv.maNganh, ng.tenNganh, tk.maTK, tk.tenTK, tk.ngaySinh, tk.email, tk.phone, tk.role, sv.namNhapHoc, sv.gioiTinh) FROM SinhVienModel sv JOIN TaiKhoanModel tk ON sv.maTK = tk.maTK JOIN NganhModel ng ON sv.maNganh = ng.maNganh WHERE sv.maTK = :maTK";
            TypedQuery<SinhVienDTO> query = entityManager.createQuery(jpql, SinhVienDTO.class);
            query.setParameter("maTK", maTK);
            SinhVienDTO sv = query.getSingleResult();

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
}
