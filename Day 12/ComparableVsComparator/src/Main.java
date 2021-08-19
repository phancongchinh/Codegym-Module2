import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("chinh", 93, "ha nam");
        Student student2 = new Student("bong", 92, "thua thien hue");
        Student student3 = new Student("bom", 88, "ha noi");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        System.out.println("The array list: ");
        for (Student student : studentList) {
            System.out.println(student);
        }

        AgeComparator comparator = new AgeComparator();
        studentList.sort(comparator);

        System.out.println("Sắp xếp theo tuổi");
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
}
