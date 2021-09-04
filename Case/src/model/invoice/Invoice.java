package model.invoice;

import model.apartment.Apartment;
import model.guest.Guest;
import model.staff.Staff;

public class Invoice {
    private String invoiceId;
    private Apartment apartment;
    private Guest guest;
    private Staff staff;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Double getTotalCharge() {
        Double price = this.apartment.getPrice();
        Long stayingTime = this.guest.getStayingTime();
        return price * stayingTime;
    }

    @Override
    public String toString() {
        return this.invoiceId + ","
                + this.apartment.getApartmentId() + ","
                + this.guest.getPersonalInformation().getName() + ","
                + "$" + this.getTotalCharge();
    }


}
