package view;

import controller.Const;
import controller.StudentManagement;

public class StudentMenu implements Const {

    final StudentManagement studentManagement = new StudentManagement();

    void runStudentMenu() {
        int choice;
        do {
            drawStudentMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println(DISPLAYING);
                    studentManagement.displayAll();
                    break;
                }
                case 2: {
                    studentManagement.request(ID);
                    String id = scanner.nextLine();
                    studentManagement.display(id);
                    break;
                }
                case 3: {
                    System.out.println(ADDING);
                    studentManagement.add();
                    System.out.println(ADDED);
                    break;
                }
                case 4: {
                    System.out.println(EDITING);
                    studentManagement.request(ID);
                    String id = scanner.nextLine();
                    studentManagement.edit(id);
                    System.out.println(EDITED);
                    break;
                }
                case 5: {
                    System.out.println(DELETING);
                    studentManagement.request(ID);
                    String id = scanner.nextLine();
                    studentManagement.remove(id);
                    System.out.println(DELETED);
                    break;
                }
                case 6: {
                    studentManagement.sortByNameAZ();
                    studentManagement.displayAll();
                    studentManagement.sortByNameZA();
                    studentManagement.displayAll();
                    break;
                }
                case 7: {
                    studentManagement.sortByMark();
                    studentManagement.displayTopMark();
                    studentManagement.sortByNameAZ(); // re-sort the list by name, can be ignored
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    break;
                }
            }
        } while (choice != 0);
    }

    private void drawStudentMenu() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("STUDENT MENU!");
        System.out.println("\t 1. Show all student!");
        System.out.println("\t 2. Search student by ID!");
        System.out.println("\t 3. Add a new student!");
        System.out.println("\t 4. Edit a student's information!");
        System.out.println("\t 5. Delete a student!");
        System.out.println("\t 6. Sort by name A-Z and Z-A!");
        System.out.println("\t 7. Top 5 student with highest mark!");
        System.out.println("\t 0. Back to Main Menu!");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print(MAKE_CHOICE);
    }
}
