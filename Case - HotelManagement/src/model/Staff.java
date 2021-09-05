package model;

public class Staff extends Person {
    private String staffId;
    private Account account;
    private Role role;
    private int sales;

    public Staff(PersonalInformation personalInformation, String staffId, Account account, Role role, int sales) {
        super(personalInformation);
        this.staffId = staffId;
        this.account = account;
        this.role = role;
        this.sales = sales;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "personalInformation=" + super.getPersonalInformation() +
                ", staffId='" + staffId + '\'' +
                ", account=" + account +
                ", role=" + role +
                ", sales=" + sales +
                '}';
    }
}