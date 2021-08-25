import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getStudentId(),student2.getStudentId());
    }
}
