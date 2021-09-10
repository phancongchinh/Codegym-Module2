package model;

public class Guest {
    private PersonalInformation personalInformation;
    private Double expenditure = 0.0;

    public Guest(){}

    public Guest(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public Double getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Double expenditure) {
        this.expenditure = expenditure;
    }

    public GuestLevel getGuestLevel() {
        if (expenditure > 500000) {
            return GuestLevel.DIAMOND;
        } else if (expenditure > 250000) {
            return GuestLevel.GOLD;
        } else {
            return GuestLevel.STANDARD;
        }
    }

    @Override
    public String toString() {
        return personalInformation + "," + expenditure + "," + getGuestLevel();
    }
}