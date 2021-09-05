package view;

import view.login.LoginMenu;

import java.util.InputMismatchException;

public class Main {

    private static final LoginMenu LOGIN_MENU = LoginMenu.getInstance();
    public static final String INPUT_MISMATCH_EXCEPTION = "INPUT MISMATCH EXCEPTION!";
    public static final String NUMBER_FORMAT_EXCEPTION = "NUMBER FORMAT EXCEPTION";

    public static void main(String[] args) {
        try {
            LOGIN_MENU.run();
        } catch (InputMismatchException e) {
            System.err.println(INPUT_MISMATCH_EXCEPTION);
        }
        catch (NumberFormatException e) {
            System.err.println(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
