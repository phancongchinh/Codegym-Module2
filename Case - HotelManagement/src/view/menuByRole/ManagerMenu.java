package view.menuByRole;

import model.Role;
import view.menuWithoutRole.GuestManagementMenu;
import view.menuWithoutRole.InvoiceManagementMenu;
import view.menuWithoutRole.RoomManagementMenu;

public class ManagerMenu implements IMenuRanByRole {
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
        System.out.println("=============================================================================");
        System.out.println("MANAGER'S MENU PAGE!");
        System.out.println("\t 1. Room management!");
        System.out.println("\t 2. Invoice management!");
        System.out.println("\t 3. Guest management!");
        System.out.println("\t 0. Log out!");
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
                GUEST_MANAGEMENT_MENU.run();
                break;
            }
            case "0": {
                System.out.println(LOGGED_OUT);
                return;
            }
            default: {
                System.out.println(INVALID_CHOICE);
                break;
            }
        }
    }
}
