import com.example.studentmanagement.jpa.impl.LoaiDiemJPA;

public class Main {

    public static void main(String[] args) {
        LoaiDiemJPA ldDAO = new LoaiDiemJPA();

        System.out.println(ldDAO.findMaxMaLoaiDiem());
    }
}
