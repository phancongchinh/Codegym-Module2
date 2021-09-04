package model.account;

public class Account {
    private String username;
    private String password;
    private boolean isActive;
    private AccountRole accountRole;

    public Account() {

    }

    public Account(String username, String password, boolean isActive, AccountRole accountRole) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.accountRole = accountRole;
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

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
