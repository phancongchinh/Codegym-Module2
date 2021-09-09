package model;

import java.time.LocalDate;

public class Staff {
    private PersonalInformation personalInformation;
    private String staffId;
    private Role role;
    private Account account;
    private Double sales;

    public Staff() {
    }

    public Staff(PersonalInformation personalInformation, String staffId, Role role, Account account, Double sales) {
        this.personalInformation = personalInformation;
        this.staffId = staffId;
        this.role = role;
        this.account = account;
        this.sales = sales;
    }

    public Staff(String id, String name, LocalDate dateOfBirth, String staffId, Role role, Double sales) {
        this.personalInformation = new PersonalInformation(id, name, dateOfBirth);
        this.staffId = staffId;
        this.role = role;
        this.sales = sales;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return personalInformation + "," + staffId + "," + role + "," + sales;
    }
}