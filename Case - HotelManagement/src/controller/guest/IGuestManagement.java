package controller.guest;

import controller.IGeneralManagement;
import model.Guest;

public interface IGuestManagement extends IGeneralManagement<Guest> {

    Guest findGuest(String personalId);

    boolean isGuestLevelValid(String string);
}
