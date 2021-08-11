import java.time.LocalDate;

public class Guest {
    private String fullName;
    private int idNumber;
    private LocalDate dateOfBirth;

    //getters
    public String getName() {
        return fullName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    //setters
    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                ", ID: " + this.getIdNumber() +
                ", DOB: " + this.getDateOfBirth();
    }
}