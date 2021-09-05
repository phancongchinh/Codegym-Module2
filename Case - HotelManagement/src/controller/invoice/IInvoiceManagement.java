package controller.invoice;

import controller.IGeneralManagement;
import model.Invoice;
import model.Month;

import java.util.LinkedList;

public interface IInvoiceManagement extends IGeneralManagement<Invoice> {

    int indexOfInvoice(String invoiceId);

    boolean existsInvoiceId(String invoiceId);

    LinkedList<Invoice> listByMonth(Month month);

    long totalDays(String invoiceId);

    Double totalCharge(String invoiceId);


}