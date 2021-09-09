package view;

import view.menuWithoutRole.LoginMenu;

public class Main {

    private static final LoginMenu LOGIN_MENU = LoginMenu.getInstance();

    public static void main(String[] args) {
        LOGIN_MENU.run();
    }
}