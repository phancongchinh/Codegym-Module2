package controller.ioData;

import controller.account.AccountManagement;
import controller.guest.GuestManagement;
import controller.invoice.InvoiceManagement;
import controller.room.RoomManagement;
import controller.staff.StaffManagement;
import model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class IODataManagement implements IIODataManagement {

    private static final RoomManagement ROOM_MANAGEMENT = RoomManagement.getInstance();
    private static final InvoiceManagement INVOICE_MANAGEMENT = InvoiceManagement.getInstance();
    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();
    private static final StaffManagement STAFF_MANAGEMENT = StaffManagement.getInstance();
    private static final AccountManagement ACCOUNT_MANAGEMENT = AccountManagement.getInstance();

    private IODataManagement() {
    }

    public static IODataManagement getInstance() {
        return IOManagementHelper.INSTANCE;
    }

    private static class IOManagementHelper {
        private static final IODataManagement INSTANCE = new IODataManagement();
    }


    @Override
    public void exportData() throws IOException {
        exportRoomData();
        exportInvoiceData();
        exportStaffData();
        exportAccountData();
        exportGuestData();
    }

    private void exportInvoiceData() throws IOException {
        File invoiceDataFile = new File(INVOICE_DATA_FILE_PATH);
        BufferedWriter invoiceDataWriter = new BufferedWriter(new FileWriter(invoiceDataFile));
        // build invoice data
        StringBuilder invoiceData = new StringBuilder();
        List<Invoice> invoiceList = INVOICE_MANAGEMENT.getInvoiceList();
        for (Invoice invoice : invoiceList) {
            invoiceData.append(invoice).append("\n");
        }
        if (invoiceList.size() != 0) {
            invoiceData.deleteCharAt(invoiceData.length() - 1);
        }
        invoiceDataWriter.write(String.valueOf(invoiceData));
        invoiceDataWriter.close();
    }

    private void exportStaffData() throws IOException {
        File staffDataFile = new File(STAFF_DATA_FILE_PATH);
        BufferedWriter staffDataWriter = new BufferedWriter(new FileWriter(staffDataFile));
        // build staff data
        StringBuilder staffData = new StringBuilder();
        List<Staff> staffList = STAFF_MANAGEMENT.getStaffList();
        for (Staff staff : staffList) {
            staffData.append(staff).append("\n");
        }
        if (staffList.size() != 0) {
            staffData.deleteCharAt(staffData.length() - 1);
        }
        staffDataWriter.write(String.valueOf(staffData));
        staffDataWriter.close();
    }

    private void exportAccountData() throws IOException {
        File accountDataFile = new File(ACCOUNT_DATA_FILE_PATH);
        BufferedWriter accountDataWriter = new BufferedWriter(new FileWriter(accountDataFile));
        // build account data
        StringBuilder accountData = new StringBuilder();
        List<Account> accountList = ACCOUNT_MANAGEMENT.getAccountList();
        for (Account account : accountList) {
            accountData.append(account).append("\n");
        }
        if (accountList.size() != 0) {
            accountData.deleteCharAt(accountData.length() - 1);
        }
        accountDataWriter.write(String.valueOf(accountData));
        accountDataWriter.close();
    }

    private void exportGuestData() throws IOException {
        File guestDataFile = new File(GUEST_DATA_FILE_PATH);
        BufferedWriter guestDataWriter = new BufferedWriter(new FileWriter(guestDataFile));
        // build guest data
        StringBuilder guestData = new StringBuilder();
        Collection<Guest> guestList = GUEST_MANAGEMENT.getGuestMap().values();
        for (Guest guest : guestList) {
            guestData.append(guest).append("\n");
        }
        if (guestList.size() != 0) {
            guestData.deleteCharAt(guestData.length() - 1);
        }
        guestDataWriter.write(String.valueOf(guestData));
        guestDataWriter.close();
    }

    private void exportRoomData() throws IOException {
        File roomDataFile = new File(ROOM_DATA_FILE_PATH);
        BufferedWriter roomDataWriter = new BufferedWriter(new FileWriter(roomDataFile));
        // build room data
        StringBuilder roomData = new StringBuilder();
        List<Room> roomList =  ROOM_MANAGEMENT.getRoomList();
        for (Room room : roomList) {
            roomData.append(room).append("\n");
        }
        if (roomList.size() != 0) {
            roomData.deleteCharAt(roomData.length() - 1);
        }
        roomDataWriter.write(String.valueOf(roomData));
        roomDataWriter.close();
    }

    public void importData() throws IOException {
        importRoomData();
        importStaffData();
        importAccountData();
        importGuestData();
        importInvoiceData();
    }

    private void importRoomData() throws IOException {
        ROOM_MANAGEMENT.getRoomList().clear();

        //import data
        File roomData = new File(ROOM_DATA_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(roomData));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String[] roomLine = line.split(",");

            // init room from read data
            Room room = new Room();
            room.setRoomId(roomLine[0]);
            room.setRoomState(RoomState.valueOf(roomLine[1]));
            room.setRoomType(RoomType.valueOf(roomLine[2]));
            room.setRoomLevel(RoomLevel.valueOf(roomLine[3]));
            // price will be set automatically depending on type and level
            // add room to the room list
            ROOM_MANAGEMENT.add(room);
        }
        bufferedReader.close();
    }

    private void importInvoiceData() throws IOException {
        // clear current data
        INVOICE_MANAGEMENT.getInvoiceList().clear();

        //reading data
        File invoiceData = new File(INVOICE_DATA_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(invoiceData));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String[] invoiceLine = line.split(",");

            // find guest, room, staff from read IDs
            String guestId  = invoiceLine[1];
            String roomId   = invoiceLine[2];
            String staffId  = invoiceLine[3];
            Guest guest     = GUEST_MANAGEMENT.findGuest(guestId);
            Room room       = ROOM_MANAGEMENT.getRoomList().get(ROOM_MANAGEMENT.indexOfRoom(roomId));
            Staff staff     = STAFF_MANAGEMENT.getStaffList().get(STAFF_MANAGEMENT.indexOfStaff(staffId));

            // init invoice from read data
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(invoiceLine[0]);
            invoice.setGuest(guest);
            invoice.setRoom(room);
            invoice.setStaff(staff);
            invoice.setInvoiceDate(LocalDate.parse(invoiceLine[4]));
            invoice.setDueDate(LocalDate.parse(invoiceLine[5]));
            invoice.setPaid(Boolean.parseBoolean(invoiceLine[6]));

            INVOICE_MANAGEMENT.add(invoice);
        }
        bufferedReader.close();
    }

    private void importStaffData() throws IOException {
        // clear current data
        STAFF_MANAGEMENT.getStaffList().clear();

        //reading data
        File staffData = new File(STAFF_DATA_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(staffData));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String[] staffLine = line.split(",");

            // init staff from read data
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setId(staffLine[0]);
            personalInformation.setName(staffLine[1]);
            personalInformation.setDateOfBirth(LocalDate.parse(staffLine[2]));

            Staff staff = new Staff();
            staff.setPersonalInformation(personalInformation);
            staff.setStaffId(staffLine[3]);
            staff.setRole(Role.valueOf(staffLine[4]));
            staff.setSales(Double.parseDouble(staffLine[5]));

            STAFF_MANAGEMENT.add(staff);
        }
        bufferedReader.close();
    }

    private void importAccountData() throws IOException {
        // clear current data
        ACCOUNT_MANAGEMENT.getAccountList().clear();

        //reading data
        File accountData = new File(ACCOUNT_DATA_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(accountData));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String[] accountLine = line.split(",");

            // init account from read data
            Account account = new Account();
            account.setAccountRole(Role.valueOf(accountLine[0]));
            account.setAccountId(accountLine[1]);
            account.setUsername(accountLine[2]);
            account.setPassword(accountLine[3]);
            account.setActive(Boolean.parseBoolean(accountLine[4]));

            ACCOUNT_MANAGEMENT.add(account);
        }
        bufferedReader.close();
    }

    private void importGuestData() throws IOException {
        // clear current data
        GUEST_MANAGEMENT.getGuestMap().clear();

        //reading data
        File guestData = new File(GUEST_DATA_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(guestData));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String[] guestLine = line.split(",");

            // init guest from read data
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setId(guestLine[0]);
            personalInformation.setName(guestLine[1]);
            personalInformation.setDateOfBirth(LocalDate.parse(guestLine[2]));

            Guest guest = new Guest();
            guest.setPersonalInformation(personalInformation);
            guest.setExpenditure(Double.parseDouble(guestLine[3]));

            GUEST_MANAGEMENT.add(guest);
        }
        bufferedReader.close();
    }
}