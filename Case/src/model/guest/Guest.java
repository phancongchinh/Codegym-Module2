package model.guest;

import model.personalInformation.PersonalInformation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Guest {
    private PersonalInformation personalInformation;
    private LocalDate dateOfCheckingIn;
    private LocalDate dateOfCheckingOut;

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public LocalDate getDateOfCheckingIn() {
        return dateOfCheckingIn;
    }

    public void setDateOfCheckingIn(LocalDate dateOfCheckingIn) {
        this.dateOfCheckingIn = dateOfCheckingIn;
    }

    public LocalDate getDateOfCheckingOut() {
        return dateOfCheckingOut;
    }

    public void setDateOfCheckingOut(LocalDate dateOfCheckingOut) {
        this.dateOfCheckingOut = dateOfCheckingOut;
    }

    public long getStayingTime() {
        return ChronoUnit.DAYS.between(dateOfCheckingIn,dateOfCheckingOut);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "personalInformation=" + personalInformation +
                ", dateOfCheckingIn=" + dateOfCheckingIn +
                ", getDateOfCheckingOut=" + dateOfCheckingOut +
                '}';
    }
}
