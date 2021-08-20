public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private String homeTown;
    private String className;
    private Double mark;

    public Student() {
    }

    public Student(int studentId, String name, String homeTown, String className, Double mark) {
        this.studentId = studentId;
        this.name = name;
        this.homeTown = homeTown;
        this.className = className;
        this.mark = mark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return " { studentId: " + studentId +
                ", name: " + name +
                ", homeTown: " + homeTown +
                ", className: " + className +
                ", mark: " + mark +
                " }";
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
