package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Invoice {

    private String invoiceId;
    private Guest guest;
    private Room room;
    private Staff staff;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private boolean isPaid;

    public Invoice() {
    }

    public Invoice(String invoiceId, Guest guest, Room room, Staff staff) {
        this.invoiceId = invoiceId;
        this.guest = guest;
        this.room = room;
        this.staff = staff;
        this.invoiceDate = LocalDate.now();
        this.dueDate = LocalDate.now();
        this.isPaid = false;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    private long totalDays() {
        return ChronoUnit.DAYS.between(this.getInvoiceDate(), this.getDueDate());
    }

    public Double getTotalCharge() {
        GuestLevel guestLevel = this.getGuest().getGuestLevel();
        double discount = 0.0;
        switch (guestLevel) {
            case DIAMOND: {
                discount = 0.2;
                break;
            }
            case GOLD: {
                discount = 0.1;
                break;
            }
        }
        return totalDays() * this.getRoom().getPrice() * (1 - discount);
    }

    @Override
    public String toString() {
        return invoiceId + "," +
                guest.getPersonalInformation().getId() + "," +
                room.getRoomId() + "," +
                staff.getStaffId() + "," +
                invoiceDate + "," +
                dueDate + "," +
                isPaid + "," +
                getTotalCharge();
    }
}