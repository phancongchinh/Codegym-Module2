import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static final String NAME = "name";
    private static final String NEW_NAME = "new name";
    private static final String ID = "ID number";
    private static final String NEW_ID = "new ID number";
    private static final String DOB = "date of birth";
    private static final String NEW_DOB = "new date of birth";
    private static final String RLV = "room level";
    private static final String NEW_RLV = "new room level";
    public static GuestRecord[] guestRecords;


    public static void main(String[] args) {
        guestRecords = new GuestRecord[0];
        selectAction();
    }

    public static void drawMainMenu() {
        System.out.println("\n=============================================================================");
        System.out.println("MAIN MENU!");
        System.out.println("\t 1. Check in / Add a new guest!");
        System.out.println("\t 2. Show a guest record (idNumber required)!");
        System.out.println("\t 3. Edit a guest record (idNumber required)!");
        System.out.println("\t 4. Check out / Delete a guest record (idNumber required)!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
    }

    public static void drawEditMenu(int idNumber) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Current guest record: Guest ID: " + idNumber);
        showGuestRecord(idNumber);
        System.out.println("EDIT MENU!");
        System.out.println("\t 1. Change name!");
        System.out.println("\t 2. Change ID number!");
        System.out.println("\t 3. Change date of birth!");
        System.out.println("\t 4. Change date of checking in!");
        System.out.println("\t 5. Change room level!");
        System.out.println("\t 0. Back to MAIN MENU!");
        System.out.println("------------------------------------------------------------------------");
    }

    public static void selectAction() {
        int idNumber;
        drawMainMenu();
        System.out.print("Please select an action: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();
                guestRecords = addGuest();
                sortByName(guestRecords);
                System.out.println("Guest List after checking in / adding the new guest:");
                showGuestRecords();
                selectAction();
                break;
            case 2:
                System.out.println("Guest's ID number is required for showing!");
                idNumber = requestNumber(ID);
                if (!doesIdNumberExist(idNumber)) {
                    System.out.println("ID number does not exist. Action cancelled!");
                    selectAction();
                }
                showGuestRecord(idNumber);
                selectAction();
                break;
            case 3:
                System.out.println("Guest's ID number is required for editing!");
                idNumber = requestNumber(ID);
                if (!doesIdNumberExist(idNumber)) {
                    System.out.println("ID number does not exist. Action cancelled!");
                    selectAction();
                }
                selectEditAction(idNumber);
                break;
            case 4:
                System.out.println("Guest's ID number is required for checking out / deleting!");
                idNumber = requestNumber(ID);
                if (!doesIdNumberExist(idNumber)) {
                    System.out.println("ID number does not exist. Action cancelled!");
                    selectAction();
                }
                checkOut(idNumber);
                guestRecords = deleteGuestRecord(idNumber);
                System.out.println("Guest list after deleting a guest:");
                showGuestRecords();
                selectAction();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid! Action cancelled!");
                selectAction();
        }
    }

    public static Guest requestInformation() {
        Guest guest = new Guest();
        System.out.println("Enter guest information!");
        guest.setName(requestString(NAME));
        int idNumber = requestNumber(ID);
        if (doesIdNumberExist(idNumber)) {
            System.out.println("ID number existed. Action cancelled!");
            selectAction();
        }
        guest.setIdNumber(idNumber);
        sc.nextLine();
        guest.setDateOfBirth(requestDate(DOB));
        return guest;
    }

    public static GuestRecord initGuestRecord() {
        GuestRecord newGuestRecord = new GuestRecord();
        newGuestRecord.setInformation(requestInformation());
        newGuestRecord.setDateOfCheckingIn(LocalDate.now());
        System.out.println("Room available: Premium $1000/night, Deluxe $600/night, Standard $400/night!");
        newGuestRecord.setRoomLevel(requestString(RLV));
        return newGuestRecord;
    }

    public static LocalDate requestDate(String description) {
        System.out.print("Enter " + description + " (dd/mm/yyyy): ");
        String dateString = sc.nextLine();
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6, 10));
        return LocalDate.of(year, month, day);
    }

    public static String requestString(String description) {
        System.out.print("Enter " + description + ": ");
        return sc.nextLine();
    }

    public static int requestNumber(String description) {
        System.out.print("Enter " + description + ": ");
        return sc.nextInt();
    }

    public static void sortByName(GuestRecord[] guestRecords) {
        for (int i = 0; i < guestRecords.length; i++) {
            for (int j = i + 1; j < guestRecords.length; j++) {
                if (guestRecords[i].getInformation().getName().compareTo(guestRecords[j].getInformation().getName()) > 0) {
                    GuestRecord temp = guestRecords[i];
                    guestRecords[i] = guestRecords[j];
                    guestRecords[j] = temp;
                }
            }
        }
    }

    public static GuestRecord[] addGuest() {
        GuestRecord[] newGuestRecords = new GuestRecord[Main.guestRecords.length + 1];
        System.arraycopy(guestRecords, 0, newGuestRecords, 0, guestRecords.length);
        GuestRecord theNewGuest = initGuestRecord();
        newGuestRecords[newGuestRecords.length - 1] = theNewGuest;
        return newGuestRecords;
    }

    public static void showGuestRecord(int idNumber) {
        int index = searchById(idNumber);
        System.out.println(guestRecords[index].toString());
    }

    public static void showGuestRecords() {
        for (int i = 0; i < guestRecords.length; i++) {
            System.out.println("Guest " + (i+1) +": " + guestRecords[i].toString());
        }
    }

    public static void selectEditAction(int idNumber) {
        drawEditMenu(idNumber);
        int index = searchById(idNumber);
        System.out.print("Please select an edit action or back to MAIN MENU: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();
                guestRecords[index].getInformation().setName(requestString(NEW_NAME));
                System.out.println("The guest with ID number " + idNumber + " after editing: ");
                showGuestRecord(idNumber);
                selectEditAction(idNumber);
                break;
            case 2:
                idNumber = requestNumber(NEW_ID);
                guestRecords[index].getInformation().setIdNumber(idNumber);
                System.out.println("The guest with ID number " + idNumber + " after editing: ");
                showGuestRecord(idNumber);
                System.out.println("ID number changed! Back to MAIN MENU required!");
                selectAction();
                break;
            case 3:
                sc.nextLine();
                guestRecords[index].getInformation().setDateOfBirth(requestDate(NEW_DOB));
                System.out.println("The guest with ID number " + idNumber + " after editing: ");
                showGuestRecord(idNumber);
                selectEditAction(idNumber);
                break;
            case 4:
                sc.nextLine();
                guestRecords[index].setDateOfCheckingIn(requestDate(NEW_DOB));
                System.out.println("The guest with ID number " + idNumber + " after editing: ");
                showGuestRecord(idNumber);
                selectEditAction(idNumber);
                break;
            case 5:
                sc.nextLine();
                guestRecords[index].setRoomLevel(requestString(NEW_RLV));
                System.out.println("The guest with ID number " + idNumber + " after editing: ");
                showGuestRecord(idNumber);
                selectEditAction(idNumber);
                break;
            case 0:
                selectAction();
                break;
            default:
                System.out.println("Invalid! Action cancelled!");
                selectEditAction(idNumber);
        }
    }

    public static void checkOut(int idNumber) {
        GuestRecord theGuest = guestRecords[searchById(idNumber)];
        theGuest.setDateOfCheckingOut(LocalDate.now());
        System.out.println("Staying time: " + theGuest.getStayingTime() + " days!");
        System.out.println("Bill: $" + theGuest.getBill());
    }

    public static GuestRecord[] deleteGuestRecord(int idNumber) {
        int index = searchById(idNumber);
        GuestRecord[] newGuestRecords = new GuestRecord[guestRecords.length - 1];
        System.arraycopy(guestRecords, 0, newGuestRecords, 0, index);
        System.arraycopy(guestRecords, index + 1, newGuestRecords, index, newGuestRecords.length - index);
        return newGuestRecords;
    }

    public static int searchById(int idNumber) {
        for (int i = 0; i < guestRecords.length; i++) {
            if (guestRecords[i].getInformation().getIdNumber() == idNumber) {
                return i;
            }
        }
        return -1;
    }

    public static boolean doesIdNumberExist(int idNumber) {
        return searchById(idNumber) != -1;
    }
}
