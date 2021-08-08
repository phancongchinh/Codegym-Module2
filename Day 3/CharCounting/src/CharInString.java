import java.util.Scanner;

public class CharInString {
    public static void main(String[] args) {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            String string = initString();
            System.out.print("Enter the character you need to count: ");
            char character = sc.nextLine().charAt(0);
            int count = countCharInString(character, string);
            System.out.println("The number of character '" + character + "' in the string is " + count);
        } while (choice != 0);
    }

    public static String initString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        return sc.nextLine();
    }

    public static int countCharInString(char character, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

}
