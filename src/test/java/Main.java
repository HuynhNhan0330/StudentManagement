import com.example.studentmanagement.dao.impl.LoaiDiemDAO;

public class Main {

    public static void main(String[] args) {
        LoaiDiemDAO ldDAO = new LoaiDiemDAO();

        System.out.println(ldDAO.findMaxMaLoaiDiem());
    }
}
