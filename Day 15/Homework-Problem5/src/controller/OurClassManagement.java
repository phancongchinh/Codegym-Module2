package controller;

import model.OurClass;
import model.Student;

import java.util.LinkedList;

import static view.StudentMenu.studentManagement;

public class OurClassManagement implements Const, GeneralManagement<OurClass> {

    private final LinkedList<OurClass> ourClassList = new LinkedList<>();

    public LinkedList<OurClass> getOurClassList() {
        return ourClassList;
    }

    @Override
    public boolean add(OurClass ourClass) {
        ourClassList.add(ourClass);
        return true;
    }

    public OurClass initOurClass() {
        OurClass ourClass = new OurClass();
        String classId = initClassId();
        boolean classIdExisted = searchClassById(classId) != -1;
        if (classIdExisted) {
            System.out.println(CLASS_EXISTED);
            return null;
        }
        ourClass.setClassId(classId);

        ourClass.setClassStudentList(new LinkedList<>());
        return ourClass;
    }

    private String initClassId() {
        request(CLASS_ID);
        return scanner.nextLine();
    }

    @Override
    public void display(String classId) {
        int index = searchClassById(classId);
        OurClass ourClass = ourClassList.get(index);

        System.out.println(ourClass);// mã lớp + số sinh viên :))

        boolean classStudentListIsEmpty = ourClass.getClassStudentList().size() == 0;
        if (classStudentListIsEmpty) {
            System.out.println(STUDENT_LIST_OF_THIS_CLASS_EMPTY);
        } else {
            System.out.println(STUDENT_LIST_OF_THIS_CLASS);
            for (Student student : ourClass.getClassStudentList()) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void displayAll() {
        for (OurClass ourClass : ourClassList) {
            System.out.println(ourClass);
        }
    }

    @Override
    public boolean edit(String classId) {
        int index = searchClassById(classId);
        System.out.println(GATHERING_NEW_INFORMATION);
        OurClass ourClass = initOurClass();

        if (ourClass == null) {
            return false;
        } else {
            OurClass removedClass = ourClassList.remove(index);

            ourClassList.add(index,ourClass);

            // transfer the class student list from the removed to the new one
            ourClass.setClassStudentList(removedClass.getClassStudentList());
            //change the classId of all student into the new classId
            for (Student student : ourClass.getClassStudentList()) {
                student.setClassId(ourClass.getClassId());
            }
            return true;
        }
    }

    @Override
    public void remove(String classId) {
        int index = searchClassById(classId);
        ourClassList.remove(index);
        //remove all the student in the class
        studentManagement.getStudentList().removeIf(student -> student.getClassId().equals(classId));
    }

    public int searchClassById(String classId) {
        for (int i = 0; i < ourClassList.size(); i++) {
            if (ourClassList.get(i).getClassId().equals(classId)) {
                return i;
            }
        }
        return -1;
    }

    public boolean classIdExists(String classId) {
        return searchClassById(classId) != -1;
    }

    private void request(String description) {
        System.out.print("Enter " + description + ": ");
    }
}
