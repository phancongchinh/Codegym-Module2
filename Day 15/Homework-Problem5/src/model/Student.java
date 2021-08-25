package model;

public class Student {
    private String id;
    private String name;
    private String dateOfBirth;
    private double mark;
    private OurClass ourClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public OurClass getOurClass() {
        return ourClass;
    }

    public void setOurClass(OurClass ourClass) {
        this.ourClass = ourClass;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + dateOfBirth + "," + mark + "," + ourClass;
    }
}
