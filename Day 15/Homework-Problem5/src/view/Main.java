package view;

import controller.Const;
import controller.OurClassManagement;
import controller.StudentManagement;
import model.OurClass;
import model.Student;

import java.io.*;
import java.util.LinkedList;

public class Main implements Const {

    private static final ClassMenu classMenu = new ClassMenu();
    private static final StudentMenu studentMenu = new StudentMenu();

    public static void main(String[] args) {
        int choice;
        do {
            drawMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    classMenu.runClassMenu();
                    break;
                }
                case 2: {
                    studentMenu.runStudentMenu();
                    break;
                }
                case 0: {
                    exportData();
                    System.exit(0);
                }
                default: {
                    break;
                }
            }
        } while (choice  != 0);
    }

    private static void drawMainMenu() {
        System.out.println("\n=============================================================================");
        System.out.println("MAIN MENU!");
        System.out.println("\t 1. Class management!");
        System.out.println("\t 2. Student management!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
        System.out.print(MAKE_CHOICE);
    }

    public static void exportData() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dataFile));
            for (int i = 0; i < StudentManagement.studentList.size(); i++) {
                bufferedWriter.write(StudentManagement.studentList.get(i).toString());
                if (i != StudentManagement.studentList.size() - 1) {
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.close();
        } catch (IOException exception) {
            System.err.println("IO exception while exporting data!");
        }
    }

    public static LinkedList<Student> importData() {
        LinkedList<Student> studentList = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] studentLine = line.split(",");

                OurClass ourClass = new OurClass();
                ourClass.setClassId(studentLine[3]);
                ourClass.setClassName(studentLine[4]);
                OurClassManagement.ourClassList.add(ourClass);

                Student student = new Student();
                student.setId(studentLine[0]);
                student.setName(studentLine[1]);
                student.setDateOfBirth(studentLine[2]);
                student.setMark(Double.parseDouble(studentLine[3]));
                student.setOurClass(ourClass);

                studentList.add(student);
            }
        } catch (IOException exception) {
            System.err.println("IO exception while importing data!");
        }
        return studentList;
    }
}
