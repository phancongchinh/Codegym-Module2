public class Student {
    public String name = "John";
    public String classes = "C02";

    //    Student(){
    //    }

    //gettters and setters

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.getName() + '\'' +
                ", classes='" + this.getClasses() + '\'' +
                '}';
    }
}
