package controller.guest;

import controller.personalInformation.PersonalInformationManagement;
import model.Guest;
import model.GuestLevel;
import model.PersonalInformation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GuestManagement implements IGuestManagement {

    private static final PersonalInformationManagement PERSONAL_INFORMATION_MANAGEMENT = PersonalInformationManagement.getInstance();

    private static final Map<String,Guest> GUEST_MAP = new HashMap<>();

    public Map<String,Guest> getGuestMap() {
        return GUEST_MAP;
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
        personalInformation = PERSONAL_INFORMATION_MANAGEMENT.initFromKeyBoard();
        return (personalInformation == null)? null : new Guest(personalInformation);
    }

    @Override
    public boolean add(Guest guest) {
        if (guest == null) {
            return false;
        }
        GUEST_MAP.put(guest.getPersonalInformation().getId(),guest);
        return true;
    }

    @Override
    public void add(int index, Guest guest) {
    }

    @Override
    public void display(String id) {
        System.out.println(GUEST_MAP.get(id));
    }

    @Override
    public void displayAll() {
        for (String id : GUEST_MAP.keySet()) {
            System.out.println(GUEST_MAP.get(id));
        }
    }

    @Override  // do not need
    public boolean update(String id) {
        return false;
    }

    @Override
    public Guest remove(String id) {
        return null;
    }

    @Override
    public Guest findGuest(String id) {
        for (String guestId : GUEST_MAP.keySet()) {
            if (guestId.equals(id)) {
                return GUEST_MAP.get(guestId);
            }
        }
        return null;
    }

    @Override
    public boolean isGuestLevelValid(String string) {
        HashSet<String> values = new HashSet<>();
        for (GuestLevel guestLevel : GuestLevel.values()) {
            values.add(guestLevel.name());
        }
        return values.contains(string.toUpperCase());
    }
}