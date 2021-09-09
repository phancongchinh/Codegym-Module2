package controller.room;

import controller.IGeneralManagement;
import model.Room;
import model.RoomLevel;
import model.RoomState;
import model.RoomType;

import java.util.HashSet;

public interface IRoomManagement extends IGeneralManagement<Room> {

    int indexOfRoom(String roomId);

    boolean existsRoomId(String roomId);

    void listByState(RoomState roomState);

    void listByLevel(RoomLevel roomLevel);

    void listByType(RoomType roomType);

    void listByPrice(Double min, Double max);

    HashSet<String> getRoomStateEnums();

    HashSet<String> getRoomLevelEnums();

    HashSet<String> getRoomTypeEnums();

}
