package controller.staff;

import controller.IGeneralManagement;
import model.Staff;

import java.util.HashSet;

public interface IStaffManagement extends IGeneralManagement<Staff> {

    int indexOfStaff(String staffId);

    boolean existsStaffId(String staffId);

    void displayBySales(Double min, Double max);

    HashSet<String> getRoleEnums();
}