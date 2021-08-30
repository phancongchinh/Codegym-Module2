package view;

import controller.Const;
import controller.OurClassManagement;
import model.OurClass;

public class OurClassMenu implements Const, Menu {

    public static OurClassManagement ourClassManagement = new OurClassManagement();

    @Override
    public void draw() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("CLASS MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all classes!");
        System.out.println("\t 2. Search for a class!");
        System.out.println("\t 3. Add a new class!");
        System.out.println("\t 4. Edit a class!");
        System.out.println("\t 5. Delete a class!");
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
            boolean classListIsEmpty = ourClassManagement.getOurClassList().size() == 0;
            switch (choice) {
                case 1:{
                    if (classListIsEmpty) {
                        System.out.println(CLASS_LIST_EMPTY);
                        break;
                    }
                    System.out.println(CLASS_LIST);
                    ourClassManagement.displayAll();
                    break;
                }
                case 2:{
                    if (classListIsEmpty) {
                        System.out.println(CLASS_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_CLASS);
                    request(CLASS_ID);
                    String classId = scanner.nextLine();
                    if (ourClassManagement.classIdExists(classId)) {
                        ourClassManagement.display(classId);
                    } else {
                        System.out.println(CLASS_NOT_EXISTED);
                    }
                    break;
                }
                case 3:{
                    System.out.println(ADDING_CLASS);
                    OurClass ourClass = ourClassManagement.initOurClass();
                    if (ourClass != null) {
                        ourClassManagement.add(ourClass);
                        System.out.println(CLASS_ADDED);
                    } else {
                        System.out.println(CLASS_ADDED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 4:{
                    if (classListIsEmpty) {
                        System.out.println(CLASS_LIST_EMPTY);
                        break;
                    }
                    System.out.println(EDITING_CLASS);
                    request(CLASS_ID);
                    String classId = scanner.nextLine();
                    if (ourClassManagement.classIdExists(classId)) {
                        if (ourClassManagement.edit(classId)) {
                            System.out.println(CLASS_EDITED);
                        } else {
                            System.out.println(CLASS_EXISTED);
                            System.out.println(CLASS_EDITED_UNSUCCESSFULLY);
                        }
                    } else {
                        System.out.println(CLASS_NOT_EXISTED);
                        System.out.println(CLASS_EDITED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 5:{
                    if (classListIsEmpty) {
                        System.out.println(CLASS_LIST_EMPTY);
                        break;
                    }
                    System.out.print(CLASS_DELETING_CONFIRM);
                    char confirm = scanner.nextLine().charAt(0);
                    if (confirm != 'y') {
                        break;
                    }
                    System.out.println(DELETING_CLASS);
                    request(CLASS_ID);
                    String classId = scanner.nextLine();
                    if (ourClassManagement.classIdExists(classId)) {
                        ourClassManagement.remove(classId);
                        System.out.println(CLASS_DELETED);
                    } else {
                        System.out.println(CLASS_NOT_EXISTED);
                        System.out.println(CLASS_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 0:{
                    System.out.println(TURN_BACK);
                    return;
                }
                default:{
                    break;
                }
            }
        } while (choice != 0);
    }

    private void request(String description) {
        System.out.print("Enter " + description + ": ");
    }
}
