package controller.account;

import controller.IGeneralManagement;
import model.Account;

public interface IAccountManagement extends IGeneralManagement<Account> {

    int indexOfAccount(String accountId);

    boolean existAccountId(String accountId);

    boolean existsAccount(String username, String password);

    void activateAccount(String accountId);

    void deactivateAccount(String accountId);
}
