package controller.invoice;

import controller.IGeneralManagement;
import model.Invoice;
import model.Month;

public interface IInvoiceManagement extends IGeneralManagement<Invoice> {

    int indexOfInvoice(String invoiceId);

    boolean existsInvoiceId(String invoiceId);

    void calculateSalesByMonth(Month month);

    void payTheInvoice(String invoiceId);

    boolean isMonthValid(String month);
}