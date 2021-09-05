package view.manager;

import view.IMenuRun;
import view.management.GuestManagementMenu;
import view.management.InvoiceManagementMenu;
import view.management.RoomManagementMenu;

public class ManagerMenu implements IMenuRun {
    private static final RoomManagementMenu ROOM_MANAGEMENT_MENU = RoomManagementMenu.getInstance();
    private static final InvoiceManagementMenu INVOICE_MANAGEMENT_MENU = InvoiceManagementMenu.getInstance();
    private static final GuestManagementMenu GUEST_MANAGEMENT_MENU = GuestManagementMenu.getInstance();

    private ManagerMenu(){}

    public static ManagerMenu getInstance() {
        return ManagerMenuHelper.INSTANCE;
    }

    private static class ManagerMenuHelper{
        private static final ManagerMenu INSTANCE = new ManagerMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n=============================================================================");
        System.out.println("MANAGER'S MENU PAGE!");
        System.out.println("\t 1. Room management!");
        System.out.println("\t 2. Invoice management!");
        System.out.println("\t 3. Guest management!");
        System.out.println("\t 0. Log out!");
        System.out.println("=============================================================================");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    ROOM_MANAGEMENT_MENU.run();
                    break;
                }
                case 2: {
                    INVOICE_MANAGEMENT_MENU.run();
                    break;
                }
                case 3: {
                    GUEST_MANAGEMENT_MENU.run();
                    break;
                }
                case 0: {
                    System.out.println(LOGGED_OUT);
                    return;
                }
                default: {
                    System.out.println(INVALID_CHOICE);
                    break;
                }
            }
        } while (choice != 0);
    }
}
