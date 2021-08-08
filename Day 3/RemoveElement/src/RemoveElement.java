import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 8, 7, 6, 7, 6, 7, 6, 7, 6};
        System.out.print("Enter the value that needs to be deleted: ");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        if (countValue(value,array) == 0) {
            System.out.println("There's no element needs to delete!");
        } else {
            int[] arrayAfterRemoved = removeElement(value,array);
            System.out.print("The array after being deleted: ");
            showArray(arrayAfterRemoved);
        }
    }

    public static int countValue(int value, int[] array) {
        int count = 0;
        for (int element : array) {
            count = (element == value) ? count + 1 : count;
        }
        return count;
    }

    public static int[] removeElement(int value, int[] array) {
        int[] arrayAfterRemoved = new int[array.length - countValue(value, array)];
        int count = 0;
        for (int i = 0; i < arrayAfterRemoved.length; i++) {
            count = (array[i + count] == value) ? count + 1 : count;
            arrayAfterRemoved[i] = array[(i + count)];
        }
        return arrayAfterRemoved;
    }

    public static void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
