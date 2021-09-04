package controller.staff;

import model.account.Account;
import model.personalInformation.PersonalInformation;
import model.staff.Staff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class StaffManagement implements IStaffManagement {

    private final List<Staff> staffList = new LinkedList<>();

    public List<Staff> getStaffList() {
        return staffList;
    }

    private StaffManagement(){}

    public static StaffManagement getInstance(){
        return StaffManagementHelper.INSTANCE;
    }

    private static class StaffManagementHelper{
        private static final StaffManagement INSTANCE = new StaffManagement();
    }

    @Override
    public void add(Staff staff) {
        staffList.add(staff);
    }

    @Override
    public Staff initStaff() {
        System.out.println(ENTER_STAFF_ID);
        String staffId = scanner.nextLine();
        PersonalInformation personalInformation = initPersonalInformation();
        Account account = generateAccountInformation(staffId,personalInformation.getDateOfBirth());
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        staff.setPersonalInformation(personalInformation);
        staff.setStaffAccountInformation(account);
        return staff;
    }

    private Account generateAccountInformation(String staffId, LocalDate dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Account account = new Account();
        account.setUsername(staffId);
        account.setPassword(dateOfBirth.format(formatter));
        return account;
    }

    @Override
    public PersonalInformation initPersonalInformation() {
        System.out.println(ENTER_PERSONAL_ID);
        String id = scanner.nextLine();
        System.out.println(ENTER_NAME);
        String name = scanner.nextLine();
        System.out.println(ENTER_DATE_OF_BIRTH);
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setId(id);
        personalInformation.setName(name);
        personalInformation.setDateOfBirth(dateOfBirth);
        return personalInformation;
    }

    @Override
    public void display(String staffId) {
        int index = searchStaffByStaffId(staffId);
        System.out.println(staffList.get(index));
    }

    @Override
    public void displayAll() {
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    @Override
    public boolean update(String staffId) {
        int index = searchStaffByStaffId(staffId);
        System.out.println(GATHERING_NEW_INFORMATION);
        Staff newStaff = initStaff();
        if (newStaff == null) {
            return false;
        } else {
            staffList.remove(index);
            staffList.add(index,newStaff);
        }
        return true;
    }

    @Override
    public void delete(String staffId) {
        int index = searchStaffByStaffId(staffId);
        staffList.remove(index);
    }

    @Override
    public int searchStaffByStaffId(String staffId) {
        for (Staff staff : staffList) {
            if (staff.getStaffId().equals(staffId)) {
                return staffList.indexOf(staff);
            }
        }
        return -1;
    }

    @Override
    public boolean staffIdExisted(String staffId) {
        return searchStaffByStaffId(staffId) != -1 ;
    }

    @Override
    public void displayByRevenue(Double min, Double max) {
        int count = 0;
        for (Staff staff : staffList) {
            if (staff.getStaffRevenue() > min && staff.getStaffRevenue() < max) {
                System.out.println(staff);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }
}
