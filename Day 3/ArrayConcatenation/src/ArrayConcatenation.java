import java.util.Scanner;

public class ArrayConcatenation {
    public static void main(String[] args) {
        System.out.println("Initialize the first array:");
        int[] array1 = initArray();
        System.out.println("Initialize the second array:");
        int[] array2 = initArray();
        int[] array3 = arrayConcatenate(array1,array2);
        System.out.println("The concatenated array is: ");
        showArray(array3);
    }
    public static int[] initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int[] arrayConcatenate(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i];
        }
        for (int i = array1.length; i < array.length; i++) {
            array[i] = array2[i - array1.length];
        }
        return array;
    }
    public static void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
