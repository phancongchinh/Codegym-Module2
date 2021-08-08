//import java.sql.SQLOutput;
import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        int[] billionaireProperties = initArray();
        int max = findMax(billionaireProperties);
        String indexOfMax = findIndexOfMax(billionaireProperties);

        System.out.println("The maximum value of billionaire's properties is: " + max);
        System.out.println("At element that has index/indices = " + indexOfMax);

    }
    public static int[] initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size:");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i+1) + ": " );
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public static String findIndexOfMax(int[] array) {
        String index = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findMax(array)) {
                index += i + ", ";
            }
        }
        return index;
    }
}
