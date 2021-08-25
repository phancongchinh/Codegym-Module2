package controller;

import com.sun.deploy.util.JVMParameters;
import model.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentManagement implements Const, IGeneralManagement {

    public static final List<Student> studentList = new LinkedList<>();
    static final StudentNameComparator studentNameComparator = new StudentNameComparator();
    static final StudentMarkComparator studentMarkComparator = new StudentMarkComparator();


    @Override
    public void add() {
        studentList.add(initNewStudent());
    }

    private Student initNewStudent() {
        Student student = new Student();
        student.setId(initId());
        student.setName(initName());
        student.setDateOfBirth(initDateOfBirth());
        student.setMark(initMark());
//        student.setOurClass(.initClass());
        return student;
    }

    private String initId() {
        request(ID);
        return scanner.nextLine();
    }

    private String initName() {
        request(NAME);
        return scanner.nextLine();
    }

    private String initDateOfBirth() {
        request(DATE_OF_BIRTH);
        return scanner.nextLine();
    }

    private double initMark() {
        request(MARK);
        return scanner.nextDouble();
    }

//    private String initClass() {
//    }

    @Override
    public void display(String id) {
        int index = searchById(id);
        System.out.println(studentList.get(index));
    }

    @Override
    public void displayAll() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void displayTopMark() {
        for (int i = 0; i < 5; i++) {
            System.out.println(studentList.get(i));
        }
    }

    @Override
    public void edit(String id) {
        int index = searchById(id);
        studentList.remove(index);
        studentList.add(index, initNewStudent());
    }

    @Override
    public void remove(String id) {
        int index = searchById(id);
        studentList.remove(index);
    }

    @Override
    public void request(String description) {
        System.out.println("Enter " + description + ": ");
    }

    @Override
    public int searchById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void sortByNameAZ() {
        studentList.sort(studentNameComparator);
    }

    public void sortByNameZA() {
        studentList.sort(studentNameComparator.reversed());
    }

    public void sortByMark() {
        studentList.sort(studentMarkComparator);
    }
}
