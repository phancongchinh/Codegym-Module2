import java.util.LinkedList;
import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Turn the string into characters manage by a linked list
        LinkedList<Character> characters = new LinkedList<>();
        for (int i = 0; i < inputString.length(); i++) {
            characters.add(inputString.charAt(i));
        }

        int countMax = 0;
        Character theChar = '0';
        Character charMax = theChar;

        while (characters.size() != 0) {
            // remove the first character, count it as 1
            theChar = characters.removeFirst();
            int count = 1;

            // if the character still remains in the list, remove it and increase count by 1
            // everytime count increased, check if count is greater than max or not
            while (characters.contains(theChar)){
                characters.remove(theChar);
                count++;
                if (count > countMax) {
                    countMax = count;
                    charMax = theChar;
                }
            }
        }
        System.out.print(charMax + ": " + countMax);
    }
}