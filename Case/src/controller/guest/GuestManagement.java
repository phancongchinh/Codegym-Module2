package controller.guest;

import model.guest.Guest;

public class GuestManagement implements IGuestManagement {

    private GuestManagement(){}

    public static GuestManagement getInstance() {
        return GuestManagementHelper.INSTANCE;
    }

    private static class GuestManagementHelper{
        private static final GuestManagement INSTANCE = new GuestManagement();
    }

    @Override
    public void add(Guest guest) {

    }

    @Override
    public void display(String id) {

    }

    @Override
    public void displayAll() {

    }

    @Override
    public boolean update(String id) {
        return false;
    }

    @Override
    public void delete(String id) {

    }
}
