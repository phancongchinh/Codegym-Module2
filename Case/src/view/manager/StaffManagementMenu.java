package view.manager;

import controller.staff.StaffManagement;
import model.staff.Staff;
import view.IMenu;

public class StaffManagementMenu implements IMenu {
    private static final StaffManagement staffManagement = StaffManagement.getInstance();

    private StaffManagementMenu(){}

    public static StaffManagementMenu getInstance() {
        return StaffManagementMenuHelper.INSTANCE;
    }

    private static class StaffManagementMenuHelper{
        private static final StaffManagementMenu INSTANCE = new StaffManagementMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("STAFF MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all staffs!");
        System.out.println("\t 2. Searching information of staff!");
        System.out.println("\t 3. Add a new staff!");
        System.out.println("\t 4. Edit information of a staff!");
        System.out.println("\t 5. Disable a staff!");
        System.out.println("\t 6. Search for staffs by revenue!");
        System.out.println("\t 0. Back to Main Menu!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() throws NumberFormatException {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean staffListIsEmpty = staffManagement.getStaffList().size() == 0;
            switch (choice) {
                case 1: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(STAFF_LIST);
                    staffManagement.displayAll();
                    break;
                }
                case 2: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_STAFF);
                    System.out.println(ENTER_STAFF_ID);
                    String staffId = scanner.nextLine();
                    if (staffManagement.staffIdExisted(staffId)) {
                        staffManagement.display(staffId);
                    } else {
                        System.out.println(STAFF_ID_NOT_EXISTED);
                    }
                    break;
                }
                case 3: {
                    System.out.println(ADDING_STAFF);
                    Staff staff;
                    try {
                        staff = staffManagement.initStaff();
                    } catch (IllegalArgumentException e) {
                        System.err.println("Input invalid!");
                        System.out.println(STAFF_ADDED_UNSUCCESSFULLY);
                        break;
                    }
                    if (staff != null) {
                        staffManagement.add(staff);
                        System.out.println(STAFF_ADDED);
                    } else {
                        System.out.println(STAFF_ADDED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 4: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(UPDATING_STAFF);
                    System.out.println(ENTER_STAFF_ID);
                    String staffId = scanner.nextLine();
                    if (staffManagement.staffIdExisted(staffId)) {
                        staffManagement.update(staffId);
                        System.out.println(STAFF_UPDATED);
                    } else {
                        System.out.println(STAFF_ID_NOT_EXISTED);
                        System.out.println(STAFF_UPDATED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 5: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DELETING_STAFF);
                    System.out.println(ENTER_STAFF_ID);
                    String staffId = scanner.nextLine();
                    if (staffManagement.staffIdExisted(staffId)) {
                        staffManagement.delete(staffId);
                        System.out.println(STAFF_DELETED);
                    } else {
                        System.out.println(STAFF_ID_NOT_EXISTED);
                        System.out.println(STAFF_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 6: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_STAFF_BY_REVENUE);
                    System.out.println(ENTER_MINIMUM_REVENUE);
                    Double min = scanner.nextDouble();
                    System.out.println(ENTER_MAXIMUM_REVENUE);
                    Double max = scanner.nextDouble();
                    staffManagement.displayByRevenue(min, max);
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

        } while (choice !=0 );
    }
}