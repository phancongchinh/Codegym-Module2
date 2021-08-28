package controller;

import model.OurClass;
import model.Student;

import java.util.LinkedList;
import java.util.List;

import static view.OurClassMenu.ourClassManagement;

public class StudentManagement implements Const, GeneralManagement<Student> {

    private final StudentNameComparator studentNameComparator = new StudentNameComparator();
    private final StudentMarkComparator studentMarkComparator = new StudentMarkComparator();

    private final List<Student> studentList = new LinkedList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        studentList.add(student);
        // add student to Class Student List
        int indexOfClass = ourClassManagement.searchClassById(student.getClassId());
        OurClass ourClass = ourClassManagement.getOurClassList().get(indexOfClass);
        ourClass.getClassStudentList().add(student);
        return true;
    }

    public Student initStudent() {
        request(CLASS_ID);
        String classId = scanner.nextLine();
        //check classId exists or not
        boolean classIdNotExist = !ourClassManagement.classIdExists(classId);
        if (classIdNotExist) {
            System.out.println(CLASS_NOT_EXISTED);
            return null;
        }
        request(ID);
        String id = scanner.nextLine();
        //check studentId exists or not
        if (studentIdExists(id)) {
            System.out.println(STUDENT_EXISTED);
            return null;
        }
        Student student = new Student();
        student.setClassId(classId);
        student.setId(id);
        request(NAME);
        student.setName(scanner.nextLine());
        request(DATE_OF_BIRTH);
        student.setDateOfBirth(scanner.nextLine());
        request(MARK);
        student.setMark(scanner.nextDouble());
        return student;
    }

    @Override
    public void display(String id) {
        int index = searchStudentById(id);
        System.out.println(studentList.get(index));
    }

    @Override
    public void displayAll() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public boolean edit(String id) {
        int index = searchStudentById(id);
        System.out.println(GATHERING_NEW_INFORMATION);
        Student student = initStudent();
        if (student == null) {
            return false;
        } else {
            //remove then add new student to student list
            Student removedStudent = studentList.remove(index);
            studentList.add(index,student);
            // get index of the removed student in the class's student list
            int indexOfClass = ourClassManagement.searchClassById(removedStudent.getClassId());
            OurClass ourClass = ourClassManagement.getOurClassList().get(indexOfClass);
            int indexOfRemovedStudentInClass = ourClass.getClassStudentList().indexOf(removedStudent);
            // remove then add new student to class student list
            ourClass.getClassStudentList().remove(indexOfRemovedStudentInClass);
            ourClass.getClassStudentList().add(indexOfRemovedStudentInClass,student);
            return true;
        }
    }

    @Override
    public void remove(String id) {
        // remove the student from student list
        int index = searchStudentById(id);
        Student removedStudent = studentList.remove(index);
        // get the class
        int indexOfClass = ourClassManagement.searchClassById(removedStudent.getClassId());
        OurClass ourClass = ourClassManagement.getOurClassList().get(indexOfClass);
        // remove the student from class's student list
        ourClass.getClassStudentList().remove(removedStudent);
    }

    public void sortByNameAZ() {
        studentList.sort(studentNameComparator);
    }

    public void sortByNameZA() {
        studentList.sort(studentNameComparator.reversed());
    }

    public void sortByHighMark() {
        studentList.sort(studentMarkComparator.reversed());
    }

    public int searchStudentById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public boolean studentIdExists(String classId) {
        return searchStudentById(classId) != -1;
    }

    private void request(String description) {
        System.out.print("Enter " + description + ": ");
    }
}
