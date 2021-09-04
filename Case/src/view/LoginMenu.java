package view;

import controller.account.AccountManagement;
import model.account.Account;
import model.account.AccountRole;
import view.administrator.AdministratorMenu;
import view.manager.ManagerMenu;

public class LoginMenu implements IMenu {

    private static final AccountManagement ACCOUNT_MANAGEMENT  = AccountManagement.getInstance();
    private static final AdministratorMenu ADMINISTRATOR_MENU = AdministratorMenu.getInstance();
    private static final ManagerMenu MANAGER_MENU = ManagerMenu.getInstance();
    private static final Main.StaffMenu STAFF_MENU = Main.StaffMenu.getInstance();

    private LoginMenu(){}

    public static LoginMenu getInstance() {
        return LoginMenuHelper.INSTANCE;
    }

    private static class LoginMenuHelper{
        private static final LoginMenu INSTANCE = new LoginMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n*****************************************************************************");
        System.out.println("HOTEL MANAGEMENT SYSTEM!");
        System.out.println("\t 1. Login!");
        System.out.println("\t 0. Exit!");
        System.out.println("*****************************************************************************");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    System.out.println(ENTER_YOUR_LOGIN_INFORMATION);
                    System.out.print(USERNAME);
                    String username = scanner.nextLine();
                    System.out.print(PASSWORD);
                    String password = scanner.nextLine();
                    if (ACCOUNT_MANAGEMENT.accountExisted(username,password)) {
                        int index = ACCOUNT_MANAGEMENT.searchAccountByUsername(username);
                        Account account = ACCOUNT_MANAGEMENT.getAccountList().get(index);
                        AccountRole accountRole = account.getAccountRole();
                        switch (accountRole) {
                            case ADMINISTRATOR: {
                                System.out.println(LOGGED_IN_AS_ADMINISTRATOR);
                                System.out.println(WELCOME + username);
                                ADMINISTRATOR_MENU.run();
                                break;
                            }
                            case MANAGER: {
                                System.out.println(LOGGED_IN_AS_MANAGER);
                                System.out.println(WELCOME + username);
                                MANAGER_MENU.run();
                                break;
                            }
                            case STAFF: {
                                System.out.println(LOGGED_IN_AS_STAFF);
                                System.out.println(WELCOME + username);
                                STAFF_MENU.run();
                                break;
                            }
                        }
                    } else {
                        System.out.println(WRONG_USERNAME_OR_PASSWORD_LOGIN_FAILED);
                    }
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println(INVALID_CHOICE);
                    break;
                }
            }
        } while (choice != 0);
    }
}
