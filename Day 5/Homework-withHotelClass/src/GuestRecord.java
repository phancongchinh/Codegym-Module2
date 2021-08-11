import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GuestRecord {

    private LocalDate dateOfCheckingIn;
    private LocalDate dateOfCheckingOut;
    private String roomLevel;
    private Guest information;

    //getters
    public LocalDate getDateOfCheckingIn() {
        return dateOfCheckingIn;
    }

    public LocalDate getDateOfCheckingOut() {
        return dateOfCheckingOut;
    }

    public String getRoomLevel() {
        return roomLevel;
    }

    public Guest getInformation() {
        return information;
    }

    //setters
    public void setDateOfCheckingIn(LocalDate dateOfCheckingIn) {
        this.dateOfCheckingIn = dateOfCheckingIn;
    }

    public void setDateOfCheckingOut(LocalDate dateOfCheckingOut) {
        this.dateOfCheckingOut = dateOfCheckingOut;
    }

    public void setRoomLevel(String roomLevel) {
        this.roomLevel = roomLevel;
    }

    public void setInformation(Guest information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return information.toString() +
                ", DCI: " + this.getDateOfCheckingIn() +
                ", DCO: " + this.getDateOfCheckingOut() +
                ", RLV: " + this.getRoomLevel();
    }

    //others method
    public long getStayingTime() { //count in days
        return ChronoUnit.DAYS.between(dateOfCheckingIn, dateOfCheckingOut);
    }

    public int getRoomRate() {
        switch (this.getRoomLevel()) {
            case "Premium":
                return 1000;
            case "Deluxe":
                return 800;
            case "Standard":
                return 600;
            default:
                return 0;
        }
    }

    public long getBill() {
        return this.getRoomRate() * this.getStayingTime();
    }
}

