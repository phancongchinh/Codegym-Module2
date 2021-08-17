import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Management management = new Management();

    public static void main(String[] args) {
        String id;
        int choice;
        System.out.println(Const.EMPTY_LIST);
        do {
            drawMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(Const.ADDING);
                    management.addMaterial(initMaterial());
                    System.out.println(Const.ADDED);
                    management.sortByName();
                    management.displayAllMaterials();
                    break;
                case 2:
                    System.out.println(Const.DISPLAYING);
                    request(Const.ID);
                    id = scanner.nextLine();
                    while (!management.doesExist(id)) {
                        System.out.println(Const.NOT_EXIST);
                        id = scanner.nextLine();
                    }
                    management.displayMaterial(id);
                    break;
                case 3:
                    System.out.println(Const.EDITING);
                    request(Const.ID);
                    id = scanner.nextLine();
                    while (!management.doesExist(id)) {
                        System.out.println(Const.NOT_EXIST);
                        id = scanner.nextLine();
                    }
                    management.editMaterial(id);
                    System.out.println(Const.EDITED);
                    System.out.println(Const.BACK);
                    break;
                case 4:
                    System.out.println(Const.DELETING);
                    request(Const.ID);
                    id = scanner.nextLine();
                    while (!management.doesExist(id)) {
                        System.out.println(Const.NOT_EXIST);
                        id = scanner.nextLine();
                    }
                    management.deleteMaterial(id);
                    System.out.println(Const.DELETED);
                    management.displayAllMaterials();
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
        System.out.println("\t 1. Add a new material!");
        System.out.println("\t 2. Display a material (ID required)!");
        System.out.println("\t 3. Edit a material (ID required)!");
        System.out.println("\t 4. Delete a material (ID required)!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
        System.out.print(Const.MAKE_CHOICE);
    }

    public static void request(String description) {
        System.out.print("Enter " + description);
    }


    public static Material initMaterial() {
        String category = inputCategory();
        String name = inputName();
        String id = inputId();
        LocalDate mfg = inputMFG();
        int listPrice = inputListPrice();
        switch (category) {
            case Const.MEAT:
                double weight = inputWeight();
                return new Meat(name, id, mfg, listPrice, weight);
            case Const.CRISPY_FLOUR:
                double quantity = inputQuantity();
                return new Meat(name, id, mfg, listPrice, quantity);
            default:
                return null;
        }
    }

    public static String inputCategory() {
        request(Const.CATEGORY);
        String category = scanner.nextLine();
        while (category.compareTo(Const.MEAT) * category.compareTo(Const.CRISPY_FLOUR) != 0) {
            System.out.print(Const.INVALID);
            category = scanner.nextLine();
        }
        return category;
    }

    public static String inputName() {
        request(Const.NAME);
        return scanner.nextLine();
    }

    public static String inputId() {
        request(Const.ID);
        String id = scanner.nextLine();
        while (management.doesExist(id)) {
            System.out.println(Const.EXIST);
            id = scanner.nextLine();
        }
        while (Integer.parseInt(id) < 0) {
            System.out.println(Const.INVALID);
            id = scanner.nextLine();
        }
        return id;
    }

    public static LocalDate inputMFG() {
        request(Const.MFG);
        LocalDate mfg = LocalDate.parse(scanner.nextLine());
        while (mfg.isAfter(LocalDate.now())) {
            System.out.println(Const.INVALID);
            mfg = LocalDate.parse(scanner.nextLine());
        }
        return mfg;
    }

    public static int inputListPrice() {
        request(Const.LIST_PRICE);
        int listPrice = scanner.nextInt();
        while (listPrice <= 0) {
            System.out.println(Const.INVALID);
            listPrice = scanner.nextInt();
        }
        return listPrice;
    }

    public static double inputWeight() {
        request(Const.WEIGHT);
        double weight = scanner.nextDouble();
        while (weight <= 0) {
            System.out.println(Const.INVALID);
            weight = scanner.nextInt();
        }
        return weight;
    }

    public static int inputQuantity() {
        request(Const.QUANTITY);
        int quantity = scanner.nextInt();
        while (quantity <= 0) {
            System.out.println(Const.INVALID);
            quantity = scanner.nextInt();
        }
        return quantity;
    }
}