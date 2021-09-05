package view.management;

import controller.invoice.InvoiceManagement;
import model.Invoice;
import model.Month;
import view.IMenuRun;

import java.util.LinkedList;

public class InvoiceManagementMenu implements IMenuRun {

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
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("INVOICE MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all invoices!");
        System.out.println("\t 2. Searching information of an invoice!");
        System.out.println("\t 3. Add a new invoice!");
        System.out.println("\t 4. Edit information of an invoice!");
        System.out.println("\t 5. Delete information of an invoice!");
        System.out.println("\t 6. List invoices by month!");
        System.out.println("\t 0. Back!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            boolean invoiceListIsEmpty = INVOICE_MANAGEMENT.getInvoiceList().size() == 0;
            switch (choice) {
                case 1: {
                    if (invoiceListIsEmpty) {
                        System.out.println(INVOICE_LIST_EMPTY);
                        break;
                    }
                    System.out.println(INVOICE_LIST);
                    INVOICE_MANAGEMENT.displayAll();
                    break;
                }
                case 2: {
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
                case 3: {
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
                case 4: {
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
                case 5: {
                    if (invoiceListIsEmpty) {
                        System.out.println(INVOICE_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DELETING_INVOICE);
                    System.out.print(ENTER_INVOICE_ID);
                    String roomId = scanner.nextLine();
                    if (INVOICE_MANAGEMENT.existsInvoiceId(roomId)) {
                        INVOICE_MANAGEMENT.remove(roomId);
                        System.out.println(INVOICE_DELETED);
                    } else {
                        System.out.println(INVOICE_ID_NOT_EXISTED);
                        System.out.println(INVOICE_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 6: {
                    if (invoiceListIsEmpty) {
                        System.out.println(INVOICE_LIST_EMPTY);
                        break;
                    }
                    System.out.println(LIST_INVOICES_BY_MONTH);
                    System.out.print(ENTER_MONTH);
                    Month month = Month.valueOf(scanner.nextLine());
                    LinkedList<Invoice> invoices = INVOICE_MANAGEMENT.listByMonth(month);
                    for (Invoice invoice : invoices) {
                        System.out.println(invoice);
                    }
                    break;
                }
                case 0: {
                    System.out.println(TURN_BACK);
                    return;
                }
                default: {
                    System.out.println(INVALID_CHOICE);
                    break;
                }
            }
        } while (choice != 0);
    }
}
