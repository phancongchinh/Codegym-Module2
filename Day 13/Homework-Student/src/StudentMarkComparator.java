import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return - Double.compare(student1.getMark(),student2.getMark());
    }
}
