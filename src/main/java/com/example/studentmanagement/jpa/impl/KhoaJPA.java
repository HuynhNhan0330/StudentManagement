package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.jpa.IKhoaJPA;
import com.example.studentmanagement.model.KhoaModel;
import com.example.studentmanagement.model.MonHocModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class KhoaJPA implements IKhoaJPA {

    @Override
    public List<KhoaModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<KhoaModel> query = entityManager.createQuery("SELECT kh FROM KhoaModel kh", KhoaModel.class);
            List<KhoaModel> khoaList = query.getResultList();

            return khoaList;
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
    public String findMaxMaKhoa() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(kh.maKhoa) FROM KhoaModel kh", String.class);
            String maxMaKhoa  = query.getSingleResult();

            return maxMaKhoa;
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
    public KhoaModel findOne(String maKhoa) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            KhoaModel kh = entityManager.find(KhoaModel.class, maKhoa);

            return kh;
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
    public String save(KhoaModel khoaModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            KhoaModel kh = new KhoaModel();
            kh.setMaKhoa(khoaModel.getMaKhoa());
            kh.setTenKhoa(khoaModel.getTenKhoa());

            entityManager.persist(kh);
            entityManager.getTransaction().commit();

            return khoaModel.getMaKhoa();
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
    public void update(KhoaModel khoaModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            KhoaModel kh = entityManager.find(KhoaModel.class, khoaModel.getMaKhoa());
            kh.setTenKhoa(khoaModel.getTenKhoa());

            entityManager.merge(kh);
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
    public Boolean delete(String maKhoa) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            KhoaModel kh = entityManager.find(KhoaModel.class, maKhoa);

            entityManager.remove(kh);
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
    public Boolean checkFacultyName(String tenKhoa) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT kh FROM KhoaModel kh WHERE kh.tenKhoa = :tenKhoa";
            TypedQuery<KhoaModel> query = entityManager.createQuery(jpql, KhoaModel.class);
            query.setParameter("tenKhoa", tenKhoa);

            KhoaModel khoa = query.getSingleResult();

            if (khoa == null)
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
