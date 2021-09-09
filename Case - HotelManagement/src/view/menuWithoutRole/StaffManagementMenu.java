package view.menuWithoutRole;

import controller.staff.StaffManagement;
import model.Staff;

public class StaffManagementMenu implements IMenuWithoutRole {
    private static final StaffManagement STAFF_MANAGEMENT = StaffManagement.getInstance();

    private StaffManagementMenu(){}

    public static StaffManagementMenu getInstance() {
        return StaffManagementMenuHelper.INSTANCE;
    }

    private static class StaffManagementMenuHelper{
        private static final StaffManagementMenu INSTANCE = new StaffManagementMenu();
    }

    @Override
    public void draw() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("STAFF MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all staffs!");
        System.out.println("\t 2. Searching information of staff!");
        System.out.println("\t 3. Add a new staff!");
        System.out.println("\t 4. Edit information of a staff!");
        System.out.println("\t 5. Delete information of a staff!");
        System.out.println("\t 6. List staffs by sales!");
        System.out.println("\t 0. Back to Main Menu!");
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
        boolean empty = STAFF_MANAGEMENT.getStaffList().size() == 0;
        switch (choice) {
            case "1": {
                if (isStaffList(empty)) break;
                System.out.println(STAFF_LIST);
                STAFF_MANAGEMENT.displayAll();
                break;
            }
            case "2": {
                if (isStaffList(empty)) break;
                System.out.println(SEARCH_STAFF);
                System.out.print(ENTER_STAFF_ID);
                String staffId = scanner.nextLine();
                if (STAFF_MANAGEMENT.existsStaffId(staffId)) {
                    STAFF_MANAGEMENT.display(staffId);
                } else {
                    System.out.println(STAFF_ID_NOT_EXISTED);
                }
                break;
            }
            case "3": {
                System.out.println(ADDING_STAFF);
                Staff staff = STAFF_MANAGEMENT.initFromKeyboard();
                if (STAFF_MANAGEMENT.add(staff)) {
                    System.out.println(STAFF_ADDED);
                } else {
                    System.out.println(STAFF_ADDED_UNSUCCESSFULLY);
                }
                break;
            }
            case "4": {
                if (isStaffList(empty)) break;
                System.out.println(UPDATING_STAFF);
                System.out.print(ENTER_STAFF_ID);
                String staffId = scanner.nextLine();
                if (STAFF_MANAGEMENT.existsStaffId(staffId)) {
                    if (STAFF_MANAGEMENT.update(staffId)) {
                        System.out.println(STAFF_UPDATED);
                    } else {
                        System.out.println(STAFF_UPDATED_UNSUCCESSFULLY);
                    }
                } else {
                    System.out.println(STAFF_ID_NOT_EXISTED);
                }
                break;
            }
            case "5": {
                if (isStaffList(empty)) break;
                System.out.println(DELETING_STAFF);
                System.out.print(ENTER_STAFF_ID);
                String staffId = scanner.nextLine();
                if (STAFF_MANAGEMENT.existsStaffId(staffId)) {
                    STAFF_MANAGEMENT.remove(staffId);
                    System.out.println(STAFF_DELETED);
                } else {
                    System.out.println(STAFF_ID_NOT_EXISTED);
                }
                break;
            }
            case "6": {
                if (isStaffList(empty)) break;
                System.out.println(SEARCH_STAFF_BY_SALES);
                System.out.print(ENTER_MINIMUM_SALES);
                double min = scanner.nextDouble();
                while (Double.isNaN(min)) {
                    System.out.println(EXCEPTION_ILLEGAL_ARGUMENT);
                    System.out.println(ENTER_MINIMUM_SALES);
                    min = scanner.nextDouble();
                }

                System.out.print(ENTER_MAXIMUM_SALES);
                double max = scanner.nextDouble();
                while (Double.isNaN(max)) {
                    System.out.println(EXCEPTION_ILLEGAL_ARGUMENT);
                    System.out.println(ENTER_MAXIMUM_SALES);
                    max = scanner.nextDouble();
                }
                STAFF_MANAGEMENT.displayBySales(min, max);
                scanner.nextLine();
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

    private boolean isStaffList(boolean empty) {
        if (empty) {
            System.out.println(STAFF_LIST_EMPTY);
            return true;
        }
        return false;
    }
}