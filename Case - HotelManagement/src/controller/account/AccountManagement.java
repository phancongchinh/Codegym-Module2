package controller.account;

import model.Account;
import model.Role;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class AccountManagement implements IAccountManagement {

    private static final List<Account> ACCOUNT_LIST = new LinkedList<>();

    public List<Account> getAccountList() {
        return ACCOUNT_LIST;
    }

    static {
        ACCOUNT_LIST.add(new Account(Role.ADMINISTRATOR, "Account0000", "admin", "admin", true));
        ACCOUNT_LIST.add(new Account(Role.MANAGER, "Staff0001", "Staff0001", "20000101", true));
        ACCOUNT_LIST.add(new Account(Role.STAFF, "Staff0002", "Staff0002", "20000102", true));
        ACCOUNT_LIST.add(new Account(Role.STAFF, "Staff0003", "Staff0003", "20000103", true));
        ACCOUNT_LIST.add(new Account(Role.STAFF, "Staff0004", "Staff0004", "20000104", true));
        ACCOUNT_LIST.add(new Account(Role.STAFF, "Staff0005", "Staff0005", "20000105", true));
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
    public boolean add(Account account) {
        if (account == null) {
            return false;
        }
        ACCOUNT_LIST.add(account);
        return true;
    }

    @Override
    public void add(int index, Account account) {
        ACCOUNT_LIST.add(index, account);
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
        System.out.println(ENTER_ACCOUNT_ROLE);
        Role role = Role.valueOf(scanner.nextLine().toUpperCase());
        return new Account(role, accountId, username, password, true);
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
        System.out.println(GATHERING_NEW_INFORMATION_FOR_UPDATING);
        Account newAccount = initFromKeyboard();
        if (newAccount == null) {
            return false;
        } else {
            ACCOUNT_LIST.set(index,newAccount);
            return true;
        }
    }

    @Override
    public Account remove(String accountId) {
        int index = indexOfAccount(accountId);
        return ACCOUNT_LIST.remove(index);
    }

    @Override
    public int indexOfAccount(String accountId) {
        for (Account account : ACCOUNT_LIST) {
            if (account.getAccountId().equals(accountId)) {
                return ACCOUNT_LIST.indexOf(account);
            }
        }
        return -1;
    }

    @Override
    public boolean existAccountId(String accountId) {
        return indexOfAccount(accountId) != -1;
    }

    @Override
    public int indexOfAccount(String username, String password) {
        for (Account account : ACCOUNT_LIST) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return ACCOUNT_LIST.indexOf(account);
            }
        }
        return -1;
    }

    @Override
    public boolean existsAccount(String username, String password) {
        return indexOfAccount(username, password) != -1;
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

    public Account generateAccountAutomatically(Role accountRole, String staffId, LocalDate dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return new Account(accountRole, staffId, staffId, dateOfBirth.format(formatter), true);
    }
}