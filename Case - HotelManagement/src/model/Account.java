package model;

public class Account {
    private Role accountRole;
    private String accountId;
    private String username;
    private String password;
    private boolean isActive;
//    private String secretCode; // For password recovering

    public Account(){}

    public Account(Role accountRole, String accountId, String username, String password, boolean isActive) {
        this.accountRole = accountRole;
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    public Role getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(Role accountRole) {
        this.accountRole = accountRole;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return accountRole + "," + accountId + "," + username + "," + password + "," + isActive;
    }
}