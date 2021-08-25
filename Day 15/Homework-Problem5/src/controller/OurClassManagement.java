package controller;

import model.OurClass;
import model.Student;

import java.util.LinkedList;
import java.util.List;

public class OurClassManagement implements Const, IGeneralManagement {

    public static final List<OurClass> ourClassList = new LinkedList<>();

    @Override
    public void add() {
        ourClassList.add(initClass());
    }

    protected OurClass initClass() {
        OurClass ourClass = new OurClass();
        ourClass.setClassId(initClassId());
        ourClass.setClassName(initClassName());
        return ourClass;
    }

    private String initClassId() {
        request(CLASS_ID);
        return scanner.nextLine();
    }

    private String initClassName() {
        request(CLASS_NAME);
        return scanner.nextLine();
    }

    @Override
    public void display(String classId) {
        int index = searchById(classId);
        System.out.println(ourClassList.get(index));
    }

    @Override
    public void displayAll() {  // number of students included!
        for (OurClass ourClass : ourClassList) {
            int count = 0;
            for (Student student : StudentManagement.studentList) {
                if (student.getOurClass().equals(ourClass)) {
                    count++;
                }
            }
            System.out.println(ourClass + "," + count);
        }
    }

    public void showStudentList(String classId) {
        for (Student student : StudentManagement.studentList) {
            if (student.getOurClass().getClassId().equals(classId)) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void edit(String classId) {
        int index = searchById(classId);
        ourClassList.remove(index);
        ourClassList.add(index, initClass());
    }

    @Override
    public void remove(String classId) {
        int index = searchById(classId);
        ourClassList.remove(index);
    }

    @Override
    public void request(String description) {
        System.out.println("Enter " + description + ": ");
    }

    @Override
    public int searchById(String classId) {
        for (int i = 0; i < ourClassList.size(); i++) {
            if (ourClassList.get(i).getClassId().equals(classId)) {
                return i;
            }
        }
        return -1;
    }
}
