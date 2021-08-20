public class Main implements Const {

    static StudentManagement management = new StudentManagement();

    public static void main(String[] args) {
        int id;
        int choice;
        System.out.println(EMPTY);
        do {
            drawMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(ADDING);
                    management.add();
                    management.sortByName();
                    System.out.println(ADDED);
                    management.displayAll();
                    break;
                case 2:
                    System.out.println(DISPLAYING);
                    management.request(STUDENT_ID);
                    id = scanner.nextInt();
                    while (!management.idExisted(id)) {
                        System.out.print(NOT_EXISTED);
                        id = scanner.nextInt();
                    }
                    management.display(id);
                    break;
                case 3:
                    System.out.println(SORTED_BY_MARKS);
                    management.sortByMark();
                    management.displayAll();
                    break;
                case 4:
                    System.out.println(EDITING);
                    management.request(STUDENT_ID);
                    id = scanner.nextInt();
                    while (!management.idExisted(id)) {
                        System.out.print(NOT_EXISTED);
                        id = scanner.nextInt();
                    }
                    management.edit(id);
                    System.out.println(EDITED);
                    System.out.println(BACK);
                    break;
                case 5:
                    System.out.println(DELETING);
                    management.request(STUDENT_ID);
                    id = scanner.nextInt();
                    while (!management.idExisted(id)) {
                        System.out.print(NOT_EXISTED);
                        id = scanner.nextInt();
                    }
                    management.delete(id);
                    System.out.println(DELETED);
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
        System.out.println("\t 1. Add a new student!");
        System.out.println("\t 2. Display a student's information (Student ID required)!");
        System.out.println("\t 3. Display student list sorted by mark!");
        System.out.println("\t 4. Edit student's information (Student ID required)!");
        System.out.println("\t 5. Delete student's information (Student ID required)!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
        System.out.print(MAKE_CHOICE);
    }

    public static void drawEditMenu(int id) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Student ID number: " + id);
        management.display(id);
        System.out.println("EDIT MENU!");
        System.out.println("\t 1. Change student's ID Number (Back to MAIN MENU required)!");
        System.out.println("\t 2. Change student's name!");
        System.out.println("\t 3. Change student's hometown!");
        System.out.println("\t 4. Change student's class name!");
        System.out.println("\t 5. Change student's mark!");
        System.out.println("\t 0. Back to MAIN MENU!");
        System.out.println("------------------------------------------------------------------------");
        System.out.print(MAKE_CHOICE);
    }
}