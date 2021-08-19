import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {

    private static final Scanner scanner = Main.scanner;

    private final ArrayList<LibraryCard> libraryCards = new ArrayList<>();

    public LibraryManagement() {
    }

    private Student initStudent() {
        Student student = new Student();
        Main.request(Const.NAME);
        student.setName(scanner.nextLine());
        Main.request(Const.STUDENT_ID);
        int studentId = scanner.nextInt();
        while (studentIdExisted(studentId)) {
            System.out.print(Const.STUDENT_ID_EXISTED);
            studentId = scanner.nextInt();
        }
        student.setStudentId(studentId);
        scanner.nextLine();
        Main.request(Const.DATE_OF_BIRTH);
        student.setDateOfBirth(LocalDate.parse(scanner.nextLine()));
        Main.request(Const.CLASS_NAME);
        student.setClassName(scanner.nextLine());
        return student;
    }

    private String initCardNumber() {
        Main.request(Const.CARD_NUMBER);
        String cardNumber = scanner.nextLine();
        while (cardNumberExisted(cardNumber)) {
            System.out.print(Const.CARD_NUMBER_EXISTED);
            cardNumber = scanner.nextLine();
        }
        return cardNumber;
    }

    private String initBookNumber() {
        Main.request(Const.BOOK_NUMBER);
        String bookNumber = scanner.nextLine();
        while (bookNumberExisted(bookNumber)) {
            System.out.print(Const.BOOK_NUMBER_EXISTED);
            bookNumber = scanner.nextLine();
        }
        return bookNumber;
    }

    private LocalDate initDateOfBorrowing() {
        Main.request(Const.DATE_OF_BORROWING);
        LocalDate dateOfBorrowing = LocalDate.parse(scanner.nextLine());
        while (dateOfBorrowing.isAfter(LocalDate.now())) {
            System.out.println(Const.INVALID_DATE_OF_BORROWING_TIME);
            dateOfBorrowing = LocalDate.parse(scanner.nextLine());
        }
        return dateOfBorrowing;
    }

    private int initBorrowingTime() {
        Main.request(Const.BORROWING_TIME);
        int borrowingTime = scanner.nextInt();
        while (borrowingTime <= 0) {
            System.out.println(Const.INVALID_BORROWING_TIME);
            borrowingTime = scanner.nextInt();
        }
        return borrowingTime;
    }

    private LibraryCard initLibraryCard() {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setStudent(initStudent());
        libraryCard.setCardNumber(initCardNumber());
        libraryCard.setBookNumber(initBookNumber());
        libraryCard.setDateOfBorrowing(initDateOfBorrowing());
        libraryCard.setBorrowingTime(initBorrowingTime());
        return libraryCard;
    }

    public void add() {
        LibraryCard libraryCard = initLibraryCard();
        libraryCards.add(libraryCard);
    }

    public void display(int studentId) {
        if (!studentIdExisted(studentId)) {
            System.out.print(Const.STUDENT_ID_NOT_EXIST);
        } else {
            int index = searchByStudentId(studentId);
            System.out.println(libraryCards.get(index));
        }
    }

    public void displayAll() {
        if (libraryCards.size() == 0) {
            System.out.println(Const.EMPTY_LIST);
        } else {
            System.out.println(Const.CURRENT_LIST);
            for (int i = 0; i < libraryCards.size(); i++) {
                System.out.println("Student " + (i + 1) + libraryCards.get(i));
            }
        }
    }

    public void edit(int id) {
        int index = searchByStudentId(id);
        LibraryCard theCard = libraryCards.get(index);
        int choice;
        do {
            Main.drawEditMenu(id);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    Main.request(Const.NEW_NAME);
                    theCard.getStudent().setName(scanner.nextLine());
                    break;
                case 2:
                    Main.request(Const.NEW_STUDENT_ID);
                    theCard.getStudent().setStudentId(scanner.nextInt());
                    return;
                case 3:
                    scanner.nextLine();
                    Main.request(Const.NEW_DATE_OF_BIRTH);
                    theCard.getStudent().setDateOfBirth(LocalDate.parse(scanner.nextLine()));
                    break;
                case 4:
                    scanner.nextLine();
                    Main.request(Const.NEW_CLASS_NAME);
                    theCard.getStudent().setClassName(scanner.nextLine());
                    break;
                case 5:
                    scanner.nextLine();
                    Main.request(Const.NEW_CARD_NUMBER);
                    theCard.setCardNumber(scanner.nextLine());
                    break;
                case 6:
                    scanner.nextLine();
                    Main.request(Const.NEW_BOOK_NUMBER);
                    theCard.setBookNumber(scanner.nextLine());
                    break;
                case 7:
                    scanner.nextLine();
                    Main.request(Const.NEW_DATE_OF_BORROWING);
                    theCard.setDateOfBorrowing(LocalDate.parse(scanner.nextLine()));
                    break;
                case 8:
                    Main.request(Const.NEW_BORROWING_TIME);
                    theCard.setBorrowingTime(scanner.nextInt());
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public void delete(int studentId) {
        if (!studentIdExisted(studentId)) {
            System.out.print(Const.STUDENT_ID_NOT_EXIST);
        } else {
            int index = searchByStudentId(studentId);
            libraryCards.remove(index);
        }
    }

    public boolean studentIdExisted(int studentId) {
        return searchByStudentId(studentId) != -1;
    }

    public boolean cardNumberExisted(String cardNumber) {
        return searchByCardNumber(cardNumber) != -1;
    }

    public boolean bookNumberExisted(String bookNumber) {
        return searchByBookNumber(bookNumber) != -1;
    }

    private int searchByStudentId(int studentId) {
        for (int i = 0; i < libraryCards.size(); i++) {
            boolean studentIdExisted = libraryCards.get(i).getStudent().getStudentId() == studentId;
            if (studentIdExisted) {
                return i;
            }
        }
        return -1;
    }

    private int searchByCardNumber(String cardNumber) {
        for (int i = 0; i < libraryCards.size(); i++) {
            boolean cardNumberExisted = libraryCards.get(i).getCardNumber().compareTo(cardNumber) == 0;
            if (cardNumberExisted) {
                return i;
            }
        }
        return -1;
    }

    private int searchByBookNumber(String bookNumber) {
        for (int i = 0; i < libraryCards.size(); i++) {
            boolean bookNumberExisted = libraryCards.get(i).getBookNumber().compareTo(bookNumber) == 0;
            if (bookNumberExisted) {
                return i;
            }
        }
        return -1;
    }
}
