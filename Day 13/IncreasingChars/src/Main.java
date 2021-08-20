import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < inputString.length(); i++) {
            LinkedList <Character> list = new LinkedList<>();
            list.add(inputString.charAt(i));
            for (int j = i+1; j < inputString.length(); j++) {
                if (inputString.charAt(j) > list.getLast()) {
                    list.add(inputString.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character c : max) {
            System.out.print(c);
        }
    }
}
