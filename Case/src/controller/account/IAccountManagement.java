package controller.account;

import model.account.Account;

public interface IAccountManagement {
    int searchAccountByUsername(String username);

    boolean usernameExisted(String username);

    boolean accountExisted(String username, String password);

    void switchAccountStatus(String username);
}
