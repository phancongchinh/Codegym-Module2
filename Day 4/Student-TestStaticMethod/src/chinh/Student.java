package chinh;

public class Student {
    private int id;
    String name;
    private static String college = "BKA"; // All the objects initialized in the future will have "BKA" as "college"

    //constructor to initialize the variable
    Student(int r, String n) {
        id = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "HUS";
    }

    //method to display values
    void display() {
        System.out.println(id + " " + name + " " + college);
    }

    void setName(String name) {
        this.name = name;
    }

    void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}