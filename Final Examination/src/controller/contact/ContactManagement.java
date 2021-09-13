package controller.contact;

import model.Contact;
import model.PersonalInformation;
import model.Sex;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactManagement implements IContactManagement<Contact> {

    public static final String INPUT_INVALID = "Input invalid!";

    private ContactManagement(){}

    public static ContactManagement getInstance() {
        return ContactManagementHelper.INSTANCE;
    }

    private static class ContactManagementHelper{
        private static final ContactManagement INSTANCE = new ContactManagement();
    }

    private static final List<Contact> CONTACTS = new LinkedList<>();

    public List<Contact> getContacts() {
        return CONTACTS;
    }

    @Override
    public Contact initFromKeyboard() throws IllegalArgumentException {
        System.out.print(ENTER_PHONE_NUMBER);
        String phoneNumber = scanner.nextLine();
        System.out.print(ENTER_NAME);
        String name = scanner.nextLine();
        System.out.print(ENTER_SEX_MALE_FEMALE);
        String sexString = scanner.nextLine();
        Sex sex;
        if (isSexValid(sexString)) {
            sex = Sex.valueOf(sexString.toUpperCase());
        } else {
            System.out.println(INPUT_INVALID);
            return null;
        }
        System.out.print(ENTER_ADDRESS);
        String address = scanner.nextLine();
        System.out.print(ENTER_DATE_OF_BIRTH_YYYY_MM_DD);
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.print(ENTER_EMAIL_ABC_DEF_XYZ);
        String email = scanner.nextLine();
        System.out.print(ENTER_CONTACT_GROUP);
        String group = scanner.nextLine();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setPhoneNumber(phoneNumber);
        personalInformation.setName(name);
        personalInformation.setSex(sex);
        personalInformation.setAddress(address);
        personalInformation.setDateOfBirth(dateOfBirth);
        personalInformation.setEmail(email);

        Contact contact = new Contact();
        contact.setPersonalInformation(personalInformation);
        contact.setGroup(group);
        return contact;
    }

    @Override
    public boolean add(Contact contact) {
        if (contact == null) {
            return false;
        }
        CONTACTS.add(contact);
        return true;
    }

    @Override
    public void add(int index, Contact contact) {
        CONTACTS.add(index,contact);
    }

    @Override
    public void display(String number) {
        for (Contact contact : CONTACTS) {
            if (contact.getPersonalInformation().getPhoneNumber().compareTo(number) == 0) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void displayAll() {
        int count = 0;
        for (Contact contact : CONTACTS) {
            System.out.println(contact);
            count++;
            if (count == 5) {
                count = 0;
                System.out.println(PRESS_ENTER_TO_CONTINUE);
                scanner.nextLine();
            }
        }
    }

    @Override
    public boolean update(String phoneNumber) {
        if (!contactExisted(phoneNumber)) {
            System.out.println(THIS_PHONE_NUMBER_DOES_NOT_EXIST);
            return false;
        }
        int index = searchContactByPhoneNumber(phoneNumber);

        Contact contact = remove(phoneNumber);

        System.out.println(GATHERING_NEW_INFORMATION_FOR_UPDATING);
        Contact newContact = initFromKeyboard();
        if (newContact == null) {
            System.out.println(CONTACT_UPDATED_UNSUCCESSFULLY);
            add(index,contact);
            return false;
        } else {
            add(index, newContact);
            return true;
        }
    }

    @Override
    public Contact remove(String phoneNumber) {
        int index = searchContactByPhoneNumber(phoneNumber);
        return CONTACTS.remove(index);
    }
    
    int searchContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : CONTACTS) {
            if (contact.getPersonalInformation().getPhoneNumber().compareTo(phoneNumber) == 0) {
                return CONTACTS.indexOf(contact);
            }
        }
        return -1;
    }

    public boolean contactExisted(String phoneNumber) {
        return searchContactByPhoneNumber(phoneNumber) != -1;
    }

    public boolean isSexValid(String string) {
        HashSet<String> values = new HashSet<>();
        for (Sex sex : Sex.values()) {
            values.add(sex.name());
        }
        return values.contains(string.toUpperCase());
    }
}
