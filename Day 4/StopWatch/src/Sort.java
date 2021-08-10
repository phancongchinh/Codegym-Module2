import java.util.Scanner;

public class Sort {
    public int[] initArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array: "); //100,000 numbers
        int size = sc.nextInt();
        int[] array = new int[size];

        System.out.println("Initializing " + size + " elements randomly!");
        for (int element : array) {
            element = (int) (Math.random() * 99999);
        }
        return array;
    }

    public void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
