package view.administrator;

import view.IMenuRun;
import view.management.*;

public class AdministratorMenu implements IMenuRun {

    private static final RoomManagementMenu ROOM_MANAGEMENT_MENU = RoomManagementMenu.getInstance();
    private static final InvoiceManagementMenu INVOICE_MANAGEMENT_MENU = InvoiceManagementMenu.getInstance();
    private static final AccountManagementMenu ACCOUNT_MANAGEMENT_MENU = AccountManagementMenu.getInstance();
    private static final StaffManagementMenu STAFF_MANAGEMENT_MENU = StaffManagementMenu.getInstance();
    private static final GuestManagementMenu GUEST_MANAGEMENT_MENU = GuestManagementMenu.getInstance();

    private AdministratorMenu(){}

    public static AdministratorMenu getInstance() {
        return AdministratorMenuHelper.INSTANCE;
    }

    private static class AdministratorMenuHelper{
        private static final AdministratorMenu INSTANCE = new AdministratorMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n=============================================================================");
        System.out.println("ADMINISTRATOR'S MENU PAGE!");
        System.out.println("\t 1. Room management!");
        System.out.println("\t 2. Invoice management!");
        System.out.println("\t 3. Account management!");
        System.out.println("\t 4. Staff management!");
        System.out.println("\t 5. Guest management!");
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
                    ACCOUNT_MANAGEMENT_MENU.run();
                    break;
                }
                case 4: {
                    STAFF_MANAGEMENT_MENU.run();
                    break;
                }
                case 5: {
                    GUEST_MANAGEMENT_MENU.run();
                    break;
                }
                case 0: {
                    System.out.println(TURN_BACK);
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
