package view;

import controller.OurClassManagement;
import controller.Const;

public class ClassMenu implements Const {

    private static final OurClassManagement OUR_CLASS_MANAGEMENT = new OurClassManagement();

    protected void runClassMenu() {
        int choice;
        do {
            drawClassMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    OUR_CLASS_MANAGEMENT.displayAll();
                    break;
                }
                case 2: {
                    OUR_CLASS_MANAGEMENT.request(CLASS_ID);
                    String classId = scanner.nextLine();
                    OUR_CLASS_MANAGEMENT.showStudentList(classId);
                    break;
                }
                case 3: {
                    OUR_CLASS_MANAGEMENT.add();
                    break;
                }
                case 4: {
                    OUR_CLASS_MANAGEMENT.request(CLASS_ID);
                    String classId = scanner.nextLine();
                    OUR_CLASS_MANAGEMENT.edit(classId);
                    break;
                }
                case 5: {
                    OUR_CLASS_MANAGEMENT.request(CLASS_ID);
                    String classId = scanner.nextLine();
                    OUR_CLASS_MANAGEMENT.remove(classId);
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

    private void drawClassMenu() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("CLASS MENU!");
        System.out.println("\t 1. Show class list (number of students included)!");
        System.out.println("\t 2. Show student list of a class!");
        System.out.println("\t 3. Add a new class!");
        System.out.println("\t 4. Edit a class's information!");
        System.out.println("\t 5. Delete a class!");
        System.out.println("\t 0. Back to Main Menu!");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print(MAKE_CHOICE);
    }
}
