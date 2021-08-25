public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        selectionSort(list);
        for (double element : list) {
            System.out.println(element + " ");
        }
    }

    public static void selectionSort(double[] array) {
        int min;

        for (int i = 0; i < array.length-1; i++) {

            //get the minimum value's index in the interval from i+1 to the end of array
            min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[i]){
                    min = j;
                }
            }

            //if array[i] is not the minimum value, swap array[i] with array[min] found above
            if (min != i){
                double temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
}
