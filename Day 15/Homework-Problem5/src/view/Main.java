package view;

import controller.Const;
import model.OurClass;
import model.Student;

import java.io.*;
import java.util.LinkedList;

import static view.OurClassMenu.ourClassManagement;
import static view.StudentMenu.studentManagement;

public class Main implements Const {

    public static StudentMenu studentMenu = new StudentMenu();
    public static OurClassMenu ourClassMenu = new OurClassMenu();

    public static void main(String[] args) {
        int choice;
        do {
            drawMainMenu();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    ourClassMenu.run();
                    break;
                }
                case 2: {
                    studentMenu.run();
                    break;
                }
                case 3: {
                    exportData(DATA_FILE_PATH);
                    break;
                }
                case 4: {
                    importData(DATA_FILE_PATH);
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void exportData(String path) {
        try {
            File data = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(data));
            StringBuilder stringBuilder = new StringBuilder();
            for (Student student : studentManagement.getStudentList()) {
                stringBuilder.append(student).append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            bufferedWriter.write(String.valueOf(stringBuilder));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void importData(String path) {
        try {
            //clear current data
            ourClassManagement.getOurClassList().clear();
            studentManagement.getStudentList().clear();

            //reading data
            File data = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(data));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] studentLine = line.split(",");

                // init class if class ID does not exist
                if (ourClassManagement.searchClassById(studentLine[4]) == -1) {
                    ourClassManagement.getOurClassList().add(new OurClass(studentLine[4],new LinkedList<>()));
                }

                // init student from read data
                Student student = new Student();
                student.setId(studentLine[0]);
                student.setName(studentLine[1]);
                student.setDateOfBirth(studentLine[2]);
                student.setMark(Double.parseDouble(studentLine[3]));
                student.setClassId(studentLine[4]);

                // add student to Student List and Class Student List
                studentManagement.add(student);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void drawMainMenu() {
        System.out.println("\n=============================================================================");
        System.out.println("MAIN MENU!");
        System.out.println("\t 1. Class management!");
        System.out.println("\t 2. Student management!");
        System.out.println("\t 3. Export data!");
        System.out.println("\t 4. Import data!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
    }
}
