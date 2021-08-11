import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Guest {
    private String name;
    private int idNumber;
    private LocalDate dateOfBirth;
    private LocalDate dateOfCheckingIn;
    private LocalDate dateOfCheckingOut;
    private char roomLevel; // 'A', 'B' or 'C'

    //getters
    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfCheckingIn() {
        return dateOfCheckingIn;
    }

    public LocalDate getDateOfCheckingOut() {
        return dateOfCheckingOut;
    }

    public char getRoomLevel() {
        return roomLevel;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setDateOfCheckingIn(LocalDate dateOfCheckingIn) {
        this.dateOfCheckingIn = dateOfCheckingIn;
    }

    public void setDateOfCheckingOut(LocalDate dateOfCheckingOut) {
        this.dateOfCheckingOut = dateOfCheckingOut;
    }

    public void setRoomLevel(char roomLevel) {
        this.roomLevel = roomLevel;
    }

    //other methods
    public long getRoomPrice() { //USD per night
        int roomPrice = 0;
        switch (this.roomLevel) {
            case 'A':
                roomPrice = 1000;
                break;
            case 'B':
                roomPrice = 600;
                break;
            case 'C':
                roomPrice = 200;
                break;
        }
        return roomPrice;
    }

    public long getStayingDays () {
        return ChronoUnit.DAYS.between(this.dateOfCheckingIn, this.dateOfCheckingOut);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + this.getName() + '\'' +
                ", idNumber=" + this.getIdNumber() +
                ", dateOfBirth=" + this.getDateOfBirth() +
                ", dateOfCheckingIn=" + this.getDateOfCheckingOut() +
                ", dateOfCheckingOut=" + this.getDateOfCheckingOut() +
                ", stayingDays=" + this.getStayingDays() +
                ", roomLevel=" + this.getRoomLevel() +
                '}';
    }
}