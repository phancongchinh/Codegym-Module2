package view.manager;

import view.IMenu;

public class ManagerMenu implements IMenu {
    private static final ApartmentManagementMenu APARTMENT_MANAGEMENT_MENU = ApartmentManagementMenu.getInstance();
    private static final StaffManagementMenu STAFF_MANAGEMENT_MENU = StaffManagementMenu.getInstance();
    private static final InvoiceManagementMenu INVOICE_MANAGEMENT_MENU = InvoiceManagementMenu.getInstance();

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
        System.out.println("MANAGER MENU!");
        System.out.println("\t 1. Apartment management!");
        System.out.println("\t 2. Staff management!");
        System.out.println("\t 3. Guest management!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.println(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    APARTMENT_MANAGEMENT_MENU.run();
                    break;
                }
                case 2: {
                    STAFF_MANAGEMENT_MENU.run();
                    break;
                }
                case 3: {
                    INVOICE_MANAGEMENT_MENU.run();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    break;
                }
            }
        } while (choice != 0);
    }
}
