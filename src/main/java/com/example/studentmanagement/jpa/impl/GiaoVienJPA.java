package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.dto.GiaoVienDTO;
import com.example.studentmanagement.jpa.IGiaoVienJPA;
import com.example.studentmanagement.model.GiaoVienModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class GiaoVienJPA implements IGiaoVienJPA {
    @Override
    public List<GiaoVienDTO> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<GiaoVienDTO> query = entityManager.createQuery("SELECT new com.example.studentmanagement.dto.GiaoVienDTO(gv.maGV, gv.maKhoa, kh.tenKhoa, gv.maTK, tk.tenTK, tk.ngaySinh, tk.email, tk.phone, tk.role) FROM GiaoVienModel gv JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK JOIN KhoaModel kh ON gv.maKhoa = kh.maKhoa", GiaoVienDTO.class);
            List<GiaoVienDTO> giaoVienList = query.getResultList();

            return giaoVienList;
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
    public String findMaxMaGiaoVien() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(gv.maGV) FROM GiaoVienModel gv", String.class);
            String maxMaGiaoVien  = query.getSingleResult();

            return maxMaGiaoVien;
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
    public GiaoVienDTO findOne(String maGV) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.GiaoVienDTO(gv.maGV, gv.maKhoa, kh.tenKhoa, gv.maTK, tk.tenTK, tk.ngaySinh, tk.email, tk.phone, tk.role) FROM GiaoVienModel gv JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK JOIN KhoaModel kh ON gv.maKhoa = kh.maKhoa WHERE gv.maGV = :maGV";
            TypedQuery<GiaoVienDTO> query = entityManager.createQuery(jpql, GiaoVienDTO.class);
            query.setParameter("maGV", maGV);
            GiaoVienDTO gv = query.getSingleResult();

            return gv;
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
    public String save(GiaoVienDTO giaoVienDTO) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            GiaoVienModel gv = new GiaoVienModel();
            gv.setMaGV(giaoVienDTO.getMaGV());
            gv.setMaKhoa(giaoVienDTO.getMaKhoa());
            gv.setMaTK(giaoVienDTO.getMaTK());

            entityManager.persist(gv);
            entityManager.getTransaction().commit();

            return giaoVienDTO.getMaGV();
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
    public void update(GiaoVienDTO giaoVienDTO) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            GiaoVienModel gv = entityManager.find(GiaoVienModel.class, giaoVienDTO.getMaGV());
            gv.setMaKhoa(giaoVienDTO.getMaKhoa());

            entityManager.merge(gv);
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
    public Boolean delete(String maGV) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            GiaoVienModel gv = entityManager.find(GiaoVienModel.class, maGV);

            entityManager.remove(gv);
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
    public GiaoVienDTO findAccount(String maTK) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.GiaoVienDTO(gv.maGV, gv.maKhoa, kh.tenKhoa, tk.maTK, tk.tenTK, tk.ngaySinh, tk.email, tk.phone, tk.role)" +
                    " FROM GiaoVienModel gv JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK" +
                    " JOIN KhoaModel kh ON gv.maKhoa = kh.maKhoa WHERE gv.maTK = :maTK";
            TypedQuery<GiaoVienDTO> query = entityManager.createQuery(jpql, GiaoVienDTO.class);
            query.setParameter("maTK", maTK);

            GiaoVienDTO gv = query.getSingleResult();

            return gv;
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
