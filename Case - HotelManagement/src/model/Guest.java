package model;

public class Guest {
    private PersonalInformation personalInformation;
    private int expenditure;
    private GuestLevel guestLevel;

    public Guest(){}

    public Guest(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public Guest(PersonalInformation personalInformation, int expenditure, GuestLevel guestLevel) {
        this.personalInformation = personalInformation;
        this.expenditure = expenditure;
        this.guestLevel = guestLevel;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public GuestLevel getGuestLevel() {
        return guestLevel;
    }

    public void setGuestLevel(GuestLevel guestLevel) {
        this.guestLevel = guestLevel;
    }

    @Override
    public String toString() {
        return personalInformation + "," + expenditure + "," + guestLevel;
    }
}