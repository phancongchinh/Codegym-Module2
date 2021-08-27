package controller;

import model.Student;

import java.util.Comparator;

public class StudentMarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getMark(),o2.getMark());
    }
}
