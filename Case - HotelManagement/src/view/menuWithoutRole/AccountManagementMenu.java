package view.menuWithoutRole;

import controller.account.AccountManagement;

public class AccountManagementMenu implements IMenuWithoutRole {

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
        System.out.println("\t 3. Active an account!");
        System.out.println("\t 4. Deactivate an account!");
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
        boolean accountListIsEmpty = ACCOUNT_MANAGEMENT.getAccountList().size() == 0;
        switch (choice) {
            case "1": {
                if (accountListIsEmpty) {
                    System.out.println(ACCOUNT_LIST_EMPTY);
                    break;
                }
                System.out.println(ACCOUNT_LIST);
                ACCOUNT_MANAGEMENT.displayAll();
                break;
            }
            case "2": {
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
            case "3": {
                if (accountListIsEmpty) {
                    System.out.println(ACCOUNT_LIST_EMPTY);
                    break;
                }
                System.out.println(ACTIVATING_AN_ACCOUNT);
                System.out.print(ENTER_ACCOUNT_ID);
                String accountId = scanner.nextLine();
                if (ACCOUNT_MANAGEMENT.existAccountId(accountId)) {
                    ACCOUNT_MANAGEMENT.activateAccount(accountId);
                } else {
                    System.out.println(ACCOUNT_ID_NOT_EXISTED);
                }
                break;
            }
            case "4": {
                if (accountListIsEmpty) {
                    System.out.println(ACCOUNT_LIST_EMPTY);
                    break;
                }
                System.out.println(DEACTIVATING_AN_ACCOUNT);
                System.out.print(ENTER_ACCOUNT_ID);
                String accountId = scanner.nextLine();
                if (ACCOUNT_MANAGEMENT.existAccountId(accountId)) {
                    ACCOUNT_MANAGEMENT.deactivateAccount(accountId);
                } else {
                    System.out.println(ACCOUNT_ID_NOT_EXISTED);
                }
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