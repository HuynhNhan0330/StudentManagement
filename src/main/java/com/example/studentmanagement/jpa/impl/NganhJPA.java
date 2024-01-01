package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.dto.NganhDTO;
import com.example.studentmanagement.jpa.INganhJPA;
import com.example.studentmanagement.model.NganhModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class NganhJPA implements INganhJPA {

    @Override
    public List<NganhDTO> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<NganhDTO> query = entityManager.createQuery("SELECT new com.example.studentmanagement.dto.NganhDTO(ng.maNganh, ng.tenNganh, ng.maKhoa, kh.tenKhoa) FROM NganhModel ng, KhoaModel kh WHERE ng.maKhoa = kh.maKhoa", NganhDTO.class);
            List<NganhDTO> nganhList = query.getResultList();

            return nganhList;
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
    public String findMaxMaNganh() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(ng.maNganh) FROM NganhModel ng", String.class);
            String maxMaNganh  = query.getSingleResult();

            return maxMaNganh;
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
    public NganhDTO findOne(String maNganh) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.NganhDTO(ng.maNganh, ng.tenNganh, ng.maKhoa, kh.tenKhoa) FROM NganhModel ng JOIN KhoaModel kh ON ng.maKhoa = kh.maKhoa WHERE ng.maNganh = :maNganh";
            TypedQuery<NganhDTO> query = entityManager.createQuery(jpql, NganhDTO.class);
            query.setParameter("maNganh", maNganh);
            NganhDTO ng = query.getSingleResult();

            return ng;
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
    public String save(NganhModel nganhModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            NganhModel ng = new NganhModel();
            ng.setMaNganh(nganhModel.getMaNganh());
            ng.setTenNganh(nganhModel.getTenNganh());
            ng.setMaKhoa(nganhModel.getMaKhoa());

            entityManager.persist(ng);
            entityManager.getTransaction().commit();

            return nganhModel.getMaNganh();
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
    public void update(NganhModel nganhModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            NganhModel ng = entityManager.find(NganhModel.class, nganhModel.getMaNganh());
            ng.setTenNganh(nganhModel.getTenNganh());
            ng.setMaKhoa(nganhModel.getMaKhoa());

            entityManager.merge(ng);
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
    public Boolean delete(String maNganh) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            NganhModel ng = entityManager.find(NganhModel.class, maNganh);

            entityManager.remove(ng);
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
    public Boolean checkMajorName(String tenNganh) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.NganhDTO(ng.maNganh, ng.tenNganh, ng.maKhoa, kh.tenKhoa) FROM NganhModel ng JOIN KhoaModel kh ON ng.maKhoa = kh.maKhoa WHERE ng.tenNganh = :tenNganh";
            TypedQuery<NganhDTO> query = entityManager.createQuery(jpql, NganhDTO.class);
            query.setParameter("tenNganh", tenNganh);
            NganhDTO nganh = query.getSingleResult();

            if (nganh == null)
                return false;
            else
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
}
