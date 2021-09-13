import view.ContactManagementMenu;

public class Main {

    private static final ContactManagementMenu CONTACT_MANAGEMENT_MENU = ContactManagementMenu.getInstance();

    public static void main(String[] args) {
        CONTACT_MANAGEMENT_MENU.run();
    }
}
