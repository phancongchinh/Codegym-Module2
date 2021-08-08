import java.util.Scanner;

public class ArrayReversing {
    public static void main(String[] args) {
        int[] array = initAnArray(getSize());
        printArr(array,"original array");
        int[] arrayAfterReversed = reverse(array);
        printArr(arrayAfterReversed, "array after reversed");
    }

    public static int getSize() {
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size is not allowed to exceed 20!");
            }
            if (size <=0) {
                System.out.println("Size is not allowed to be less than or equal to 0!");
            }
        } while (size > 20);
        return size;
    }

    public static int[] initAnArray(int size) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int[] reverse(int[] arr) {
        int first = 0;
        int last = arr.length-1;
        while (first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
        return arr;
    }

    public static void printArr(int[] arr, String arrayName) {
        System.out.print("Elements in "+ arrayName + ": \t ");
        for (int element : arr) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }
}
