package controller.invoice;

import controller.room.RoomManagement;
import controller.guest.GuestManagement;
import model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

public class InvoiceManagement implements IInvoiceManagement {

    private static final RoomManagement ROOM_MANAGEMENT = RoomManagement.getInstance();
    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();

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

        int index = ROOM_MANAGEMENT.indexOfRoom(invoice.getRoomId());
        ROOM_MANAGEMENT.getRoomList().get(index).setRoomState(RoomState.OCCUPIED); ;// set the room state be OCCUPIED
    }

    @Override
    public Invoice initFromKeyboard() {
        System.out.println(ENTER_INVOICE_ID);
        String invoiceId = scanner.nextLine();
        if (existsInvoiceId(invoiceId)) {
            System.out.println(INVOICE_ID_EXISTED);
            return null;
        }
        // Init Guest
        PersonalInformation personalInformation = GUEST_MANAGEMENT.initFromKeyBoard();

        // select room and staff
        System.out.println(ENTER_ROOM_ID);
        String roomId = scanner.nextLine();

        System.out.println(ENTER_STAFF_ID);
        String staffId = scanner.nextLine();

        System.out.println(ENTER_DATE_OF_CHECKING_OUT);
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        Guest guest = new Guest(personalInformation);

        return new Invoice(invoiceId, guest, roomId, staffId, LocalDate.now(), dueDate);
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
        int index = indexOfInvoice(invoiceId);
        System.out.println(GATHERING_NEW_INFORMATION);
        Invoice invoice = initFromKeyboard();
        if (invoice == null) {
            return false;
        } else {
            INVOICE_LIST.remove(index);
            INVOICE_LIST.add(index, invoice);
            return true;
        }
    }

    @Override
    public void remove(String invoiceId) {
        int index = indexOfInvoice(invoiceId);
        Invoice invoice = INVOICE_LIST.remove(index);

        int roomIndex = ROOM_MANAGEMENT.indexOfRoom(invoice.getRoomId());
        ROOM_MANAGEMENT.getRoomList().get(roomIndex).setRoomState(RoomState.EMPTY); ;// set the room state be OCCUPIED
    }

    @Override
    public LinkedList<Invoice> listByMonth(Month month) {
        LinkedList<Invoice> invoiceListByMonth = new LinkedList<>();
        for (Invoice invoice : INVOICE_LIST) {
            if (invoice.getDueDate().getMonth().toString().equals(month.toString())) {
                invoiceListByMonth.add(invoice);
            }
        }
        return invoiceListByMonth;
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

    public long totalDays(String invoiceId) {
        int index = indexOfInvoice(invoiceId);
        Invoice invoice = INVOICE_LIST.get(index);
        return ChronoUnit.DAYS.between(invoice.getInvoiceDate(),invoice.getDueDate());
    }

    @Override
    public Double totalCharge(String invoiceId) {
        int index = indexOfInvoice(invoiceId);
        Invoice invoice = INVOICE_LIST.get(index);
        String guestId = invoice.getGuest().getPersonalInformation().getId();
        long totalDays = totalDays(guestId);
        String roomId = invoice.getRoomId();
        Double roomPrice = ROOM_MANAGEMENT.priceOf(roomId);
        return totalDays * roomPrice;
    }
}