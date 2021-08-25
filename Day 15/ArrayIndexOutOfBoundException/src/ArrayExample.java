import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
        Integer[] arr = arrExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter index: ");
        int x = scanner.nextInt();
        try {
            System.out.println("Element arr["+ x +"]: " + arr[x]);
            System.out.println("Done1!");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index Out Of Bound Exception!");
        }
        finally {
            System.out.println("Done!!");
        }

        System.out.println("Done!");
    }

    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Elements: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
}
