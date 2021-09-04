package view.staff;

import view.IMenu;
import view.manager.ApartmentManagementMenu;

public class StaffMenu implements IMenu {

    private static final ApartmentManagementMenu APARTMENT_MANAGEMENT_MENU = ApartmentManagementMenu.getInstance();
    private static final GuestManagementMenu GUEST_MANAGEMENT_MENU = GuestManagementMenu.getInstance();

    private StaffMenu(){}

    public static StaffMenu getInstance() {
        return StaffMenuHelper.INSTANCE;
    }
    
    private static class StaffMenuHelper{
        private static final StaffMenu INSTANCE = new StaffMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n=============================================================================");
        System.out.println("STAFF MENU!");
        System.out.println("\t 1. Apartment management!");
        System.out.println("\t 2. Guest management!");
        System.out.println("\t 0. Exit!");
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
                    APARTMENT_MANAGEMENT_MENU.run();
                    break;
                }
                case 2: {
                    GUEST_MANAGEMENT_MENU.run();
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
