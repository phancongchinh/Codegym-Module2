package model;

public class Guest {
    private PersonalInformation personalInformation;
    private int expenditure;

    public Guest(){}

    public Guest(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public Guest(PersonalInformation personalInformation, int expenditure, GuestLevel guestLevel) {
        this.personalInformation = personalInformation;
        this.expenditure = expenditure;
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
        if (expenditure > 500000) {
            return GuestLevel.DIAMOND;
        } else if (expenditure > 300000) {
            return GuestLevel.PLATINUM;
        } else if (expenditure > 100000) {
            return GuestLevel.GOLD;
        } else if (expenditure > 50000) {
            return GuestLevel.SILVER;
        } else {
            return GuestLevel.STANDARD;
        }
    }


    @Override
    public String toString() {
        return personalInformation + "," + expenditure + "," + getGuestLevel();
    }
}