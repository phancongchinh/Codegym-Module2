package view.management;

import controller.account.AccountManagement;
import model.Account;
import view.IMenuRun;

public class AccountManagementMenu implements IMenuRun {

    private AccountManagementMenu(){}

    public static AccountManagementMenu getInstance() {
        return AccountManagementMenuHelper.INSTANCE;
    }

    private static class AccountManagementMenuHelper{
        private static final AccountManagementMenu INSTANCE = new AccountManagementMenu();
    }

    private static final AccountManagement ACCOUNT_MANAGEMENT = AccountManagement.getInstance();

    @Override
    public void draw() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("ACCOUNT MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all accounts!");
        System.out.println("\t 2. Searching information of an account!");
        System.out.println("\t 3. Add a new account!");
        System.out.println("\t 4. Edit an account!");
        System.out.println("\t 5. Delete an account!");
        System.out.println("\t 6. Active an account!");
        System.out.println("\t 7. Deactivate an account!");
        System.out.println("\t 0. Back!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            boolean accountListIsEmpty = ACCOUNT_MANAGEMENT.getAccountList().size() == 0;
            switch (choice) {
                case 1: {
                    if (accountListIsEmpty) {
                        System.out.println(ACCOUNT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(ACCOUNT_LIST);
                    ACCOUNT_MANAGEMENT.displayAll();
                    break;
                }
                case 2: {
                    if (accountListIsEmpty) {
                        System.out.println(ACCOUNT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_ACCOUNT);
                    System.out.print(ENTER_ACCOUNT_ID);
                    String accountId = scanner.nextLine();
                    if (ACCOUNT_MANAGEMENT.existAccountId(accountId)) {
                        ACCOUNT_MANAGEMENT.display(accountId);
                    } else {
                        System.out.println(ACCOUNT_ID_NOT_EXISTED);
                    }
                    break;
                }
                case 3: {
                    System.out.println(ADDING_ACCOUNT);
                    Account account = ACCOUNT_MANAGEMENT.initFromKeyboard();
                    if (account != null) {
                        ACCOUNT_MANAGEMENT.add(account);
                        System.out.println(ACCOUNT_ADDED);
                    } else {
                        System.out.println(ACCOUNT_ADDED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 4: {
                    if (accountListIsEmpty) {
                        System.out.println(ACCOUNT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(UPDATING_ACCOUNT);
                    System.out.print(ENTER_ACCOUNT_ID);
                    String accountId = scanner.nextLine();
                    if (ACCOUNT_MANAGEMENT.existAccountId(accountId)) {
                        if (ACCOUNT_MANAGEMENT.update(accountId)) {
                            System.out.println(ACCOUNT_UPDATED);
                        } else {
                            System.out.println(ACCOUNT_UPDATED_UNSUCCESSFULLY);
                        }
                    } else {
                        System.out.println(ACCOUNT_ID_NOT_EXISTED);
                        System.out.println(ACCOUNT_UPDATED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 5: {
                    if (accountListIsEmpty) {
                        System.out.println(ACCOUNT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DELETING_ACCOUNT);
                    System.out.print(ENTER_ACCOUNT_ID);
                    String accountId = scanner.nextLine();
                    if (ACCOUNT_MANAGEMENT.existAccountId(accountId)) {
                        ACCOUNT_MANAGEMENT.remove(accountId);
                        System.out.println(ACCOUNT_DELETED);
                    } else {
                        System.out.println(ACCOUNT_ID_NOT_EXISTED);
                        System.out.println(ACCOUNT_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 6: {
                    if (accountListIsEmpty) {
                        System.out.println(ACCOUNT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(ACTIVATE_AN_ACCOUNT);
                    System.out.print(ENTER_ACCOUNT_ID);
                    String accountId = scanner.nextLine();
                    ACCOUNT_MANAGEMENT.activateAccount(accountId);
                    break;
                }
                case 7: {
                    if (accountListIsEmpty) {
                        System.out.println(ACCOUNT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DEACTIVATE_AN_ACCOUNT);
                    System.out.print(ENTER_ACCOUNT_ID);
                    String accountId = scanner.nextLine();
                    ACCOUNT_MANAGEMENT.deactivateAccount(accountId);
                    break;
                }
                case 0: {
                    System.out.println(TURN_BACK);
                    return;
                }
                default: {
                    System.out.println(INVALID_CHOICE);
                    break;
                }
            }
        } while (choice != 0);
    }
}