import java.time.LocalDate;

public class Student {
    private String name;
    private int studentId;
    private LocalDate dateOfBirth;
    private String className;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return " {" +
                "name: " + name +
                ", studentID: " + studentId +
                ", dateOfBirth: " + dateOfBirth +
                ", className: " + className +
                "} ";
    }
}
