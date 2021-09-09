package controller.account;

import controller.IGeneralManagement;
import model.Account;
import model.Role;

import java.time.LocalDate;

public interface IAccountManagement extends IGeneralManagement<Account> {

    int indexOfAccount(String accountId);

    int indexOfAccount(String accountId, String password);

    boolean existAccountId(String accountId);

    boolean existsAccount(String username, String password);

    void activateAccount(String accountId);

    void deactivateAccount(String accountId);

    Account generateAccountAutomatically(Role accountRole, String staffId, LocalDate dateOfBirth);
}
