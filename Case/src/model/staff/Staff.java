package model.staff;

import model.account.Account;
import model.personalInformation.PersonalInformation;

public class Staff {
    private PersonalInformation personalInformation;
    private String staffId;
    private Account staffAccount;
    private Double staffRevenue = 0.00;


    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Account getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccountInformation(Account staffAccount) {
        this.staffAccount = staffAccount;
    }

    public Double getStaffRevenue() {
        return staffRevenue;
    }

    public void setStaffRevenue(Double staffRevenue) {
        this.staffRevenue = staffRevenue;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "personalInformation=" + personalInformation +
                ", staffId='" + staffId + '\'' +
                ", staffAccount=" + staffAccount +
                ", staffRevenue=" + staffRevenue +
                '}';
    }
}
