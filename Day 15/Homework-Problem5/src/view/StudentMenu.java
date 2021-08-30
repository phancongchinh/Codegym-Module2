package view;

import controller.Const;
import controller.StudentManagement;
import model.Student;

public class StudentMenu implements Const, Menu {

    public static StudentManagement studentManagement = new StudentManagement();

    public static StudentManagement getStudentManagement() {
        return studentManagement;
    }

    @Override
    public void draw() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("STUDENT MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all students!");
        System.out.println("\t 2. Searching information of a student!");
        System.out.println("\t 3. Add a new student!");
        System.out.println("\t 4. Edit a student!");
        System.out.println("\t 5. Delete a student!");
        System.out.println("\t 6. Sort student list by name A-Z and Z-A!");
        System.out.println("\t 7. Sort student list by mark!");
        System.out.println("\t 0. Back to Main Menu!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean studentListIsEmpty = studentManagement.getStudentList().size() == 0;
            switch (choice) {
                case 1: {
                    if (studentListIsEmpty) {
                        System.out.println(STUDENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(STUDENT_LIST);
                    studentManagement.displayAll();
                    break;
                }
                case 2: {
                    if (studentListIsEmpty) {
                        System.out.println(STUDENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_STUDENT);
                    request(ID);
                    String id = scanner.nextLine();
                    if (studentManagement.studentIdExists(id)) {
                        studentManagement.display(id);
                    } else {
                        System.out.println(STUDENT_NOT_EXISTED);
                    }
                    break;
                }
                case 3: {
                    System.out.println(ADDING_STUDENT);
                    Student student = studentManagement.initStudent();
                    if (student != null) {
                        studentManagement.add(student);
                        System.out.println(STUDENT_ADDED);
                    } else {
                        System.out.println(STUDENT_ADDED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 4: {
                    if (studentListIsEmpty) {
                        System.out.println(STUDENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(EDITING_STUDENT);
                    request(ID);
                    String id = scanner.nextLine();
                    if (studentManagement.studentIdExists(id)) {
                        if (studentManagement.edit(id)) {
                            System.out.println(STUDENT_EDITED);
                        } else {
                            System.out.println(STUDENT_EDITED_UNSUCCESSFULLY);
                        }
                    } else {
                        System.out.println(STUDENT_NOT_EXISTED);
                        System.out.println(STUDENT_EDITED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 5: {
                    if (studentListIsEmpty) {
                        System.out.println(STUDENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DELETING_STUDENT);
                    request(ID);
                    String id = scanner.nextLine();
                    if (studentManagement.studentIdExists(id)) {
                        studentManagement.remove(id);
                        System.out.println(STUDENT_DELETED);
                    } else {
                        System.out.println(STUDENT_NOT_EXISTED);
                        System.out.println(STUDENT_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 6: {
                    if (studentListIsEmpty) {
                        System.out.println(STUDENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(STUDENT_LIST_SORTED_BY_NAME_AZ);
                    studentManagement.sortByNameAZ();
                    studentManagement.displayAll();
                    System.out.println(STUDENT_LIST_SORTED_BY_NAME_ZA);
                    studentManagement.sortByNameZA();
                    studentManagement.displayAll();
                    break;
                }
                case 7: {
                    if (studentListIsEmpty) {
                        System.out.println(STUDENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(STUDENT_LIST_SORTED_BY_MARK);
                    studentManagement.sortByHighMark();
                    studentManagement.displayAll();
                    break;
                }
                case 0: {
                    System.out.println(TURN_BACK);
                    return;
                }
                default: {
                    break;
                }
            }
        } while (choice != 0);
    }

    private void request(String description) {
        System.out.print("Enter " + description + ": ");
    }
}
