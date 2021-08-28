package model;

import java.util.LinkedList;

public class OurClass {
    private String classId;
    private LinkedList<Student> classStudentList;

    public OurClass() {
    }

    public OurClass(String classId, LinkedList<Student> classStudentList) {
        this.classId = classId;
        this.classStudentList = classStudentList;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public LinkedList<Student> getClassStudentList() {
        return classStudentList;
    }

    public void setClassStudentList(LinkedList<Student> classStudentList) {
        this.classStudentList = classStudentList;
    }

    @Override
    public String toString() {
        return classId + ", " + classStudentList.size() + " student";
    }
}
