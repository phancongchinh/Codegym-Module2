package controller.staff;

import controller.person.PersonManagement;
import controller.account.AccountManagement;

import model.PersonalInformation;
import model.Account;
import model.Role;
import model.Staff;

import java.util.LinkedList;
import java.util.List;

public class StaffManagement extends PersonManagement implements IStaffManagement {

    private static final AccountManagement ACCOUNT_MANAGEMENT = AccountManagement.getInstance();

    private static final List<Staff> STAFF_LIST = new LinkedList<>();

    public List<Staff> getStaffList() {
        return STAFF_LIST;
    }

    private StaffManagement() {
    }

    public static StaffManagement getInstance() {
        return StaffManagementHelper.INSTANCE;
    }

    private static class StaffManagementHelper {
        private static final StaffManagement INSTANCE = new StaffManagement();
    }

    @Override
    public void add(Staff staff) {
        STAFF_LIST.add(staff);
        ACCOUNT_MANAGEMENT.add(staff.getAccount()); // add the staff's account to account list
    }

    @Override
    public Staff initFromKeyboard() {
        PersonalInformation personalInformation = initFromKeyBoard();
        if (personalInformation == null) {
            return null;
        }
        System.out.print(ENTER_STAFF_ID);
        String staffId = scanner.nextLine();
        if (existsStaffId(staffId)) {
            System.out.println(STAFF_ID_EXISTED);
            return null;
        }

        // Generate an account automatically for the new staff
        Account account = ACCOUNT_MANAGEMENT.generateAccountAutomatically(staffId, personalInformation.getDateOfBirth());
        return new Staff(personalInformation, staffId, account, Role.STAFF, 0);
    }

    @Override
    public void display(String staffId) {
        int index = indexOfInvoice(staffId);
        System.out.println(STAFF_LIST.get(index));
    }

    @Override
    public void displayAll() {
        for (Staff staff : STAFF_LIST) {
            System.out.println(staff);
        }
    }

    @Override
    public boolean update(String staffId) {
        int index = indexOfInvoice(staffId);

        System.out.println(GATHERING_NEW_INFORMATION);
        Staff newStaff = initFromKeyboard(); // account is also initialized
        if (newStaff == null) {
            return false;
        } else {
            remove(staffId); // account is also removed
            STAFF_LIST.add(index, newStaff);
        }
        return true;
    }

    @Override
    public void remove(String staffId) {
        int index = indexOfInvoice(staffId);
        Staff removedStaff = STAFF_LIST.remove(index);
        // Also remove account from account list
        ACCOUNT_MANAGEMENT.getAccountList().remove(removedStaff.getAccount());
    }

    @Override
    public int indexOfInvoice(String staffId) {
        for (Staff staff : STAFF_LIST) {
            if (staff.getStaffId().equals(staffId)) {
                return STAFF_LIST.indexOf(staff);
            }
        }
        return -1;
    }

    @Override
    public boolean existsStaffId(String staffId) {
        return indexOfInvoice(staffId) != -1;
    }

    @Override
    public void displayByRevenue(Double min, Double max) {
        int count = 0;
        for (Staff staff : STAFF_LIST) {
            if (staff.getSales() > min && staff.getSales() < max) {
                System.out.println(staff);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }
}
