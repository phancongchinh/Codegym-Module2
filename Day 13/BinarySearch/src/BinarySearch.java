public class BinarySearch {
    static int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static String[] strings = {"Chính", "Đạt", "Hưng", "Long", "Sơn", "Thành", "Vũ", "Ý"};

    public static void main(String[] args) {
        int index;

//        index = binarySearch(integers, 0);
//        System.out.println(index);

        int low = 0;
        int high = strings.length - 1;
        index = recursiveBinarySearch(strings, high, low, "Vũ");
        System.out.println(index);
    }

    static int binarySearch(int[] lists, int value) {
        int low = 0;
        int high = lists.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == lists[mid]) { // take mid value
                return mid;
            } else if (value < lists[mid]) { // left search
                high = mid - 1;
            } else { // right search
                low = mid + 1;
            }
        }
        return -1;
    }

    static int recursiveBinarySearch(String[] strings, int high, int low, String string) {
        int mid = (low + high) / 2;
        if (low <= high) {
            if (string.compareTo(strings[mid]) == 0) {          // take mid value
                return mid;
            } else if (string.compareTo(strings[mid]) > 0) {    // right search
                return recursiveBinarySearch(strings, high, mid + 1, string);
            } else {                                            // left search
                return recursiveBinarySearch(strings, mid - 1, low, string);
            }
        }
        return -1;
    }
}
