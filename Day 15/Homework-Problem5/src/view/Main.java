package view;

import controller.Const;
import model.Student;

import java.io.*;

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
        File data = new File(path);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(data));
            StringBuilder dataString = new StringBuilder();
            for (Student student : StudentMenu.studentManagement.getStudentList()) {
                dataString.append(student).append("\n");
            }
            bufferedWriter.write(dataString.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void importData(String path) {
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
