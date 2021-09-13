package model;

import java.util.Scanner;

public interface Const {

    Scanner scanner = new Scanner(System.in);

    String PRESS_ENTER_TO_CONTINUE = "Press enter to continue...";

    String NO_RESULT = "No result!";
    String MAKE_CHOICE = "Please make a choice: ";
    String GATHERING_NEW_INFORMATION_FOR_UPDATING = "Gathering new information for updating!";

    String ENTER_PHONE_NUMBER = "Enter phone number: ";
    String THIS_PHONE_NUMBER_DOES_NOT_EXIST = "This phone number does not exist!";
    String CONTACT_UPDATED_UNSUCCESSFULLY = "Contact updated unsuccessfully!";
    String ENTER_CONTACT_GROUP = "Enter contact group: ";
    String ENTER_EMAIL_ABC_DEF_XYZ = "Enter email (abc@def.xyz): ";
    String ENTER_DATE_OF_BIRTH_YYYY_MM_DD = "Enter date of birth (yyyy-mm-dd): ";
    String ENTER_ADDRESS = "Enter address: ";
    String ENTER_SEX_MALE_FEMALE = "Enter sex (MALE/FEMALE?): ";
    String ENTER_NAME = "Enter name: ";
}
