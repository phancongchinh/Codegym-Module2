import java.util.Scanner;

public class ArrayMinValue {
    public static void main(String[] args) {
        int[] array = initArray();
        int minValue = findMinValue(array);
        System.out.println("The minimum value of the array is " + minValue);
    }

    public static int[] initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Now enter the elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Element " + (i+1)+ ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int findMinValue(int[] array){
        int minValue = array[0];
        for (int element : array) {
            minValue = Math.min(minValue, element);
        }
        return minValue;
    }

}
