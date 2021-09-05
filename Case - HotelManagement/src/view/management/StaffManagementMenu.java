package view.management;

import controller.staff.StaffManagement;
import model.Staff;
import view.IMenuRun;

public class StaffManagementMenu implements IMenuRun {
    private static final StaffManagement EMPLOYEE_MANAGEMENT = StaffManagement.getInstance();

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
        System.out.println("\t 5. Delete information of a staff!");
        System.out.println("\t 6. List staffs by sales!");
        System.out.println("\t 0. Back to Main Menu!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            boolean staffListIsEmpty = EMPLOYEE_MANAGEMENT.getStaffList().size() == 0;
            switch (choice) {
                case 1: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(STAFF_LIST);
                    EMPLOYEE_MANAGEMENT.displayAll();
                    break;
                }
                case 2: {
                    if (staffListIsEmpty) {
                        System.out.println(STAFF_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_STAFF);
                    System.out.print(ENTER_STAFF_ID);
                    String staffId = scanner.nextLine();
                    if (EMPLOYEE_MANAGEMENT.existsStaffId(staffId)) {
                        EMPLOYEE_MANAGEMENT.display(staffId);
                    } else {
                        System.out.println(STAFF_ID_NOT_EXISTED);
                    }
                    break;
                }
                case 3: {
                    System.out.println(ADDING_STAFF);
                    Staff staff = EMPLOYEE_MANAGEMENT.initFromKeyboard();
                    if (staff != null) {
                        EMPLOYEE_MANAGEMENT.add(staff);
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
                    System.out.print(ENTER_STAFF_ID);
                    String staffId = scanner.nextLine();
                    if (EMPLOYEE_MANAGEMENT.existsStaffId(staffId)) {
                        EMPLOYEE_MANAGEMENT.update(staffId);
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
                    System.out.print(ENTER_STAFF_ID);
                    String staffId = scanner.nextLine();
                    if (EMPLOYEE_MANAGEMENT.existsStaffId(staffId)) {
                        EMPLOYEE_MANAGEMENT.remove(staffId);
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
                    System.out.print(ENTER_MINIMUM_REVENUE);
                    Double min = scanner.nextDouble();
                    System.out.print(ENTER_MAXIMUM_REVENUE);
                    Double max = scanner.nextDouble();
                    EMPLOYEE_MANAGEMENT.displayByRevenue(min, max);
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