package view.menuByRole;

import model.Role;
import view.menuWithoutRole.InvoiceManagementMenu;

public class StaffMenu implements IMenuRanByRole {

    private static final InvoiceManagementMenu INVOICE_MANAGEMENT_MENU = InvoiceManagementMenu.getInstance();

    private StaffMenu(){}

    public static StaffMenu getInstance() {
        return StaffMenuHelper.INSTANCE;
    }

    private static class StaffMenuHelper{
        private static final StaffMenu INSTANCE = new StaffMenu();
    }

    @Override
    public void draw() {
        System.out.println("=============================================================================");
        System.out.println("STAFF'S MENU PAGE!");
        System.out.println("\t 1. Invoice management!");
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
                INVOICE_MANAGEMENT_MENU.run();
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
