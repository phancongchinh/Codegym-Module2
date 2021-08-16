import java.util.Scanner;
import java.util.Arrays;

public class ElectricBillsManagement {
    static Scanner scanner = Main.scanner;
    ElectricBill[] electricBills = new ElectricBill[0];

    public void addBill() {
        ElectricBill[] newElectricBills = new ElectricBill[electricBills.length + 1];
        System.arraycopy(electricBills, 0, newElectricBills, 0, electricBills.length);
        Customer customer = requestCustomer();
        int previousReading = requestInt(cst.PR);
        int currentReading = requestInt(cst.CR);
        while(currentReading < previousReading) {
            System.out.print(cst.INPUT_INVALID);
            currentReading = scanner.nextInt();
        }
        newElectricBills[newElectricBills.length - 1] = new ElectricBill(customer,previousReading,currentReading);
        electricBills = newElectricBills;
    }

    public void displayBill(int meterCode) {
        int index = searchByMeterCode(meterCode);
        System.out.println("Customer " + (index +1) + ": " + electricBills[index]);
    }

    public void displayAllBills() {
        if (electricBills.length == 0) {
            System.out.println(cst.CURRENT_LIST_EMPTY);
        } else {
            System.out.println(cst.CURRENT_LIST);
            for (int i = 0; i < electricBills.length; i++) {
                System.out.println("Customer " + (i +1) + ": " + electricBills[i]);
            }
        }
    }

    public void editBill(int meterCode) {
        int choice;
        do {
            Main.drawEditMenu(meterCode);
            ElectricBill theBill = electricBills[searchByMeterCode(meterCode)];
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    String newName = requestString(cst.NEW_NAME);
                    theBill.getCustomer().setName(newName);
                    Main.management.sortByName();
                    break;
                case 2:
                    scanner.nextLine();
                    theBill.getCustomer().setAddress(requestString(cst.NEW_ADD));
                    break;
                case 3:
                    System.out.println(cst.TURN_BACK);
                    theBill.getCustomer().setMeterCode(requestInt(cst.NEW_METER_CODE));
                    return;
                case 4:
                    int newPreviousReading = requestInt(cst.NEW_PR);
                    while (newPreviousReading > theBill.getCurrentReading()) {
                        System.out.print(cst.INPUT_INVALID);
                        newPreviousReading = scanner.nextInt();
                    }
                    theBill.setPreviousReading(newPreviousReading);
                    break;
                case 5:
                    int newCurrentReading = requestInt(cst.NEW_CR);
                    while (newCurrentReading < theBill.getPreviousReading()) {
                        System.out.print(cst.INPUT_INVALID);
                        newCurrentReading = scanner.nextInt();
                    }
                    theBill.setCurrentReading(newCurrentReading);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public void deleteBill(int meterCode) {
        ElectricBill[] newElectricBills = new ElectricBill[electricBills.length - 1];
        int index = searchByMeterCode(meterCode);
        System.arraycopy(electricBills, 0, newElectricBills, 0, index);
        System.arraycopy(electricBills, index + 1, newElectricBills, index, electricBills.length - index - 1);
        electricBills = newElectricBills;
    }

    public int searchByMeterCode(int meterCode) {
        int index = -1;
        for (int i = 0; i < electricBills.length; i++) {
            if (electricBills[i].getCustomer().getMeterCode() == meterCode) {
                index = i;
            }
        }
        return index;
    }

    public boolean doesExist(int meterCode) {
        return searchByMeterCode(meterCode) != -1;
    }

    public void sortByName() {
        Arrays.sort(electricBills);
    }

    public String requestString(String description) {
        System.out.print("\tEnter " + description + ": ");
        return scanner.nextLine();
    }

    public int requestInt(String description) {
        System.out.print("\tEnter " + description + ": ");
        int inputInt = scanner.nextInt();
        while (inputInt < 0) {
            System.out.print(cst.INPUT_INVALID);
            inputInt = scanner.nextInt();
        }
        return inputInt;
    }

    public Customer requestCustomer() {
        String name = requestString(cst.NAME);
        String address = requestString(cst.ADD);
        int meterCode = requestInt(cst.METER_CODE);
        while (Main.management.doesExist(meterCode)) {
            System.out.println(cst.EXISTED);
            meterCode = requestInt(cst.METER_CODE);
        }
        return new Customer(name, address, meterCode);
    }

}
