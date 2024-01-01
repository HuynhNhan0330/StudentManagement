package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.jpa.IMonHocJPA;
import com.example.studentmanagement.model.MonHocModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MonHocJPA implements IMonHocJPA {

    @Override
    public List<MonHocModel> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<MonHocModel> query = entityManager.createQuery("SELECT mh FROM MonHocModel mh", MonHocModel.class);
            List<MonHocModel> monHocList = query.getResultList();

            return monHocList;
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
    public String findMaxMaMonHoc() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(mh.maMH) FROM MonHocModel mh", String.class);
            String maxMaMonHoc  = query.getSingleResult();

            return maxMaMonHoc;
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
    public MonHocModel findOne(String maMH) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            MonHocModel mh = entityManager.find(MonHocModel.class, maMH);

            return mh;
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
    public String save(MonHocModel monHocModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            MonHocModel mh = new MonHocModel();
            mh.setMaMH(monHocModel.getMaMH());
            mh.setTenMH(monHocModel.getTenMH());
            mh.setSoTinChi(monHocModel.getSoTinChi());

            entityManager.persist(mh);
            entityManager.getTransaction().commit();

            return monHocModel.getMaMH();
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
    public void update(MonHocModel monHocModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            MonHocModel mh = entityManager.find(MonHocModel.class, monHocModel.getMaMH());
            mh.setTenMH(monHocModel.getTenMH());
            mh.setSoTinChi(monHocModel.getSoTinChi());

            entityManager.merge(mh);
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
    public Boolean delete(String maMH) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            MonHocModel mh = entityManager.find(MonHocModel.class, maMH);

            entityManager.remove(mh);
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
    public Boolean checkSubjectName(String tenMH) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT mh FROM MonHocModel mh WHERE mh.tenMH = :tenMH";
            TypedQuery<MonHocModel> query = entityManager.createQuery(jpql, MonHocModel.class);
            query.setParameter("tenMH", tenMH);

            MonHocModel monHoc = query.getSingleResult();

            if (monHoc == null)
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
