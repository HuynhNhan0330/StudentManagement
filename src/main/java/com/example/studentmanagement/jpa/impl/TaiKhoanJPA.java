package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.dto.TaiKhoanDTO;
import com.example.studentmanagement.jpa.ITaiKhoanJPA;
import com.example.studentmanagement.model.TaiKhoanModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TaiKhoanJPA implements ITaiKhoanJPA {
    @Override
    public String findMaxMaTaiKhoan() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(tk.maTK) FROM TaiKhoanModel tk", String.class);
            String maxMaTK  = query.getSingleResult();

            return maxMaTK;
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
    public String save(TaiKhoanModel taiKhoanModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            TaiKhoanModel tk = new TaiKhoanModel();
            tk.setMaTK(taiKhoanModel.getMaTK());
            tk.setEmail(taiKhoanModel.getEmail());
            tk.setNgaySinh(taiKhoanModel.getNgaySinh());
            tk.setPhone(taiKhoanModel.getPhone());
            tk.setTenTK(taiKhoanModel.getTenTK());
            tk.setRole(taiKhoanModel.getRole());
            tk.setPassword(taiKhoanModel.getPassword());

            entityManager.persist(tk);
            entityManager.getTransaction().commit();

            return tk.getMaTK();
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
    public void update(TaiKhoanModel taiKhoanModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            TaiKhoanModel tk = entityManager.find(TaiKhoanModel.class, taiKhoanModel.getMaTK());
            tk.setEmail(taiKhoanModel.getEmail());
            tk.setNgaySinh(taiKhoanModel.getNgaySinh());
            tk.setPhone(taiKhoanModel.getPhone());
            tk.setTenTK(taiKhoanModel.getTenTK());
            tk.setRole(taiKhoanModel.getRole());
            tk.setPassword(taiKhoanModel.getPassword());

            entityManager.merge(tk);
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
    public Boolean delete(String maTK) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            TaiKhoanModel tk = entityManager.find(TaiKhoanModel.class, maTK);

            entityManager.remove(tk);
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
    public Boolean checkEmail(String email) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT tk FROM TaiKhoanModel tk WHERE tk.email = :email";
            TypedQuery<TaiKhoanModel> query = entityManager.createQuery(jpql, TaiKhoanModel.class);
            query.setParameter("email", email);
            TaiKhoanModel tk = query.getSingleResult();

            if (tk == null)
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

    @Override
    public Boolean checkPhone(String phone) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT tk FROM TaiKhoanModel tk WHERE tk.phone = :phone";
            TypedQuery<TaiKhoanModel> query = entityManager.createQuery(jpql, TaiKhoanModel.class);
            query.setParameter("phone", phone);
            TaiKhoanModel tk = query.getSingleResult();

            if (tk == null)
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

    @Override
    public TaiKhoanModel login(TaiKhoanDTO taiKhoanDTO) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT tk FROM TaiKhoanModel tk WHERE (tk.phone = :phone OR tk.email = :email) AND tk.password = :password";
            TypedQuery<TaiKhoanModel> query = entityManager.createQuery(jpql, TaiKhoanModel.class);
            query.setParameter("phone", taiKhoanDTO.getUsername());
            query.setParameter("email", taiKhoanDTO.getUsername());
            query.setParameter("password", taiKhoanDTO.getPassword());
            TaiKhoanModel tk = query.getSingleResult();

            return tk;
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
            }
        }
    }
}
