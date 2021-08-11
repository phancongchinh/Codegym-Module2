public class Sort {
    public static void sortByName(Guest[] guests) {
        for (int i = 0; i < guests.length; i++) {
            for (int j = i+1; j < guests.length; j++) {
                if (guests[i].getName().compareTo(guests[j].getName()) > 0) {
                    Guest temp = guests[i];
                    guests[i] = guests[j];
                    guests[j] = temp;
                }
            }
        }
    }
}