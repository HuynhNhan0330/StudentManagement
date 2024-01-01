import com.example.studentmanagement.jpa.impl.LoaiDiemJPA;
import com.example.studentmanagement.jpa.impl.MonHocJPA;

public class Main {

    public static void main(String[] args) {
        MonHocJPA jpa = new MonHocJPA();

        System.out.println(jpa.checkSubjectName("Anh văn 6"));
    }
}
