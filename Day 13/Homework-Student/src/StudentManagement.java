import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StudentManagement implements Const {
    private static final List<Student> studentList = new LinkedList<>();
    private static final MarkComparator markComparator = new MarkComparator();
    private static final IdComparator idComparator = new IdComparator();

    public void add() {
        Student student = initStudent();
        studentList.add(student);
    }

    public void display(int studentId) {
        int index = searchByStudentId(studentId);
        System.out.println(studentList.get(index));
    }

    public void displayAll() {
        if (studentList.size() == 0) {
            System.out.println(EMPTY);
        } else {
            sortByName();
            System.out.println(CURRENT);
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("Student " + (i + 1) + studentList.get(i));
            }
        }

    }

    public void edit(int studentId) {
        int index = searchByStudentId(studentId);
        Student student = studentList.get(index);
        int choice;
        do {
            Main.drawEditMenu(studentId);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    request(NEW_STUDENT_ID);
                    student.setStudentId(scanner.nextInt());
                    return;
                }
                case 2: {
                    scanner.nextLine();
                    request(NEW_NAME);
                    student.setName(scanner.nextLine());
                    sortByName();
                    break;
                }
                case 3: {
                    scanner.nextLine();
                    request(NEW_HOMETOWN);
                    student.setHomeTown(scanner.nextLine());
                    break;
                }
                case 4: {
                    scanner.nextLine();
                    request(NEW_CLASS_NAME);
                    student.setClassName(scanner.nextLine());
                    break;
                }
                case 5: {
                    request(NEW_MARK);
                    student.setMark(scanner.nextDouble());
                    break;
                }
                case 0:
                    return;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public void delete(int studentId) {
        int index = searchByStudentId(studentId);
        studentList.remove(index);
    }

    private Student initStudent() {
        Student student = new Student();
        student.setStudentId(initStudentId());
        scanner.nextLine();
        student.setName(initName());
        student.setHomeTown(initHometown());
        student.setClassName(initClassName());
        student.setMark(initMark());
        return student;
    }

    private int initStudentId() {
        request(STUDENT_ID);
        int studentId = scanner.nextInt();
        while (idExisted(studentId)) {
            System.out.println(EXISTED);
            studentId = scanner.nextInt();
        }
        return studentId;
    }

    private String initName() {
        request(NAME);
        return scanner.nextLine();
    }

    private String initHometown() {
        request(HOMETOWN);
        return scanner.nextLine();
    }

    private String initClassName() {
        request(CLASS_NAME);
        return scanner.nextLine();
    }

    private double initMark() {
        request(MARK);
        return scanner.nextDouble();
    }

    protected void request(String description) {
        System.out.print("Enter " + description + ": ");
    }

    protected boolean idExisted(int studentId) {
        return searchByStudentId(studentId) != -1;
    }

    protected void sortByName() {
        Collections.sort(studentList);
    }

    protected void sortById() {
        studentList.sort(idComparator);
    }

    protected void sortByMark() {
        studentList.sort(markComparator);
    }

    private int searchByStudentId(int studentId) {
        sortById();
        int left = 0;
        int right = studentList.size();
        return binarySearch(studentId, left, right);
    }

    private int binarySearch(int studentId, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (studentId == mid) {
                return mid;
            }
            if (studentId > mid) {
                return binarySearch(studentId, mid + 1, right);
            } else {
                return binarySearch(studentId, left, mid - 1);
            }
        }
        return -1;
    }
}
