package view.menuByRole;

import model.Role;
import view.menuWithoutRole.*;

public class AdministratorMenu implements IMenuRanByRole {

    private static final RoomManagementMenu ROOM_MANAGEMENT_MENU = RoomManagementMenu.getInstance();
    private static final InvoiceManagementMenu INVOICE_MANAGEMENT_MENU = InvoiceManagementMenu.getInstance();
    private static final AccountManagementMenu ACCOUNT_MANAGEMENT_MENU = AccountManagementMenu.getInstance();
    private static final StaffManagementMenu STAFF_MANAGEMENT_MENU = StaffManagementMenu.getInstance();
    private static final GuestManagementMenu GUEST_MANAGEMENT_MENU = GuestManagementMenu.getInstance();
    private static final ExportImportMenu EXPORT_IMPORT_MENU = ExportImportMenu.getInstance();

    private AdministratorMenu(){}

    public static AdministratorMenu getInstance() {
        return AdministratorMenuHelper.INSTANCE;
    }

    private static class AdministratorMenuHelper{
        private static final AdministratorMenu INSTANCE = new AdministratorMenu();
    }

    @Override
    public void draw() {
        System.out.println("=============================================================================");
        System.out.println("|   ADMINISTRATOR'S MENU PAGE!                                              |");
        System.out.println("|   1. Room management!                                                     |");
        System.out.println("|   2. Invoice management!                                                  |");
        System.out.println("|   3. Staff management!                                                    |");
        System.out.println("|   4. Account management!                                                  |");
        System.out.println("|   5. Guest management!                                                    |");
        System.out.println("|   6. Export/Import data!                                                  |");
        System.out.println("|   0. Log out!                                                             |");
        System.out.println("=============================================================================");
    }

    @Override
    public void ranByRole(Role role) {
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
        switch (choice) {
            case "1": {
                ROOM_MANAGEMENT_MENU.run();
                break;
            }
            case "2": {
                INVOICE_MANAGEMENT_MENU.run();
                break;
            }
            case "3": {
                STAFF_MANAGEMENT_MENU.run();
                break;
            }
            case "4": {
                ACCOUNT_MANAGEMENT_MENU.run();
                break;
            }
            case "5": {
                GUEST_MANAGEMENT_MENU.run();
                break;
            }
            case "6": {
                EXPORT_IMPORT_MENU.run();
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