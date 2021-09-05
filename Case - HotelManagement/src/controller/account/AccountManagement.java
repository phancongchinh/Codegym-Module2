package controller.account;

import model.Account;
import model.Role;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class AccountManagement implements IAccountManagement {

    private static final List<Account> ACCOUNT_LIST = new LinkedList<>();

    static {
        ACCOUNT_LIST.add(new Account(Role.ADMINISTRATOR,"0001","admin", "admin", true));
    }

    public List<Account> getAccountList() {
        return ACCOUNT_LIST;
    }

    private AccountManagement() {
    }

    public static AccountManagement getInstance() {
        return AccountManagementHelper.INSTANCE;
    }

    private static class AccountManagementHelper {
        private static final AccountManagement INSTANCE = new AccountManagement();
    }

    @Override
    public void add(Account account) {
        ACCOUNT_LIST.add(account);
    }

    @Override
    public Account initFromKeyboard() {
        System.out.print(ENTER_ACCOUNT_ID);
        String accountId = scanner.nextLine();
        if (existAccountId(accountId)) {
            System.out.println(ACCOUNT_ID_EXISTED);
            return null;
        }
        System.out.print(ENTER_ACCOUNT_USERNAME);
        String username = scanner.nextLine();
        System.out.print(ENTER_ACCOUNT_PASSWORD);
        String password = scanner.nextLine();
        return new Account(Role.STAFF,accountId,username,password,true);
    }

    @Override
    public void display(String accountId) {
        int index = indexOfAccount(accountId);
        System.out.println(ACCOUNT_LIST.get(index));
    }

    @Override
    public void displayAll() {
        for (Account account : ACCOUNT_LIST) {
            System.out.println(account);
        }
    }

    @Override
    public boolean update(String accountId) {
        int index = indexOfAccount(accountId);
        System.out.println(GATHERING_NEW_INFORMATION);
        Account account = initFromKeyboard();
        if (account == null) {
            return false;
        } else {
            ACCOUNT_LIST.remove(index);
            ACCOUNT_LIST.add(index,account);
            return true;
        }
    }

    @Override
    public void remove(String accountId) {
        int index = indexOfAccount(accountId);
        ACCOUNT_LIST.remove(index);
    }

    @Override
    public int indexOfAccount(String accountId) {
        for (Account account : ACCOUNT_LIST) {
            if (account.getUsername().equals(accountId)) {
                return ACCOUNT_LIST.indexOf(account);
            }
        }
        return -1;
    }

    @Override
    public boolean existsAccount(String username, String password) {
        for (Account account : ACCOUNT_LIST) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existAccountId(String username) {
        return indexOfAccount(username) != -1;
    }

    @Override
    public void activateAccount(String accountId) {
        int index = indexOfAccount(accountId);
        Account account = ACCOUNT_LIST.get(index);
        if (account.isActive()) {
            System.out.println(THIS_ACCOUNT_IS_ALREADY_ACTIVATED);
        } else {
            account.setActive(true);
            System.out.println(THIS_ACCOUNT_HAS_BEEN_ACTIVATED);
        }
    }

    @Override
    public void deactivateAccount(String accountId) {
        int index = indexOfAccount(accountId);
        Account account = ACCOUNT_LIST.get(index);
        if (!account.isActive()) {
            System.out.println(THIS_ACCOUNT_IS_ALREADY_DEACTIVATED);
        } else {
            account.setActive(false);
            System.out.println(THIS_ACCOUNT_HAS_BEEN_DEACTIVATED);
        }
    }

    public Account generateAccountAutomatically(String staffId, LocalDate dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return new Account(Role.STAFF, staffId, staffId, dateOfBirth.format(formatter), true);
    }
}