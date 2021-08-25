import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.println("Your input list: ");
        for (int j : list) {
            System.out.print(j + "\t");
        }

        bubbleSortByStep(list);

        System.out.println("\nYour input list after sort: ");
        for (int j : list) {
            System.out.print(j + "\t");
        }
    }
    //codes below here

    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int i = 0; i < list.length - 1 && needNextPass ; i++) {
            needNextPass = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    needNextPass = true;
                }
            }
            if (!needNextPass) {
                System.out.println("\nArray may be sorted and next pass not needed");
                break;
            }

            System.out.print("List after the  " + (i+1) + "' sort: ");
            for (int k : list) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    }
}