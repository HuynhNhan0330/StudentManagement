import com.example.studentmanagement.jpa.impl.DiemJPA;
import com.example.studentmanagement.jpa.impl.LoaiDiemJPA;
import com.example.studentmanagement.jpa.impl.MonHocJPA;

public class Main {

    public static void main(String[] args) {
        DiemJPA jpa = new DiemJPA();

        System.out.println(jpa.findByStudent("SV0001"));
    }
}
