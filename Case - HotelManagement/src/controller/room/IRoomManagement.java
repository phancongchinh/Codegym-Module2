package controller.room;

import controller.IGeneralManagement;
import model.Room;
import model.RoomLevel;
import model.RoomState;
import model.RoomType;

import java.util.LinkedList;

public interface IRoomManagement extends IGeneralManagement<Room> {

    int indexOfRoom(String roomId);

    boolean existsRoomId(String roomId);

    LinkedList<Room> listByState(RoomState roomState);

    LinkedList<Room> listByLevel(RoomLevel roomLevel);

    LinkedList<Room> listByType(RoomType roomType);

    LinkedList<Room> listByPrice(Double min, Double max);

    Double priceOf(String roomId);

}
