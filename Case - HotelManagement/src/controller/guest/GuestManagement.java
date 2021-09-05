package controller.guest;

import controller.person.PersonManagement;
import model.Guest;
import model.PersonalInformation;

import java.util.LinkedList;
import java.util.List;

public class GuestManagement extends PersonManagement implements IGuestManagement {

    private static final List<Guest> GUEST_LIST = new LinkedList<>();

    public List<Guest> getGuestList() {
        return GUEST_LIST;
    }

    private GuestManagement() {
    }

    public static GuestManagement getInstance() {
        return GuestManagementHelper.INSTANCE;
    }

    private static class GuestManagementHelper {
        private static final GuestManagement INSTANCE = new GuestManagement();
    }

    @Override // do not need
    public Guest initFromKeyboard() {
        return null;
    }

    @Override
    public void add(Guest guest) {
    GUEST_LIST.add(guest);
    }

    @Override
    public void display(String id) {
        int index = indexOfGuest(id);
        System.out.println(GUEST_LIST.get(index));
    }

    @Override
    public void displayAll() {
        for (Guest guest : GUEST_LIST) {
            System.out.println(guest);
        }
    }

    @Override  // do not need
    public boolean update(String id) {
        return false;
    }

    @Override
    public void remove(String id) {
        int index = indexOfGuest(id);
        GUEST_LIST.remove(index);
    }

    @Override
    public int indexOfGuest(String id) {
        for (Guest guest : GUEST_LIST) {
            if (guest.getPersonalInformation().getId().equals(id)) {
                return GUEST_LIST.indexOf(guest);
            }
        }
        return -1;
    }

    @Override
    public boolean existsGuestId(String id) {
        return indexOfGuest(id) != -1;
    }
}