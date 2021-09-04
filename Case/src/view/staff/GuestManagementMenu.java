package view.staff;

import controller.guest.GuestManagement;
import view.IMenu;

public class GuestManagementMenu implements IMenu {
    private static final GuestManagement GUEST_MANAGEMENT = GuestManagement.getInstance();

    private GuestManagementMenu(){}

    public static GuestManagementMenu getInstance(){
        return GuestManagementHelper.INSTANCE;
    }

    private static class GuestManagementHelper {
        private static final GuestManagementMenu INSTANCE = new GuestManagementMenu();
    }

    @Override
    public void draw() {

    }

    @Override
    public void run() {

    }
}
