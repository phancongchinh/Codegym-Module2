package controller.guest;

import controller.IGeneralManagement;
import model.Guest;

public interface IGuestManagement extends IGeneralManagement<Guest> {
    int indexOfGuest(String id);

    boolean existsGuestId(String id);
}
