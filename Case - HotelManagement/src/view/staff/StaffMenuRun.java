package view.staff;

import view.IMenuRun;
import view.management.InvoiceManagementMenu;

public class StaffMenuRun implements IMenuRun {

    private static final InvoiceManagementMenu INVOICE_MANAGEMENT_MENU = InvoiceManagementMenu.getInstance();

    private StaffMenuRun(){}

    public static StaffMenuRun getInstance() {
        return StaffMenuHelper.INSTANCE;
    }

    private static class StaffMenuHelper{
        private static final StaffMenuRun INSTANCE = new StaffMenuRun();
    }

    @Override
    public void draw() {
        System.out.println("\n=============================================================================");
        System.out.println("STAFF'S MENU PAGE!");
        System.out.println("\t 1. Invoice management!");
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
                    INVOICE_MANAGEMENT_MENU.run();
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
