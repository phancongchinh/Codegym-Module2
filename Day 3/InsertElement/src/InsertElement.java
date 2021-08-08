import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = initArray();
        System.out.print("Enter the value need to be inserted: ");
        int value = sc.nextInt();
        System.out.print("Enter the index that the value will be inserted to: ");
        int index = sc.nextInt();
        int[] newArray = insert(value, index, array);
        System.out.print("The array after being inserted: \t ");
        showArray(newArray);
    }

    public static int[] initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) +": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static int[] insert(int value, int index, int[] arr) {
        int[] newArray = new int[arr.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i<index) {
                newArray[i] = arr[i];
            } else if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = arr[i-1];
            }
        }
        return newArray;
    }

    public static void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
