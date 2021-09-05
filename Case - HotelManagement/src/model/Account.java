package model;

public class Account {
    private Role role;
    private String accountId;
    private String username;
    private String password;
    private boolean isActive;
//    private String secretCode; // For password recovering

    public Account(Role role, String accountId, String username, String password, boolean isActive) {
        this.role = role;
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        return role + "," + accountId + "," + username + "," + password;
    }
}
