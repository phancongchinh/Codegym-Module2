import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.LocalDate;

public class Hotel {

    static final String DOB = "day of birth:";
    static final String DCI = "day of checking in:";
    static final String DCO = "day of checking out:";

    static Scanner sc = new Scanner(System.in);
    static Guest[] guests = new Guest[0];

    public static void main(String[] args) {
        selectInMainMenu();
    }

    public static void selectInMainMenu() {
        int choice;
        do {
            drawMainMenu();
            choice = sc.nextInt();
            int idNumber;
            switch (choice) {
                case 1:
                    System.out.println("Adding a new guest!");
                    guests = addGuest(guests);
                    Sort.sortByName(guests);
                    System.out.println("Guest list after adding a new guest:");
                    showGuestList(guests);
                    break;
                case 2:
                    System.out.println("Enter guest's ID number to display guest's information!");
                    showGuest(requestIdNumber(), guests);
                    break;
                case 3:
                    System.out.println("Enter guest's ID number to edit guest's information!");
                    idNumber = requestIdNumber();
                    editGuest(idNumber, guests);
                    break;
                case 4:
                    System.out.println("Enter guest's ID number to delete guest information!");
                    guests = deleteGuest(requestIdNumber(), guests);
                    System.out.println("Guest list after deleting a guest:");
                    showGuestList(guests);
                    break;
                case 5:
                    idNumber = requestIdNumber();
                    Guest theGuest = guests[searchById(idNumber, guests)];
                    System.out.println(theGuest.toString());
                    long stayingTime = ChronoUnit.DAYS.between(theGuest.getDateOfCheckingIn(), theGuest.getDateOfCheckingOut());
                    System.out.println("Staying time: " + stayingTime + " days.");
                    System.out.println("Money: $" + stayingTime * theGuest.getRoomPrice() + ".");
                    guests = deleteGuest(idNumber, guests);
                    if (guests.length == 0) {
                        System.out.println("There's no guest in the hotel!");
                    } else {
                        System.out.println("Guest list after deleting the guest that have just checked out:");
                        showGuestList(guests);
                    }

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

    public static LocalDate requestDate(String dateDescription) {
        System.out.print("Enter " + dateDescription + " (dd/mm/yyyy): ");
        String dateString = sc.next();
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6, 10));
        return LocalDate.of(year, month, day);
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
        if (searchById(newId, guests) != -1) {
            System.out.println("Id number existed! Add guest canceled!");
            return guests;
        }
        newGuests[guests.length].setIdNumber(newId);
        sc.nextLine();
        newGuests[guests.length].setDateOfCheckingIn(requestDate(DCI));
        newGuests[guests.length].setDateOfCheckingOut(requestDate(DCO));
        newGuests[guests.length].setRoomLevel(requestRoomLevel());
        return newGuests;
    }

    public static void showGuest(int idNum, Guest[] guests) {
        String guestToString;
        int index = searchById(idNum, guests);
        guestToString = (index == -1) ? "Guest not found!" : guests[index].toString();
        System.out.println(guestToString);
    }

    public static int searchById(int idNum, Guest[] guests) {
        int index = -1;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i].getIdNumber() == idNum) {
                index = i;
            }
        }
        return index;
    }

    public static void editGuest(int idNum, Guest[] guests) {
        int index = searchById(idNum, guests);
        if (index == -1) {
            System.out.println("Guest not found!");
        } else {
            int choice;
            do {
                drawEditMenu();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        editName(index, requestName());
                        break;
                    case 2:
                        editIdNumber(index, requestIdNumber());
                        break;
                    case 3:
                        editDate(index, DOB, requestDate(DOB));
                        break;
                    case 4:
                        editDate(index, DCI, requestDate(DCI));
                        break;
                    case 5:
                        editDate(index, DCO, requestDate(DCO));
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
            case DCI:
                guests[index].setDateOfCheckingIn(newLocalDate);
                break;
            case DCO:
                guests[index].setDateOfCheckingOut(newLocalDate);
                break;
        }
    }

    public static Guest[] deleteGuest(int idNum, Guest[] guests) {
        Guest[] newGuests = new Guest[guests.length - 1];
        int index = searchById(idNum, guests);
        if (index == -1) {
            System.out.println("Guest not found!");
            return guests;
        } else {
            System.arraycopy(guests, 0, newGuests, 0, index);
            System.arraycopy(guests, index + 1, newGuests, index, guests.length - index - 1);
            return newGuests;
        }
    }
}