import java.util.Scanner;

public interface Const {

    Scanner scanner = new Scanner(System.in);

    String NAME = "name";
    String NEW_NAME = "new name";
    String STUDENT_ID = "student ID";
    String NEW_STUDENT_ID = "new student ID";
    String HOMETOWN = "hometown";
    String NEW_HOMETOWN = "new hometown";
    String CLASS_NAME = "class name";
    String NEW_CLASS_NAME = "new class name";
    String MARK = "mark";
    String NEW_MARK = "new mark";
    String EXISTED = "The student ID is existed. Try another: ";
    String NOT_EXISTED = "The student ID is NOT existed. Try another: ";

    String MAKE_CHOICE = "Please make a choice: ";
    String EMPTY = "The student list is empty!";
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
