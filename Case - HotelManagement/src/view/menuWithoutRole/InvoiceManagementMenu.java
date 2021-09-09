package view.menuWithoutRole;

import controller.invoice.InvoiceManagement;
import model.Invoice;
import model.Month;

public class InvoiceManagementMenu implements IMenuWithoutRole {

    private static final InvoiceManagement INVOICE_MANAGEMENT = InvoiceManagement.getInstance();

    private InvoiceManagementMenu(){}

    public static InvoiceManagementMenu getInstance() {
        return InvoiceMenuHelper.INSTANCE;
    }

    private static class InvoiceMenuHelper{
        private static final InvoiceManagementMenu INSTANCE = new InvoiceManagementMenu();
    }


    @Override
    public void draw() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("INVOICE MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all invoices!");
        System.out.println("\t 2. Searching information of an invoice!");
        System.out.println("\t 3. Add a new invoice!");
        System.out.println("\t 4. Edit information of an invoice!");
        System.out.println("\t 5. Pay for an invoice!");
        System.out.println("\t 6. Sales by month!");
        System.out.println("\t 0. Back!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        String choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextLine();
            handleChoice(choice);
        } while (!choice.equals("0"));
    }

    @Override
    public void handleChoice(String choice) {
        boolean invoiceListIsEmpty = INVOICE_MANAGEMENT.getInvoiceList().size() == 0;
        switch (choice) {
            case "1": {
                if (invoiceListIsEmpty) {
                    System.out.println(INVOICE_LIST_EMPTY);
                    break;
                }
                System.out.println(INVOICE_LIST);
                INVOICE_MANAGEMENT.displayAll();
                break;
            }
            case "2": {
                if (invoiceListIsEmpty) {
                    System.out.println(INVOICE_LIST_EMPTY);
                    break;
                }
                System.out.println(SEARCH_INVOICE);
                System.out.print(ENTER_INVOICE_ID);
                String invoiceId = scanner.nextLine();
                if (INVOICE_MANAGEMENT.existsInvoiceId(invoiceId)) {
                    INVOICE_MANAGEMENT.display(invoiceId);
                } else {
                    System.out.println(INVOICE_ID_NOT_EXISTED);
                }
                break;
            }
            case "3": {
                System.out.println(ADDING_INVOICE);
                Invoice invoice = INVOICE_MANAGEMENT.initFromKeyboard();
                if (invoice != null) {
                    INVOICE_MANAGEMENT.add(invoice);
                    System.out.println(INVOICE_ADDED);
                } else {
                    System.out.println(INVOICE_ADDED_UNSUCCESSFULLY);
                }
                break;
            }
            case "4": {
                if (invoiceListIsEmpty) {
                    System.out.println(INVOICE_LIST_EMPTY);
                    break;
                }
                System.out.println(UPDATING_INVOICE);
                System.out.print(ENTER_INVOICE_ID);
                String invoiceId = scanner.nextLine();
                if (INVOICE_MANAGEMENT.existsInvoiceId(invoiceId)) {
                    INVOICE_MANAGEMENT.update(invoiceId);
                    System.out.println(INVOICE_UPDATED);
                } else {
                    System.out.println(INVOICE_ID_NOT_EXISTED);
                    System.out.println(INVOICE_UPDATED_UNSUCCESSFULLY);
                }
                break;
            }
            case "5": {
                if (invoiceListIsEmpty) {
                    System.out.println(INVOICE_LIST_EMPTY);
                    break;
                }
                System.out.println(PAYING_FOR_AN_INVOICE);
                System.out.print(ENTER_INVOICE_ID);
                String roomId = scanner.nextLine();
                if (INVOICE_MANAGEMENT.existsInvoiceId(roomId)) {
                    INVOICE_MANAGEMENT.remove(roomId);
                    System.out.println(INVOICE_PAID);
                } else {
                    System.out.println(INVOICE_ID_NOT_EXISTED);
                    System.out.println(INVOICE_PAID_UNSUCCESSFULLY);
                }
                break;
            }
            case "6": {
                if (invoiceListIsEmpty) {
                    System.out.println(INVOICE_LIST_EMPTY);
                    break;
                }
                System.out.println(LIST_INVOICES_BY_MONTH);
                System.out.print(ENTER_MONTH);
                String inputMonth = scanner.nextLine().toUpperCase();
                if (INVOICE_MANAGEMENT.getMonthEnums().contains(inputMonth)) {
                    INVOICE_MANAGEMENT.calculateSalesByMonth(Month.valueOf(inputMonth));
                } else {
                    System.out.println(MONTH_NAME_DOES_NOT_EXIST);
                }
                break;
            }
            case "0": {
                System.out.println(TURN_BACK);
                return;
            }
            default: {
                System.out.println(INVALID_CHOICE);
                break;
            }
        }
    }
}
