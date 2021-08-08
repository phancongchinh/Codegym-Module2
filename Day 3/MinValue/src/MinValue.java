import java.util.Scanner;

public class MinValue {
    public static void main(String[] args) {
        int[] array = initArray();
        System.out.println("The minimum value of the array is " + findMinValue(array));
    }
    public static int[] initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i+1) +": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int findMinValue(int[] array) {
        int minValue = array[0];
        for (int element : array) {
            minValue = Math.min(minValue, element);
        }
        return minValue;
    }

}
