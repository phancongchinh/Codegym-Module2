package view.menuWithoutRole;

import controller.account.AccountManagement;

import model.Account;
import model.Role;

import view.menuByRole.AdministratorMenu;
import view.menuByRole.ManagerMenu;
import view.menuByRole.StaffMenu;

public class LoginMenu implements IMenuWithoutRole {

    private static final AccountManagement ACCOUNT_MANAGEMENT = AccountManagement.getInstance();
    private static final AdministratorMenu ADMINISTRATOR_MENU = AdministratorMenu.getInstance();
    private static final ManagerMenu MANAGER_MENU = ManagerMenu.getInstance();
    private static final StaffMenu STAFF_MENU = StaffMenu.getInstance();

    private LoginMenu() {
    }

    public static LoginMenu getInstance() {
        return LoginMenuHelper.INSTANCE;
    }

    private static class LoginMenuHelper {
        private static final LoginMenu INSTANCE = new LoginMenu();
    }

    @Override
    public void draw() {
        System.out.println("*****************************************************************************");
        System.out.println("*   HOTEL MANAGEMENT SYSTEM!                                                *");
        System.out.println("*       1. Login!                                                           *");
        System.out.println("*       0. Exit!                                                            *");
        System.out.println("*****************************************************************************");
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
                System.out.println(ENTER_YOUR_LOGIN_INFORMATION);
                System.out.print(USERNAME);
                String username = scanner.nextLine();
                System.out.print(PASSWORD);
                String password = scanner.nextLine();
                handleLoginInformation(username, password);
                break;
            }
            case "0": {
                System.exit(0);
            }
            default: {
                System.out.println(INVALID_CHOICE);
                break;
            }
        }
    }

    private void handleLoginInformation(String username, String password) {
        int index = ACCOUNT_MANAGEMENT.indexOfAccount(username, password);
        if (index == -1) {
            System.out.println(WRONG_USERNAME_OR_PASSWORD_LOGIN_FAILED);
        } else {
            Account account = ACCOUNT_MANAGEMENT.getAccountList().get(index);
            if (!account.isActive()) {
                System.out.println(YOUR_ACCOUNT_HAS_NOT_BEEN_ACTIVATED);
            } else {
                handleAccountRole(account);
            }
        }
    }

    private void handleAccountRole(Account account) {
        Role accountRole = account.getAccountRole();
        switch (accountRole) {
            case ADMINISTRATOR: {
                System.out.println(LOGGED_IN_AS + account.getUsername());
                ADMINISTRATOR_MENU.ranByRole(Role.ADMINISTRATOR);
                break;
            }
            case MANAGER: {
                System.out.println(LOGGED_IN_AS + account.getUsername());
                MANAGER_MENU.ranByRole(Role.MANAGER);
                break;
            }
            case STAFF: {
                System.out.println(LOGGED_IN_AS + account.getUsername());
                STAFF_MENU.ranByRole(Role.STAFF);
                break;
            }
        }
    }
}
