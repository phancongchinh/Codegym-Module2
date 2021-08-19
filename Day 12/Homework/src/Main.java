import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static LibraryManagement management = new LibraryManagement();

    public static void main(String[] args) {
        int id;
        int choice;
        System.out.println(Const.EMPTY_LIST);
        do {
            drawMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(Const.ADDING);
                    management.add();
                    System.out.println(Const.ADDED);
                    management.displayAll();
                    break;
                case 2:
                    System.out.println(Const.DISPLAYING);
                    request(Const.STUDENT_ID);
                    id = scanner.nextInt();
                    while (!management.studentIdExisted(id)) {
                        System.out.println(Const.STUDENT_ID_NOT_EXIST);
                        id = scanner.nextInt();
                    }
                    management.display(id);
                    break;
                case 3:
                    System.out.println(Const.EDITING);
                    request(Const.STUDENT_ID);
                    id = scanner.nextInt();
                    while (!management.studentIdExisted(id)) {
                        System.out.print(Const.STUDENT_ID_NOT_EXIST);
                        id = scanner.nextInt();
                    }
                    management.edit(id);
                    System.out.println(Const.EDITED);
                    System.out.println(Const.BACK);
                    break;
                case 4:
                    System.out.println(Const.DELETING);
                    request(Const.STUDENT_ID);
                    id = scanner.nextInt();
                    while (!management.studentIdExisted(id)) {
                        System.out.println(Const.STUDENT_ID_NOT_EXIST);
                        id = scanner.nextInt();
                    }
                    management.delete(id);
                    System.out.println(Const.DELETED);
                    management.displayAll();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public static void drawMainMenu() {
        System.out.println("\n=============================================================================");
        System.out.println("MAIN MENU!");
        System.out.println("\t 1. Add a new library card!");
        System.out.println("\t 2. Display a library card (Student ID required)!");
        System.out.println("\t 3. Edit a library card (Student ID required)!");
        System.out.println("\t 4. Delete a library card (Student ID required)!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
        System.out.print(Const.MAKE_CHOICE);
    }

    public static void drawEditMenu(int id) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Student ID number: " + id);
        management.display(id);
        System.out.println("EDIT MENU!");
        System.out.println("\t 1. Change student's name!");
        System.out.println("\t 2. Change student's ID Number (Back to MAIN MENU required)!");
        System.out.println("\t 3. Change date of birth!");
        System.out.println("\t 4. Change class name!");
        System.out.println("\t 5. Change library card number!");
        System.out.println("\t 6. Change book number!");
        System.out.println("\t 7. Change date of borrowing date!");
        System.out.println("\t 8. Change borrowing time!");
        System.out.println("\t 0. Back to MAIN MENU!");
        System.out.println("------------------------------------------------------------------------");
        System.out.print(Const.MAKE_CHOICE);
    }

    public static void request(String description) {
        System.out.print("Enter " + description + ": ");
    }
}