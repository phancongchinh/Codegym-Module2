package view;

import controller.guest.GuestManagement;
import model.Const;
import view.manager.ApartmentManagementMenu;

public class Main implements Const {

    private static final LoginMenu LOGIN_MENU = LoginMenu.getInstance();

    public static void main(String[] args) {
        LOGIN_MENU.run();
    }

    public static class GuestManagementMenu implements IMenu {
        private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();

        private GuestManagementMenu(){}

        public static GuestManagementMenu getInstance(){
            return GuestManagementHelper.INSTANCE;
        }

        private static class GuestManagementHelper {
            private static final GuestManagementMenu INSTANCE = new GuestManagementMenu();
        }

        @Override
        public void draw() {

        }

        @Override
        public void run() {

        }
    }

    public static class StaffMenu implements IMenu {

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
}