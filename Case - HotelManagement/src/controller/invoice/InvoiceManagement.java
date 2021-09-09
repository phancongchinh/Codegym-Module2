package controller.invoice;

import controller.room.RoomManagement;
import controller.guest.GuestManagement;
import controller.staff.StaffManagement;
import model.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class InvoiceManagement implements IInvoiceManagement {

    private static final RoomManagement ROOM_MANAGEMENT = RoomManagement.getInstance();
    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();
    private static final StaffManagement STAFF_MANAGEMENT = StaffManagement.getInstance();

    private static final List<Invoice> INVOICE_LIST = new LinkedList<>();

    public List<Invoice> getInvoiceList() {
        return INVOICE_LIST;
    }

    private InvoiceManagement() {
    }

    public static InvoiceManagement getInstance() {
        return InvoiceManagementHelper.INSTANCE;
    }

    private static class InvoiceManagementHelper {
        private static final InvoiceManagement INSTANCE = new InvoiceManagement();
    }

    @Override
    public void add(Invoice invoice) {
        INVOICE_LIST.add(invoice);
        GUEST_MANAGEMENT.add(invoice.getGuest()); // add the guest to the guest list

        int index = ROOM_MANAGEMENT.indexOfRoom(invoice.getRoom().getRoomId());
        ROOM_MANAGEMENT.getRoomList().get(index).setRoomState(RoomState.OCCUPIED); // set the room state be OCCUPIED
    }

    @Override
    public Invoice initFromKeyboard() {
        System.out.print(ENTER_INVOICE_ID);
        String invoiceId = scanner.nextLine();
        if (existsInvoiceId(invoiceId)) {
            System.out.println(INVOICE_ID_EXISTED);
            return null;
        }
        // init guest, exception already handled
        System.out.println(GATHERING_GUEST_INFORMATION);
        Guest guest = GUEST_MANAGEMENT.initFromKeyboard();
        if (guest == null) {
            return null;
        }
        // select room
        System.out.print(ENTER_ROOM_ID);
        String roomId = scanner.nextLine();
        if (!ROOM_MANAGEMENT.existsRoomId(roomId)) {
            System.out.println(ROOM_ID_NOT_EXISTED);
            return null;
        }
        int roomIndex = ROOM_MANAGEMENT.indexOfRoom(roomId);
        Room room = ROOM_MANAGEMENT.getRoomList().get(roomIndex);
        if (room.getRoomState().equals(RoomState.OCCUPIED)) {
            System.out.println(THE_ROOM_HAS_BEEN_OCCUPIED);
            return null;
        }
        // select staff
        System.out.print(ENTER_STAFF_ID);
        String staffId = scanner.nextLine();
        if (!STAFF_MANAGEMENT.existsStaffId(staffId)) {
            System.out.println(STAFF_ID_NOT_EXISTED);
            return null;
        }
        int staffIndex = STAFF_MANAGEMENT.indexOfStaff(staffId);
        Staff staff = STAFF_MANAGEMENT.getStaffList().get(staffIndex);
        return new Invoice(invoiceId, guest, room, staff);
    }

    @Override
    public void display(String invoiceId) {
        int index = indexOfInvoice(invoiceId);
        System.out.println(INVOICE_LIST.get(index));
    }

    @Override
    public void displayAll() {
        for (Invoice invoice : INVOICE_LIST) {
            System.out.println(invoice);
        }
    }

    @Override
    public boolean update(String invoiceId) {
        // check existence
        if (!existsInvoiceId(invoiceId)) {
            System.out.println(INVOICE_ID_NOT_EXISTED);
            return false;
        }
        //update
        int index = indexOfInvoice(invoiceId);
        System.out.println(GATHERING_NEW_INFORMATION_FOR_UPDATING);
        Invoice invoice = initFromKeyboard();
        if (invoice == null) {
            return false;
        } else {
            INVOICE_LIST.set(index,invoice);
            return true;
        }
    }

    @Override
    public void remove(String invoiceId) { // "Removing invoice" here means "Mark it as paid"!
        int index = indexOfInvoice(invoiceId);
        Invoice invoice = INVOICE_LIST.get(index);
        invoice.setDueDate(LocalDate.now());
        invoice.setPaid(true);

        // set the room state be EMPTY
        invoice.getRoom().setRoomState(RoomState.EMPTY);

        // add totalCharge to staff's sales
        Staff staff = invoice.getStaff();
        staff.setSales(staff.getSales() + invoice.getTotalCharge());
    }

    @Override
    public void calculateSalesByMonth(Month month) {
        LinkedList<Invoice> invoices = new LinkedList<>();
        double totalSales = 0;
        for (Invoice invoice : INVOICE_LIST) {
            if (invoice.getDueDate().getMonth().toString().equals(month.toString())) {
                invoices.add(invoice);
                totalSales += invoice.getTotalCharge();
            }
        }
        if (invoices.size() ==0) {
            System.out.println(THERE_IS_NO_INVOICE_PAID_IN_THAT_MONTH);
        } else {
            for (Invoice invoice : invoices) {
                System.out.println(invoice);
            }
            System.out.println("-----------------------------------------------------------------------------");
            System.out.print(TOTAL_SALES + totalSales);
        }

    }

    @Override
    public int indexOfInvoice(String invoiceId) {
        for (Invoice invoice : INVOICE_LIST) {
            if (invoice.getInvoiceId().equals(invoiceId)) {
                return INVOICE_LIST.indexOf(invoice);
            }
        }
        return -1;
    }

    @Override
    public boolean existsInvoiceId(String invoiceId) {
        return indexOfInvoice(invoiceId) != -1;
    }

    @Override
    public HashSet<String> getMonthEnums() {
        HashSet<String> values = new HashSet<>();
        for (Month month : Month.values()) {
            values.add(month.name());
        }
        return values;
    }
}