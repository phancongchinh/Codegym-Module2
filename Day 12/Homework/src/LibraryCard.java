import java.time.LocalDate;

public class LibraryCard {
    private Student student;
    private String cardNumber;
    private String bookNumber;
    private LocalDate dateOfBorrowing;
    private int borrowingTime;


    public LibraryCard() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public void setDateOfBorrowing(LocalDate dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public int getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(int borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return student + "\n\t\t" +
                "cardNumber: " + cardNumber +
                ", bookNumber: " + bookNumber +
                ", dateOfBorrowing: " + dateOfBorrowing +
                ", dateOfReturning: " + dateOfBorrowing.plusDays(borrowingTime) +
                '}';
    }
}
