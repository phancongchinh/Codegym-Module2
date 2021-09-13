package view;

import controller.Data.DataManagement;
import controller.contact.ContactManagement;
import model.Contact;

import java.io.IOException;

public class ContactManagementMenu implements IMenu {

    public static final String CONTACT_LIST = "Contact list: ";
    public static final String ADDING_A_NEW_CONTACT = "Adding a new contact: ";
    public static final String CONTACT_ADDED = "Contact added!";
    public static final String CONTACT_UPDATED_UNSUCCESSFULLY1 = "Contact updated unsuccessfully";
    public static final String CONTACT_DOES_NOT_EXIST = "Contact does not exist!";
    public static final String CONTACT_UPDATED = "Contact updated!";
    public static final String DATA_EXPORTED_UNSUCCESSFULLY = "Data exported unsuccessfully!";
    public static final String DATA_EXPORTED = "Data exported!";
    public static final String DATA_IMPORTED_UNSUCCESSFULLY = "Data imported unsuccessfully!";
    public static final String DATA_IMPORTED = "Data imported!";

    private ContactManagementMenu(){}

    public static ContactManagementMenu getInstance() {
        return ContactManagementMenuHelper.INSTANCE;
    }

    private static class ContactManagementMenuHelper {
        private static final ContactManagementMenu INSTANCE = new ContactManagementMenu();
    }

    private static final ContactManagement CONTACT_MANAGEMENT = ContactManagement.getInstance();
    private static final DataManagement DATA_MANAGEMENT = DataManagement.getInstance();

    @Override
    public void draw() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("CONTACT MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all contacts!");
        System.out.println("\t 2. Add a new contact!");
        System.out.println("\t 3. Edit information of a contact!");
        System.out.println("\t 4. Delete information of a contact!");
        System.out.println("\t 5. Searching information of an contact!");
        System.out.println("\t 6. Export data!");
        System.out.println("\t 7. Import data!");
        System.out.println("\t 0. Back!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        String choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextLine();
            handleChoice(choice);
        } while (choice != "0");
    }

    private void handleChoice(String choice) {
        boolean empty = CONTACT_MANAGEMENT.getContacts().size() == 0;
        switch (choice) {
            case "1": {
                if (isContactList(empty)) break;
                System.out.println(CONTACT_LIST);
                CONTACT_MANAGEMENT.displayAll();
                break;
            }
            case "2": {
                System.out.println(ADDING_A_NEW_CONTACT);
                Contact contact = CONTACT_MANAGEMENT.initFromKeyboard();
                if (contact != null) {
                    CONTACT_MANAGEMENT.add(contact);
                    System.out.println(CONTACT_ADDED);
                } else {
                    System.out.println(CONTACT_UPDATED_UNSUCCESSFULLY);
                }
                break;
            }
            case "3": {
                if (isContactList(empty)) break;
                System.out.println();
                System.out.print(ENTER_PHONE_NUMBER);
                String phoneNumber = scanner.nextLine();
                if (CONTACT_MANAGEMENT.contactExisted(phoneNumber)) {
                    if (CONTACT_MANAGEMENT.update(phoneNumber)) {
                        System.out.println(CONTACT_UPDATED);
                    } else {
                        System.out.println(CONTACT_UPDATED_UNSUCCESSFULLY1);
                    }
                } else {
                    System.out.println(CONTACT_DOES_NOT_EXIST);
                }
                break;
            }
            case "4": {
                if (isContactList(empty)) break;
                System.out.println(ENTER_PHONE_NUMBER);
                String phoneNumber = scanner.nextLine();
                if (CONTACT_MANAGEMENT.contactExisted(phoneNumber)) {
                    CONTACT_MANAGEMENT.remove(phoneNumber);
                    System.out.println("Contact deleted!");
                } else {
                    System.out.println(CONTACT_DOES_NOT_EXIST);
                }
                break;
            }
            case "5": {
                if (isContactList(empty)) break;
                break;
            }
            case "6": {
                try {
                    DATA_MANAGEMENT.exportData();
                }
                catch (IOException exception) {
                    System.out.println(DATA_EXPORTED_UNSUCCESSFULLY);
                    break;
                }
                System.out.println(DATA_EXPORTED);
                break;
            }
            case "7": {
                try {
                    DATA_MANAGEMENT.importData();
                }
                catch (IOException exception) {
                    System.out.println(DATA_IMPORTED_UNSUCCESSFULLY);
                    break;
                }
                System.out.println(DATA_IMPORTED);
                break;
            }
            case "8": {
                return;
            }
            default: {
                break;
            }
        }
    }

    private boolean isContactList(boolean empty) {
        if (empty) {
            System.out.println("Contact list is empty!");
            return true;
        }
        return false;
    }
}
