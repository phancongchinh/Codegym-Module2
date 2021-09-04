package controller.invoice;

import model.invoice.Invoice;

import java.util.LinkedList;
import java.util.List;

public class InvoiceManagement implements IInvoiceManagement {

    private final List<Invoice> invoiceList = new LinkedList<>();

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    private InvoiceManagement(){}

    public static InvoiceManagement getInstance() {
        return InvoiceManagementHelper.INSTANCE;
    }

    private static class InvoiceManagementHelper{
        private static final InvoiceManagement INSTANCE = new InvoiceManagement();
    }

    @Override
    public void add(Invoice invoice) {
        invoiceList.add(invoice);
    }

    @Override
    public Invoice initInvoice() {
        return null;
    }

    @Override
    public void display(String invoiceId) {
        int index = searchInvoiceById(invoiceId);
        System.out.println(invoiceList.get(index));
    }

    @Override
    public void displayAll() {
        for (Invoice invoice : invoiceList) {
            System.out.println(invoice);
        }
    }

    @Override
    public boolean update(String invoiceId) {
        int index = searchInvoiceById(invoiceId);
        System.out.println(GATHERING_NEW_INFORMATION);
        Invoice invoice = initInvoice();
        if (invoice == null) {
            return false;
        } else {
            invoiceList.remove(index);
            invoiceList.add(index,invoice);
            return true;
        }
    }

    @Override
    public void delete(String invoiceId) {
        int index = searchInvoiceById(invoiceId);
        invoiceList.remove(index);
    }

    @Override
    public int searchInvoiceById(String invoiceId) {
        for (Invoice invoice : invoiceList) {
            if (invoice.getInvoiceId().equals(invoiceId)) {
                return invoiceList.indexOf(invoice);
            }
        }
        return -1;
    }

    @Override
    public boolean invoiceIdExisted(String invoiceId) {
        return searchInvoiceById(invoiceId) != -1;
    }
}