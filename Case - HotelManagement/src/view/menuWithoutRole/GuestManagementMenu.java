package view.menuWithoutRole;

import controller.guest.GuestManagement;
import model.Guest;

public class GuestManagementMenu implements IMenuWithoutRole {

    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();

    private GuestManagementMenu() {
    }

    public static GuestManagementMenu getInstance() {
        return GuestManagementMenuHelper.INSTANCE;
    }

    private static class GuestManagementMenuHelper {
        private static final GuestManagementMenu INSTANCE = new GuestManagementMenu();
    }

    @Override
    public void draw() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("GUEST MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all guests!");
        System.out.println("\t 2. Searching personal information of a guest!");
        System.out.println("\t 0. Back!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        String choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextLine();
            handleChoice(choice);
        } while (!choice.equals("0"));
    }

    @Override
    public void handleChoice(String choice) {
        boolean guestListIsEmpty = GUEST_MANAGEMENT.getGuestMap().size() == 0;
        switch (choice) {
            case "1": {
                if (guestListIsEmpty) {
                    System.out.println(GUEST_LIST_EMPTY);
                } else {
                    System.out.println(GUEST_LIST);
                    GUEST_MANAGEMENT.displayAll();
                }
                break;
            }
            case "2": {
                if (guestListIsEmpty) {
                    System.out.println(GUEST_LIST_EMPTY);
                } else {
                    System.out.println(SEARCH_GUEST);
                    System.out.print(ENTER_GUEST_ID);
                    String guestId = scanner.nextLine();
                    Guest guest = GUEST_MANAGEMENT.findGuest(guestId);
                    if (guest != null) {
                        System.out.println(guest);
                    } else {
                        System.out.println(GUEST_ID_NOT_EXISTED);
                    }
                }
                break;
            }
            case "0": {
                System.out.println(TURN_BACK);
                return;
            }
            default: {
                System.out.println(INVALID_CHOICE);
                break;
            }
        }
    }
}
