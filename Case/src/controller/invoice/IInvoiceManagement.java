package controller.invoice;

import controller.IGeneralManagement;
import model.invoice.Invoice;

public interface IInvoiceManagement extends IGeneralManagement<Invoice> {
    Invoice initInvoice();

    int searchInvoiceById(String invoiceId);

    boolean invoiceIdExisted(String invoiceId);
}
