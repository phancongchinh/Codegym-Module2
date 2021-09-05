package view.login;

import controller.account.AccountManagement;

import model.Account;
import model.Role;

import view.administrator.AdministratorMenu;
import view.manager.ManagerMenu;
import view.staff.StaffMenuRun;
import view.IMenuRun;

public class LoginMenu implements IMenuRun {

    private static final AccountManagement ACCOUNT_MANAGEMENT  = AccountManagement.getInstance();
    private static final AdministratorMenu ADMINISTRATOR_MENU = AdministratorMenu.getInstance();
    private static final ManagerMenu MANAGER_MENU = ManagerMenu.getInstance();
    private static final StaffMenuRun STAFF_MENU = StaffMenuRun.getInstance();

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
                    if (ACCOUNT_MANAGEMENT.existsAccount(username,password)) {
                        int index = ACCOUNT_MANAGEMENT.indexOfAccount(username);
                        Account account = ACCOUNT_MANAGEMENT.getAccountList().get(index);
                        if (!account.isActive()) {
                            System.out.println("YOUR ACCOUNT HAS NOT BEEN ACTIVATED!");
                            break;
                        }
                        Role accountRole = account.getRole();
                        switch (accountRole) {
                            case ADMINISTRATOR: {
                                System.out.println(LOGGED_IN_AS + username);
                                ADMINISTRATOR_MENU.run();
                                break;
                            }
                            case MANAGER: {
                                System.out.println(LOGGED_IN_AS + username);
                                MANAGER_MENU.run();
                                break;
                            }
                            case STAFF: {
                                System.out.println(LOGGED_IN_AS + username);
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
