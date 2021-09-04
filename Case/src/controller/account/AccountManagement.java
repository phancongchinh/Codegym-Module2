package controller.account;

import model.account.Account;
import model.account.AccountRole;

import java.util.LinkedList;
import java.util.List;

public class AccountManagement implements IAccountManagement{

    private static final List<Account> accountList = new LinkedList<>();

    static {
        accountList.add(new Account("admin","admin",true,AccountRole.valueOf("ADMINISTRATOR")));
    }

    private AccountManagement(){}

    public static AccountManagement getInstance() {
        return AccountManagementHelper.INSTANCE;
    }

    private static class AccountManagementHelper{
        private static final AccountManagement INSTANCE = new AccountManagement();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    @Override
    public int searchAccountByUsername(String username) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return accountList.indexOf(account);
            }
        }
        return -1;
    }

    @Override
    public boolean accountExisted(String username, String password) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean usernameExisted(String username) {
        return searchAccountByUsername(username) != -1;
    }

    @Override
    public void switchAccountStatus(String username) {
        int index = searchAccountByUsername(username);
        Account account = accountList.get(index);
        account.setActive(!account.isActive());
    }
}
