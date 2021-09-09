package controller.guest;

import controller.IGeneralManagement;
import model.Guest;

import java.util.HashSet;

public interface IGuestManagement extends IGeneralManagement<Guest> {

    void add(int index, Guest guest);

    int indexOfGuest(String id);

    boolean existsGuestId(String id);

    public HashSet<String> getGuestLevelEnums();
}
