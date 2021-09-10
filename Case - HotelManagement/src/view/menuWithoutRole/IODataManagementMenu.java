package view.menuWithoutRole;

import controller.ioData.IODataManagement;

import java.io.IOException;

public class IODataManagementMenu implements IMenuWithoutRole {

    private static final IODataManagement IO_DATA_MANAGEMENT = IODataManagement.getInstance();

    private IODataManagementMenu(){}

    public static IODataManagementMenu getInstance() {
        return ExportImportMenuHelper.INSTANCE;
    }

    private static class ExportImportMenuHelper{
        private static final IODataManagementMenu INSTANCE = new IODataManagementMenu();
    }

    @Override
    public void draw() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("DATA EXPORT/IMPORT MENU!");
        System.out.println("\t 1. Export data!");
        System.out.println("\t 2. Import data!");
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
        } while (!choice.equals("0"));
    }

    @Override
    public void handleChoice(String choice) {
        switch (choice) {
            case "1": {
                try {
                    IO_DATA_MANAGEMENT.exportData();
                }
                catch (IOException exception) {
                    System.out.println(IO_EXCEPTION_DATA_EXPORTED_UNSUCCESSFULLY);
                    break;
                }
                System.out.println(DATA_EXPORTED_SUCCESSFULLY);
                break;
            }
            case "2": {
                try {
                    IO_DATA_MANAGEMENT.importData();
                }
                catch (IOException exception) {
                    System.out.println(IO_EXCEPTION_DATA_IMPORTED_UNSUCCESSFULLY);
                    break;
                }
                System.out.println(DATA_IMPORTED_SUCCESSFULLY);
                break;
            }
            case "0": {
                System.out.println(TURN_BACK);
                return;
            }
            default: {
                System.out.println(INVALID_CHOICE);
                break;
            }
        }
    }
}
