package controller.staff;

import controller.personalInformation.PersonalInformationManagement;
import controller.account.AccountManagement;

import model.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class StaffManagement implements IStaffManagement {

    private static final AccountManagement ACCOUNT_MANAGEMENT = AccountManagement.getInstance();
    private static final PersonalInformationManagement PERSONAL_INFORMATION_MANAGEMENT = PersonalInformationManagement.getInstance();

    private static final List<Staff> STAFF_LIST = new LinkedList<>();

    public List<Staff> getStaffList() {
        return STAFF_LIST;
    }

    static {
        STAFF_LIST.add(new Staff("ID0001","Name1", LocalDate.parse("2000-01-01"),"Staff0001", Role.MANAGER,0.0));
        STAFF_LIST.add(new Staff("ID0002","Name2", LocalDate.parse("2000-01-02"),"Staff0002",Role.STAFF,0.0));
        STAFF_LIST.add(new Staff("ID0003","Name3", LocalDate.parse("2000-01-03"),"Staff0003",Role.STAFF,0.0));
        STAFF_LIST.add(new Staff("ID0004","Name4", LocalDate.parse("2000-01-04"),"Staff0004",Role.STAFF,0.0));
        STAFF_LIST.add(new Staff("ID0005","Name5", LocalDate.parse("2000-01-05"),"Staff0005",Role.STAFF,0.0));
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
        PersonalInformation personalInformation = PERSONAL_INFORMATION_MANAGEMENT.initInformationForA(STAFF);
        if (personalInformation == null) {
            return null;
        }
        System.out.print(ENTER_STAFF_ID);
        String staffId = scanner.nextLine();
        if (existsStaffId(staffId)) {
            System.out.println(STAFF_ID_EXISTED);
            return null;
        }
        System.out.print(ENTER_STAFF_ROLE);
        String inputRole = scanner.nextLine().toUpperCase();
        if (!getRoleEnums().contains(inputRole)) {
            return null;
        }
        Role role = Role.valueOf(inputRole);

        // Generate an account automatically for the new staff
        Account account = ACCOUNT_MANAGEMENT.generateAccountAutomatically(role, staffId, personalInformation.getDateOfBirth());
        return new Staff(personalInformation, staffId, role, account, 0.0);
    }

    @Override
    public void display(String staffId) {
        int index = indexOfStaff(staffId);
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
        int index = indexOfStaff(staffId);
        System.out.println(GATHERING_NEW_INFORMATION_FOR_UPDATING);
        Staff newStaff = initFromKeyboard(); // account is also initialized
        if (newStaff == null) {
            return false;
        } else {
            STAFF_LIST.set(index, newStaff);
            ACCOUNT_MANAGEMENT.getAccountList().set(index, newStaff.getAccount());
        }
        return true;
    }

    @Override
    public void remove(String staffId) {
        int index = indexOfStaff(staffId);
        Staff removedStaff = STAFF_LIST.remove(index);
        // Also remove account from account list
        ACCOUNT_MANAGEMENT.getAccountList().remove(removedStaff.getAccount());
    }

    @Override
    public int indexOfStaff(String staffId) {
        for (Staff staff : STAFF_LIST) {
            if (staff.getStaffId().equals(staffId)) {
                return STAFF_LIST.indexOf(staff);
            }
        }
        return -1;
    }

    @Override
    public boolean existsStaffId(String staffId) {
        return indexOfStaff(staffId) != -1;
    }

    @Override
    public void displayBySales(Double min, Double max) {
        int count = 0;
        for (Staff staff : STAFF_LIST) {
            if (staff.getSales() >= min && staff.getSales() <= max) {
                System.out.println(staff);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }

    @Override
    public HashSet<String> getRoleEnums() {
        HashSet<String> values = new HashSet<>();
        for (Role role : Role.values()) {
            values.add(role.name());
        }
        return values;
    }
}
