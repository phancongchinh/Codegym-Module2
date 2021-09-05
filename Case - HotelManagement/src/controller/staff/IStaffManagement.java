package controller.staff;

import controller.IGeneralManagement;
import model.Staff;

public interface IStaffManagement extends IGeneralManagement<Staff> {

    int indexOfInvoice(String staffId);

    boolean existsStaffId(String staffId);

    void displayByRevenue(Double min, Double max);
}