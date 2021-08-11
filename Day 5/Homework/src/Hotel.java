import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.LocalDate;

public class Hotel {
    static final String DOB = "day of birth";
    static final String DOCI = "day of checking in";
    static final String DOCO = "day of checking out";
    static Scanner sc = new Scanner(System.in);
    static Guest[] guests = new Guest[0];

    public static void main(String[] args) {
        selectInMainMenu();
    }

    public static void selectInMainMenu() {
        int choice = -1;
        do {
            drawMainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    guests = addGuest(guests);
                    Sort.sortByName(guests);
                    System.out.println("Guest list after adding a new guest:");
                    showGuestList(guests);
                    break;
                case 2:
                    showGuest(requestIdNumber(), guests);
                    break;
                case 3:
                    editGuest(requestIdNumber(), guests);
                    Sort.sortByName(guests);
                    System.out.println("Guest list after editing:");
                    showGuestList(guests);
                    break;
                case 4:
                    guests = deleteGuest(requestIdNumber(), guests);
                    System.out.println("Guest list after deleting a guest:");
                    showGuestList(guests);
                    break;
                case 5:
                    int idNumber = requestIdNumber();
                    showGuest(idNumber,guests);
                    int index = searchGuest(idNumber,guests);
                    Guest theGuest = guests[index];
                    long stayingTime = ChronoUnit.DAYS.between(theGuest.getDateOfCheckingIn(),theGuest.getDateOfCheckingOut());
                    System.out.println("Staying time: " + stayingTime + " days.");
                    System.out.println("Money = " + stayingTime * theGuest.getRoomPrice());
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }

    public static void drawMainMenu() {
        System.out.println("Please select!");
        System.out.println("1. Add a guest!");
        System.out.println("2. Show information of a guest!");
        System.out.println("3. Edit information of a guest!");
        System.out.println("4. Delete a guest!");
        System.out.println("5. Check out!");
        System.out.println("0. Exit!");
    }

    public static String requestName() {
        sc.nextLine();
        System.out.print("Enter name: ");
        return sc.nextLine();
    }

    public static int requestIdNumber() {
        System.out.print("Enter ID: ");
        return sc.nextInt();
    }

    public static boolean isIdNumberExisted(int newId) {
        for (Guest guest : guests) {
            if (guest.getIdNumber() == newId) {
                return true;
            }
        }
        return false;
    }

    public static LocalDate requestDate(String dateDescription) {
        sc.nextLine();
        System.out.println("Enter " + dateDescription + " (yyyy/mm/dd):");
        String dateString = sc.nextLine();
        int year = Integer.parseInt(dateString.substring(0,4));
        int month = Integer.parseInt(dateString.substring(5,7));
        int day = Integer.parseInt(dateString.substring(8,10));
        return LocalDate.of(year,month,day);
    }

    public static char requestRoomLevel() {
        System.out.print("Enter room level: ");
        return sc.next().charAt(0);
    }

    public static void showGuestList(Guest[] guests) {
        for (Guest element : guests) {
            System.out.println(element);
        }
    }

    public static Guest[] addGuest(Guest[] guests) {
        Guest[] newGuests = new Guest[guests.length + 1];
        System.arraycopy(guests, 0, newGuests, 0, guests.length);
        newGuests[guests.length] = new Guest();
        newGuests[guests.length].setName(requestName());
        //Check if the entered ID number is existed or not!
        int newId = requestIdNumber();
        if (isIdNumberExisted(newId)) {
            System.out.println("Id number existed! Add guest canceled!");
            return guests;
        }
        newGuests[guests.length].setIdNumber(newId);
        newGuests[guests.length].setDateOfCheckingIn(requestDate(DOCI));
        newGuests[guests.length].setDateOfCheckingOut(requestDate(DOCO));
        newGuests[guests.length].setRoomLevel(requestRoomLevel());
        return newGuests;
    }

    public static void showGuest(int idNum, Guest[] guests) {
        String guestToString;
        int searchById = searchGuest(idNum, guests);
        guestToString = (searchById == -1) ? "Guest not found!" : guests[searchById].toString();
        System.out.println(guestToString);
    }

    public static int searchGuest(int idNum, Guest[] guests) {
        int index = -1;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i].getIdNumber() == idNum) {
                index = i;
            }
        }
        return index;
    }

    public static void editGuest(int idNum, Guest[] guests) {
        int index = searchGuest(idNum, guests);
        if (index == -1) {
            System.out.println("Guest not found!");
        } else {
            int choice = -1;
            do {
                drawEditMenu();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        editName(index,requestName());
                        break;
                    case 2:
                        editIdNumber(index,requestIdNumber());
                        break;
                    case 3:
                        editDate(index,DOB,requestDate(DOB));
                        break;
                    case 4:
                        editDate(index,DOCI,requestDate(DOCI));
                        break;
                    case 5:
                        editDate(index,DOCO,requestDate(DOCO));
                        break;
                    case 0:
                        selectInMainMenu();
                        break;
                }
            } while (choice != 0);
        }
    }

    public static void drawEditMenu() {
        System.out.println("1. Edit name!");
        System.out.println("2. Edit ID number!");
        System.out.println("3. Edit date of birth!");
        System.out.println("4. Edit date of checking in!");
        System.out.println("5. Edit date of checking out!");
        System.out.println("0. Back to main Menu!");
    }

    public static void editName(int index, String newName) {
        guests[index].setName(newName);
    }

    public static void editIdNumber(int index, int newIdNum) {
        guests[index].setIdNumber(newIdNum);
    }

    public static void editDate(int index, String dateDescription, LocalDate newLocalDate) {
        switch (dateDescription) {
            case DOB:
                guests[index].setDateOfBirth(newLocalDate);
                break;
            case DOCI:
                guests[index].setDateOfCheckingIn(newLocalDate);
                break;
            case DOCO:
                guests[index].setDateOfCheckingOut(newLocalDate);
                break;
        }
    }

    public static Guest[] deleteGuest(int idNum, Guest[] guests) {
        Guest[] newGuests = new Guest[guests.length - 1];
        int searchById = searchGuest(idNum, guests);
        if (searchById == -1) {
            System.out.println("Guest not found!");
            newGuests = guests;
        } else {
            for (int i = 0; i < searchById; i++) {
                newGuests[i] = guests[i];
            }
            for (int i = searchById; i < newGuests.length; i++) {
                newGuests[i] = guests[i + 1];
            }
        }
        return newGuests;
    }
}
