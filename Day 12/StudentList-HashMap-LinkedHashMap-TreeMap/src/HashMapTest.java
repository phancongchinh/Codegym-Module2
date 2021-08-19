import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("chinh", 93);
        students.put("bong", 92);
        students.put("bom", 88);

        System.out.println("Display all entries: ");
        System.out.println(students + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(students);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);

        System.out.println("Entries:");
        System.out.println(linkedHashMap);
        System.out.println("The age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
