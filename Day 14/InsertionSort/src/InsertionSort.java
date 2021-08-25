public class InsertionSort {
    static final int[] list = {1, 4, 2, 6, 4, 5, 7, 9, 3};

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println("\nThe list after sorted:");
        for (int element : list) {
            System.out.print(element + " ");
        }
    }

    private static void insertionSort(int[] list) {
        int temp;
        int index;
        for (int i = 1; i < list.length; i++) {
            temp = list[i];
            index = i;
            while (index > 0 && temp < list[index - 1]) {
                list[index] = list[index-1];
                index--;
            }
            list[index] = temp;
            System.out.print("\nThe list after " + i +"' sort: ");
            for (int element : list) {
                System.out.print(element + " ");
            }
        }
    }
}