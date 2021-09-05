package model;

import java.time.LocalDate;

public class Invoice {

    private String invoiceId;
    private Guest guest;
    private String roomId;
    private String staffId;
    private LocalDate invoiceDate;
    private LocalDate dueDate;

    public Invoice(String invoiceId, Guest guest, String roomId, String staffId, LocalDate invoiceDate, LocalDate dueDate) {
        this.invoiceId = invoiceId;
        this.guest = guest;
        this.roomId = roomId;
        this.staffId = staffId;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", guest=" + guest +
                ", roomId='" + roomId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
