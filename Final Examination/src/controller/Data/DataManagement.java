package controller.Data;

import controller.contact.ContactManagement;
import model.Contact;
import model.PersonalInformation;
import model.Sex;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class DataManagement implements IDataManagement {

    private DataManagement(){}

    public static DataManagement getInstance() {
        return DataManagementHelper.INSTANCE;
    }
    
    private static class DataManagementHelper{
        private static final DataManagement INSTANCE = new DataManagement();
    }

    private static final ContactManagement CONTACT_MANAGEMENT = ContactManagement.getInstance();
    public static final String CONTACTS_TXT = "contacts.txt";


    @Override
    public void exportData() throws IOException {
        File contactDataFile = new File(CONTACTS_TXT);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(contactDataFile));
        // build contact data
        StringBuilder contactsData = new StringBuilder();
        List<Contact> contacts = CONTACT_MANAGEMENT.getContacts();
        for (Contact contact : contacts) {
            contactsData.append(contact).append("\n");
        }
        if (contacts.size() != 0) {
            contactsData.deleteCharAt(contactsData.length() - 1);
        }
        bufferedWriter.write(String.valueOf(contactsData));
        bufferedWriter.close();
    }

    @Override
    public void importData() throws IOException {
        CONTACT_MANAGEMENT.getContacts().clear();

        //import data
        File contactDataFile = new File(CONTACTS_TXT);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(contactDataFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            String[] contactLine = line.split(",");

            // init
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setPhoneNumber(contactLine[0]);
            personalInformation.setName(contactLine[1]);
            personalInformation.setSex(Sex.valueOf(contactLine[2]));
            personalInformation.setAddress(contactLine[3]);
            personalInformation.setDateOfBirth(LocalDate.parse(contactLine[4]));
            personalInformation.setEmail(contactLine[5]);

            Contact contact = new Contact();
            contact.setPersonalInformation(personalInformation);
            contact.setGroup(contactLine[6]);

            CONTACT_MANAGEMENT.add(contact);
        }
        bufferedReader.close();
    }
}
