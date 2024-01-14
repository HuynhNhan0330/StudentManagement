package com.example.studentmanagement.jpa.impl;

import com.example.studentmanagement.dto.LichHocDTO;
import com.example.studentmanagement.dto.LopHocDTO;
import com.example.studentmanagement.jpa.ILopHocJPA;
import com.example.studentmanagement.model.LopHocModel;
import com.example.studentmanagement.utils.Helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LopHocJPA implements ILopHocJPA {
    @Override
    public List<LopHocDTO> findAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LopHocDTO(lh.maLop, lh.tenLop, lh.maGV, tk.tenTK, lh.maMH, mh.tenMH, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, lh.maKH, kh.tenKH, lh.maPH, ph.tenPH, kh.thoiGianBatDau, kh.thoiGianKetThuc) FROM LopHocModel lh JOIN PhongHocModel ph ON lh.maPH = ph.maPH JOIN KyHocModel kh ON lh.maKH = kh.maKH JOIN GiaoVienModel gv ON lh.maGV = gv.maGV JOIN MonHocModel mh ON lh.maMH = mh.maMH JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK";
            TypedQuery<LopHocDTO> query = entityManager.createQuery(jpql, LopHocDTO.class);

            List<LopHocDTO> lopHocList = query.getResultList();

            return lopHocList;
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
    public List<LopHocDTO> findByLecturer(String maGV) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LopHocDTO(lh.maLop, lh.tenLop, lh.maGV, tk.tenTK, lh.maMH, mh.tenMH, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, lh.maKH, kh.tenKH, lh.maPH, ph.tenPH, kh.thoiGianBatDau, kh.thoiGianKetThuc) FROM LopHocModel lh JOIN PhongHocModel ph ON lh.maPH = ph.maPH JOIN KyHocModel kh ON lh.maKH = kh.maKH JOIN GiaoVienModel gv ON lh.maGV = gv.maGV JOIN MonHocModel mh ON lh.maMH = mh.maMH JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK WHERE lh.maGV = :maGV";
            TypedQuery<LopHocDTO> query = entityManager.createQuery(jpql, LopHocDTO.class);
            query.setParameter("maGV", maGV);
            List<LopHocDTO> lopHocList = query.getResultList();

            return lopHocList;
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
    public List<LichHocDTO> findScheduleOfStudent(String maSV) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LichHocDTO(lh.tenLop, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, kh.thoiGianBatDau, kh.thoiGianKetThuc) FROM ChiTietDangKyModel ctdk" +
                    " JOIN LopHocModel lh ON ctdk.maLop = lh.maLop" +
                    " JOIN KyHocModel kh ON kh.maKH = lh.maKH" +
                    " WHERE ctdk.maSV = :maSV";

            TypedQuery<LichHocDTO> query = entityManager.createQuery(jpql, LichHocDTO.class);
            query.setParameter("maSV", maSV);
            List<LichHocDTO> lichHocList = query.getResultList();

            return lichHocList;
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
    public List<LichHocDTO> findScheduleOfLecturer(String maGV) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LichHocDTO(lh.tenLop, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, kh.thoiGianBatDau, kh.thoiGianKetThuc)" +
                    " FROM LopHocModel lh" +
                    " JOIN KyHocModel kh ON kh.maKH = lh.maKH" +
                    " WHERE lh.maGV = :maGV";

            TypedQuery<LichHocDTO> query = entityManager.createQuery(jpql, LichHocDTO.class);
            query.setParameter("maGV", maGV);
            List<LichHocDTO> lichHocList = query.getResultList();

            return lichHocList;
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
    public String findMaxMaLopHoc() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<String> query = entityManager.createQuery("SELECT MAX(lh.maLop) FROM LopHocModel lh", String.class);
            String maxMaLopHoc  = query.getSingleResult();

            return maxMaLopHoc;
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
    public LopHocDTO findOne(String maLop) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LopHocDTO(lh.maLop, lh.tenLop, lh.maGV, tk.tenTK, lh.maMH, mh.tenMH, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, lh.maKH, kh.tenKH, lh.maPH, ph.tenPH, kh.thoiGianBatDau, kh.thoiGianKetThuc) FROM LopHocModel lh JOIN PhongHocModel ph ON lh.maPH = ph.maPH JOIN KyHocModel kh ON lh.maKH = kh.maKH JOIN GiaoVienModel gv ON lh.maGV = gv.maGV JOIN MonHocModel mh ON lh.maMH = mh.maMH JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK WHERE lh.maLop = :maLop";
            TypedQuery<LopHocDTO> query = entityManager.createQuery(jpql, LopHocDTO.class);
            query.setParameter("maLop", maLop);

            LopHocDTO lh = query.getSingleResult();

            return lh;
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
    public String save(LopHocModel lopHocModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            LopHocModel lh = new LopHocModel();
            lh.setMaLop(lopHocModel.getMaLop());
            lh.setTenLop(lopHocModel.getTenLop());
            lh.setMaGV(lopHocModel.getMaGV());
            lh.setMaMH(lopHocModel.getMaMH());
            lh.setMaPH(lopHocModel.getMaPH());
            lh.setMaKH(lopHocModel.getMaKH());
            lh.setThoiGianBatDau(lopHocModel.getThoiGianBatDau());
            lh.setThoiGianKetThuc(lopHocModel.getThoiGianKetThuc());
            lh.setNgayHoc(lopHocModel.getNgayHoc());

            entityManager.persist(lh);
            entityManager.getTransaction().commit();

            return lopHocModel.getMaLop();
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
    public void update(LopHocModel lopHocModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            LopHocModel lh = entityManager.find(LopHocModel.class, lopHocModel.getMaLop());
            lh.setTenLop(lopHocModel.getTenLop());
            lh.setMaGV(lopHocModel.getMaGV());
            lh.setMaMH(lopHocModel.getMaMH());

            entityManager.merge(lh);
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
    public void delete(String maLop) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            LopHocModel lh = entityManager.find(LopHocModel.class, maLop);

            entityManager.remove(lh);
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
    public Boolean checkRoom(LopHocModel lopHocModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LopHocDTO(lh.maLop, lh.tenLop, lh.maGV, tk.tenTK, lh.maMH, mh.tenMH, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, lh.maKH, kh.tenKH, lh.maPH, ph.tenPH, kh.thoiGianBatDau, kh.thoiGianKetThuc) FROM LopHocModel lh JOIN PhongHocModel ph ON lh.maPH = ph.maPH JOIN KyHocModel kh ON lh.maKH = kh.maKH JOIN GiaoVienModel gv ON lh.maGV = gv.maGV JOIN MonHocModel mh ON lh.maMH = mh.maMH JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK WHERE lh.maKH = :maKH  AND lh.maPH = :maPH AND lh.ngayHoc = :ngayHoc";

            TypedQuery<LopHocDTO> query = entityManager.createQuery(jpql, LopHocDTO.class);
            query.setParameter("ngayHoc", lopHocModel.getNgayHoc());
            query.setParameter("maKH", lopHocModel.getMaKH());
            query.setParameter("maPH", lopHocModel.getMaPH());

            List<LopHocDTO> lopHocList = query.getResultList();

            for (LopHocDTO lh: lopHocList) {
                if (Helper.checkTimeOverlapping(lopHocModel.getThoiGianBatDau(), lopHocModel.getThoiGianKetThuc(), lh.getThoiGianBatDau(), lh.getThoiGianKetThuc())) {
                    return false;
                }
            }

            return true;
        } catch (Exception e1) {
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
                return null;
            }
        }
    }

    @Override
    public Boolean checkTeacher(LopHocModel lopHocModel) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT new com.example.studentmanagement.dto.LopHocDTO(lh.maLop, lh.tenLop, lh.maGV, tk.tenTK, lh.maMH, mh.tenMH, lh.ngayHoc, lh.thoiGianBatDau, lh.thoiGianKetThuc, lh.maKH, kh.tenKH, lh.maPH, ph.tenPH, kh.thoiGianBatDau, kh.thoiGianKetThuc) FROM LopHocModel lh JOIN PhongHocModel ph ON lh.maPH = ph.maPH JOIN KyHocModel kh ON lh.maKH = kh.maKH JOIN GiaoVienModel gv ON lh.maGV = gv.maGV JOIN MonHocModel mh ON lh.maMH = mh.maMH JOIN TaiKhoanModel tk ON gv.maTK = tk.maTK WHERE lh.maKH = :maKH  AND lh.maGV = :maGV AND lh.ngayHoc = :ngayHoc";

            TypedQuery<LopHocDTO> query = entityManager.createQuery(jpql, LopHocDTO.class);
            query.setParameter("ngayHoc", lopHocModel.getNgayHoc());
            query.setParameter("maKH", lopHocModel.getMaKH());
            query.setParameter("maGV", lopHocModel.getMaGV());

            List<LopHocDTO> lopHocList = query.getResultList();

            for (LopHocDTO lh: lopHocList) {
                if (Helper.checkTimeOverlapping(lopHocModel.getThoiGianBatDau(), lopHocModel.getThoiGianKetThuc(), lh.getThoiGianBatDau(), lh.getThoiGianKetThuc())) {
                    return false;
                }
            }

            return true;
        } catch (Exception e1) {
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
                return null;
            }
        }
    }

    @Override
    public Boolean checkStudent(String maSV, LopHocDTO lopHocDTO) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("StudentManagementX");
            entityManager = entityManagerFactory.createEntityManager();

            String jpql = "SELECT lh FROM LopHocModel lh JOIN ChiTietDangKyModel ctdk ON ctdk.maLop = lh.maLop WHERE ctdk.maSV = :maSV AND lh.ngayHoc = :ngayHoc";

            TypedQuery<LopHocModel> query = entityManager.createQuery(jpql, LopHocModel.class);
            query.setParameter("maSV", maSV);
            query.setParameter("ngayHoc", lopHocDTO.getNgayHoc());

            List<LopHocModel> lopHocList = query.getResultList();

            for (LopHocModel lh: lopHocList) {
                if (Helper.checkTimeOverlapping(lopHocDTO.getThoiGianBatDau(), lopHocDTO.getThoiGianKetThuc(), lh.getThoiGianBatDau(), lh.getThoiGianKetThuc())) {
                    return false;
                }
            }

            return true;
        } catch (Exception e1) {
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
                return null;
            }
        }
    }
}
