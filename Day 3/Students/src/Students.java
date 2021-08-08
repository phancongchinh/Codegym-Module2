import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        // Assume that all the names are different!
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to find: ");
        String name = sc.nextLine();
        if (find(name, students) == -1) {
            System.out.println("Not found " + name + " in the list!");
        } else {
            System.out.println("Position of " + name + "in the list: index = " + find(name, students));
        }
    }

    public static int find(String name, String[] array) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (name.equals(array[i])) {
                index = i;
            }
        }
        return index;
    }
}
