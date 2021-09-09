package controller.guest;

import controller.personalInformation.PersonalInformationManagement;
import model.Guest;
import model.GuestLevel;
import model.PersonalInformation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GuestManagement implements IGuestManagement {

    private static final PersonalInformationManagement PERSONAL_INFORMATION_MANAGEMENT = PersonalInformationManagement.getInstance();

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

    @Override
    public Guest initFromKeyboard() {
        PersonalInformation personalInformation;
        personalInformation = PERSONAL_INFORMATION_MANAGEMENT.initInformationForA(GUEST);
        return (personalInformation == null)? null : new Guest(personalInformation);
    }

    @Override
    public void add(Guest guest) {
        GUEST_LIST.add(guest);
    }

    @Override
    public void add(int index, Guest guest) {
        GUEST_LIST.add(index, guest);
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

    public HashSet<String> getGuestLevelEnums() {
        HashSet<String> values = new HashSet<>();
        for (GuestLevel guestLevel : GuestLevel.values()) {
            values.add(guestLevel.name());
        }
        return values;
    }
}