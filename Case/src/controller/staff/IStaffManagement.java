package controller.staff;

import controller.IGeneralManagement;
import model.personalInformation.PersonalInformation;
import model.staff.Staff;

public interface IStaffManagement extends IGeneralManagement<Staff> {

    PersonalInformation initPersonalInformation();

    Staff initStaff();

    int searchStaffByStaffId(String staffId);

    boolean staffIdExisted(String staffId);

    void displayByRevenue(Double min, Double max);
}
