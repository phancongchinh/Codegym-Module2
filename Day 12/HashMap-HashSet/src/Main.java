import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("chinh", 93, "ha nam");
        Student student2 = new Student("bong", 92, "thua thien hue");
        Student student3 = new Student("bom", 88, "ha noi");

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
//        studentMap.put(1,student1);

        System.out.println("The map:");
        for (Map.Entry<Integer,Student> entry : studentMap.entrySet()) {
            System.out.println(entry);
        }

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        System.out.println("The set:");
        for (Student student : studentSet) {
            System.out.println(student);
        }


    }
}
