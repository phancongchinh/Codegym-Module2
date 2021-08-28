package controller;

import java.util.Scanner;

public interface Const {

    Scanner scanner = new Scanner(System.in);

    String DATA_FILE_PATH = "data.txt";

    String NAME = "student's name";
    String NEW_NAME = "new student's name";
    String ID = "student's ID";
    String NEW_ID = "new student's ID";
    String DATE_OF_BIRTH = "student's date of birth";
    String NEW_DATE_OF_BIRTH = "new student's date of birth";
    String CLASS_ID = "class ID";
    String NEW_CLASS_ID = "new class ID";
    String MARK = "mark";
    String NEW_MARK = "new mark";

    String STUDENT_EXISTED = "The student ID is existed.";
    String CLASS_EXISTED = "The class ID is existed.";
    String STUDENT_NOT_EXISTED = "The student ID is NOT existed.";
    String CLASS_NOT_EXISTED = "The class ID is NOT existed.";

    String MAKE_CHOICE = "Please make a choice: ";

    String CLASS_LIST_EMPTY = "The class list is empty!";
    String CLASS_LIST = "Current class list:";
    String STUDENT_LIST_EMPTY = "The student list is empty!";
    String STUDENT_LIST = "Current student list:";
    String STUDENT_LIST_OF_THIS_CLASS_EMPTY = "The student list of this class is empty!";
    String STUDENT_LIST_OF_THIS_CLASS = "Current student list of this class:";

    String STUDENT_LIST_SORTED_BY_NAME_AZ = "The current student list, sorted by name, from A to Z:";
    String STUDENT_LIST_SORTED_BY_NAME_ZA = "The current student list, sorted by name: from Z to A:";
    String STUDENT_LIST_SORTED_BY_MARK = "The current student list, sorted by mark:";
    String STUDENT_HIGHEST_MARK = "The student with highest mark:";

    String ADDING_STUDENT = "ADDING A NEW STUDENT!";
    String ADDING_CLASS = "ADDING A NEW CLASS!";
    String STUDENT_ADDED = "STUDENT INFORMATION ADDED SUCCESSFULLY!";
    String STUDENT_ADDED_UNSUCCESSFULLY = "STUDENT ADDED UNSUCCESSFULLY!";
    String CLASS_ADDED = "CLASS INFORMATION ADDED SUCCESSFULLY!";
    String CLASS_ADDED_UNSUCCESSFULLY = "CLASS ADDED UNSUCCESSFULLY!";

    String GATHERING_NEW_INFORMATION = "GATHERING NEW INFORMATION!";

    String SEARCH_STUDENT = "SEARCHING FOR A STUDENT! STUDENT'S ID REQUIRED!";
    String SEARCH_CLASS = "SEARCHING FOR A CLASS! CLASS'S ID REQUIRED!";
    String EDITING_STUDENT = "EDITING STUDENT INFORMATION! STUDENT'S ID REQUIRED!";
    String STUDENT_EDITED = "STUDENT INFORMATION EDITED SUCCESSFULLY!";
    String STUDENT_EDITED_UNSUCCESSFULLY = "STUDENT INFORMATION EDITED UNSUCCESSFULLY!";
    String EDITING_CLASS = "EDITING CLASS INFORMATION! CLASS'S ID REQUIRED!";
    String CLASS_EDITED = "CLASS INFORMATION EDITED SUCCESSFULLY!";
    String CLASS_EDITED_UNSUCCESSFULLY = "CLASS INFORMATION EDITED UNSUCCESSFULLY!";
    String DELETING_STUDENT = "DELETING A STUDENT! STUDENT'S ID REQUIRED!";
    String DELETING_CLASS = "DELETING A CLASS! CLASS'S ID REQUIRED!";
    String STUDENT_DELETED = "STUDENT INFORMATION DELETED SUCCESSFULLY!";
    String STUDENT_DELETED_UNSUCCESSFULLY = "STUDENT INFORMATION DELETED UNSUCCESSFULLY!";
    String CLASS_DELETED = "CLASS INFORMATION DELETED SUCCESSFULLY!";
    String CLASS_DELETED_UNSUCCESSFULLY = "CLASS INFORMATION DELETED FAILED!";

    String CLASS_DELETING_CONFIRM = "DELETING A CLASS WILL DELETE ALL STUDENT IN CLASS! ARE YOU SURE? (y/n):";
    String TURN_BACK = "TURNING BACK TO MAIN MENU!";
}
