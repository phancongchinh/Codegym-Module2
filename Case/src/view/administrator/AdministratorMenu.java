package view.administrator;

import view.IMenu;

public class AdministratorMenu implements IMenu {

    private AdministratorMenu(){}

    public static AdministratorMenu getInstance() {
        return AdministratorMenuHelper.INSTANCE;
    }

    private static class AdministratorMenuHelper{
        private static final AdministratorMenu INSTANCE = new AdministratorMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n=============================================================================");
        System.out.println("ADMINISTRATOR MENU!");
        System.out.println("\t 1. Apartment management!");
        System.out.println("\t 2. Invoice management!");
        System.out.println("\t 3. Staff management!");
        System.out.println("\t 4. Guest management!");
        System.out.println("\t 0. Exit!");
        System.out.println("=============================================================================");
    }

    @Override
    public void run() {

    }
}
