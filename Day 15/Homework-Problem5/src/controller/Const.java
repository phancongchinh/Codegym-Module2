package controller;

import java.io.File;
import java.util.Scanner;

public interface Const {

    Scanner scanner = new Scanner(System.in);

    File dataFile = new File("exportedData.txt");

    String NAME = "student's name";
    String NEW_NAME = "new student's name";
    String ID = "student's ID";
    String NEW_ID = "new student's ID";
    String DATE_OF_BIRTH = "student's date of birth";
    String NEW_DATE_OF_BIRTH = "new student's date of birth";
    String CLASS_NAME = "class name";
    String NEW_CLASS_NAME = "new class name";
    String CLASS_ID = "class ID";
    String NEW_CLASS_ID = "new class ID";
    String MARK = "mark";
    String NEW_MARK = "new mark";
    String EXISTED = "The student ID is existed. Try another: ";
    String NOT_EXISTED = "The student ID is NOT existed. Try another: ";

    String MAKE_CHOICE = "Please make a choice: ";
    String STUDENT_EMPTY = "The student list is empty!";
    String CLASS_EMPTY = "The student list is empty!";
    String CURRENT_BY_NAME = "The current student list, sorted by name: ";
    String CURRENT_BY_MARK = "The current student list, sorted by mark: ";
    String ADDING = "ADDING A NEW STUDENT!";
    String ADDED = "STUDENT INFORMATION ADDED SUCCESSFULLY!";
    String DISPLAYING = "DISPLAYING STUDENT INFORMATION! STUDENT'S ID REQUIRED!";
    String SORTED_BY_MARKS = "DISPLAYING STUDENT LIST SORTED BY MARKS";
    String EDITING = "EDITING STUDENT INFORMATION! STUDENT'S ID REQUIRED!";
    String EDITED = "STUDENT INFORMATION EDITED SUCCESSFULLY!";
    String BACK = "TURNING BACK TO MAIN MENU!";
    String DELETING = "DELETING A STUDENT! STUDENT'S ID REQUIRED!";
    String DELETED = "STUDENT INFORMATION DELETED SUCCESSFULLY!";
}
