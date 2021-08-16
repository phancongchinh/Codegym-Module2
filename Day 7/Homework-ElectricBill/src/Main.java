import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ElectricBillsManagement management = new ElectricBillsManagement();
    static int meterCode;

    public static void main(String[] args) {
        int choice;
        management.displayAllBills();
        do {
            drawMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println(cst.ADDING);
                    management.addBill();
                    management.sortByName();
                    System.out.println(cst.ADDED);
                    management.displayAllBills();
                    break;
                case 2:
                    System.out.println(cst.DISPLAYING);
                    meterCode = management.requestInt(cst.METER_CODE);
                    while (!management.doesExist(meterCode)) {
                        System.out.print(cst.NOT_EXISTED);
                        meterCode = scanner.nextInt();
                    }
                    management.displayBill(meterCode);
                    break;
                case 3:
                    System.out.println(cst.EDITING);
                    meterCode = management.requestInt(cst.METER_CODE);
                    ElectricBill electricBill = management.electricBills[management.searchByMeterCode(meterCode)];
                    while (!management.doesExist(meterCode)) {
                        System.out.print(cst.NOT_EXISTED);
                        meterCode = scanner.nextInt();
                    }
                    management.editBill(meterCode);
                    System.out.println(cst.EDITED);
                    System.out.println(cst.AFTER_EDITING);
                    management.displayBill(electricBill.getCustomer().getMeterCode());
                    break;
                case 4:
                    System.out.println(cst.DELETING);
                    meterCode = management.requestInt(cst.METER_CODE);
                    while (!management.doesExist(meterCode)) {
                        System.out.print(cst.NOT_EXISTED);
                        meterCode = scanner.nextInt();
                    }
                    management.deleteBill(meterCode);
                    System.out.println(cst.DELETED);
                    management.displayAllBills();
                    break;
                case 5:
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
        System.out.println("\t 1. Add a new electric bill!");
        System.out.println("\t 2. Read an electric bill (meter code required)!");
        System.out.println("\t 3. Update an electric bill (meter code required)!");
        System.out.println("\t 4. Delete an electric bill (meter code required)!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
        System.out.print(cst.MAKE_CHOICE);
    }

    public static void drawEditMenu(int meterCode) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Electric Bill - Meter code: " + meterCode);
        management.displayBill(meterCode);
        System.out.println("EDIT MENU!");
        System.out.println("\t 1. Change name!");
        System.out.println("\t 2. Change address!");
        System.out.println("\t 3. Change meter code!");
        System.out.println("\t 4. Change previous reading!");
        System.out.println("\t 5. Change current reading!");
        System.out.println("\t 0. Back to MAIN MENU!");
        System.out.println("------------------------------------------------------------------------");
        System.out.print(cst.MAKE_CHOICE);
    }
}
