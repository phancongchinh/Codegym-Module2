package controller.invoice;

import controller.IGeneralManagement;
import model.Invoice;
import model.Month;

import java.util.HashSet;

public interface IInvoiceManagement extends IGeneralManagement<Invoice> {

    int indexOfInvoice(String invoiceId);

    boolean existsInvoiceId(String invoiceId);

    void calculateSalesByMonth(Month month);

    void payTheInvoice(String invoiceId);

    HashSet<String> getMonthEnums();
}