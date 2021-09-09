package controller.staff;

import controller.IGeneralManagement;
import model.Staff;

public interface IStaffManagement extends IGeneralManagement<Staff> {

    int indexOfStaff(String staffId);

    boolean existsStaffId(String staffId);

    boolean existsPersonalId(String id);

    void displayBySales(Double min, Double max);

    boolean isRoleValid(String string);
}