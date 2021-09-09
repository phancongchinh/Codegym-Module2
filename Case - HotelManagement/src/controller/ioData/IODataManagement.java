package controller.ioData;

import controller.account.AccountManagement;
import controller.guest.GuestManagement;
import controller.invoice.InvoiceManagement;
import controller.room.RoomManagement;
import controller.staff.StaffManagement;
import model.*;

import java.io.*;
import java.time.LocalDate;

public class IODataManagement implements IIODataManagement {

    private static final RoomManagement ROOM_MANAGEMENT = RoomManagement.getInstance();
    private static final InvoiceManagement INVOICE_MANAGEMENT = InvoiceManagement.getInstance();
    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();
    private static final StaffManagement STAFF_MANAGEMENT = StaffManagement.getInstance();
    private static final AccountManagement ACCOUNT_MANAGEMENT = AccountManagement.getInstance();

    private IODataManagement(){}

    public static IODataManagement getInstance() {
        return IOManagementHelper.INSTANCE;
    }

    private static class IOManagementHelper{
        private static final IODataManagement INSTANCE = new IODataManagement();
    }


    @Override
    public void exportData() throws IOException {
        exportRoomData();
        exportInvoiceData();
        exportGuestData();
        exportStaffData();
        exportAccountData();
    }

    private void exportRoomData() throws IOException {
        File roomDataFile = new File(ROOM_DATA_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomDataFile));
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : ROOM_MANAGEMENT.getRoomList()){
            stringBuilder.append(room).append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }

    private void exportInvoiceData() throws IOException {
        File invoiceDataFile = new File(INVOICE_DATA_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(invoiceDataFile));
        StringBuilder stringBuilder = new StringBuilder();
        for (Invoice invoice : INVOICE_MANAGEMENT.getInvoiceList()){
            stringBuilder.append(invoice).append("\n");
        }
        if (!stringBuilder.toString().equals("")) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }

    private void exportGuestData() throws IOException {
        File guestDataFile = new File(GUEST_DATA_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(guestDataFile));
        StringBuilder stringBuilder = new StringBuilder();
        for (Guest guest : GUEST_MANAGEMENT.getGuestList()){
            stringBuilder.append(guest).append("\n");
        }
        if (!stringBuilder.toString().equals("")) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }

    private void exportStaffData() throws IOException {
        File staffDataFile = new File(STAFF_DATA_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(staffDataFile));
        StringBuilder stringBuilder = new StringBuilder();
        for (Staff staff : STAFF_MANAGEMENT.getStaffList()){
            stringBuilder.append(staff).append("\n");
        }
        if (!stringBuilder.toString().equals("")) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }

    private void exportAccountData() throws IOException {
        File accountDataFile = new File(ACCOUNT_DATA_FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(accountDataFile));
        StringBuilder stringBuilder = new StringBuilder();
        for (Account account : ACCOUNT_MANAGEMENT.getAccountList()){
            stringBuilder.append(account).append("\n");
        }
        if (!stringBuilder.toString().equals("")) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }

    public void importData() throws IOException {
        importRoomData();
        importInvoiceData();
        importGuestData();
        importStaffData();
    }

    private void importGuestData() {
    }

    private void importRoomData() throws IOException {
        // clear current data
        ROOM_MANAGEMENT.getRoomList().clear();

        //reading data
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

            // init room from read data
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setId(invoiceLine[1]);
            personalInformation.setName(invoiceLine[2]);
            personalInformation.setDateOfBirth(LocalDate.parse(invoiceLine[3]));
            Guest guest = new Guest(personalInformation);

            Invoice invoice = new Invoice();
            invoice.setInvoiceId(invoiceLine[0]);
            invoice.setGuest(guest);
//            invoice.setRoomId(invoiceLine[4]);
//            invoice.setStaffId(invoiceLine[5]);
            invoice.setInvoiceDate(LocalDate.parse(invoiceLine[6]));
            invoice.setDueDate(LocalDate.parse(invoiceLine[7]));

            // add invoice to the invoice list
            INVOICE_MANAGEMENT.getInvoiceList().add(invoice);
            GUEST_MANAGEMENT.add(guest);
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

            // init room from read data
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setId(staffLine[0]);
            personalInformation.setName(staffLine[1]);
            personalInformation.setDateOfBirth(LocalDate.parse(staffLine[2]));

            Account account = new Account();
            account.setAccountRole(Role.valueOf(staffLine[5]));
            account.setAccountId(staffLine[6]);
            account.setUsername(staffLine[7]);
            account.setPassword(staffLine[8]);
            account.setActive(Boolean.getBoolean(staffLine[9]));

            Staff staff = new Staff();
            staff.setPersonalInformation(personalInformation);
            staff.setStaffId(staffLine[3]);
            staff.setRole(Role.valueOf(staffLine[4]));
            staff.setAccount(account);
            staff.setSales(Double.parseDouble(staffLine[10]));

            // add staff and account to their lists
            ACCOUNT_MANAGEMENT.add(account);
            STAFF_MANAGEMENT.add(staff);
        }
        bufferedReader.close();
    }
}