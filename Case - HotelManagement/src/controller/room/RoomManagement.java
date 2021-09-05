package controller.room;

import model.Room;
import model.RoomLevel;
import model.RoomState;
import model.RoomType;

import java.util.LinkedList;
import java.util.List;

public class RoomManagement implements IRoomManagement {

    private static final List<Room> ROOM_LIST = new LinkedList<>();

    static {
        ROOM_LIST.add(new Room("R0101",RoomState.EMPTY,RoomType.SINGLE,RoomLevel.STANDARD));
        ROOM_LIST.add(new Room("R0102",RoomState.EMPTY,RoomType.SINGLE,RoomLevel.DELUXE));
        ROOM_LIST.add(new Room("R0103",RoomState.EMPTY,RoomType.SINGLE,RoomLevel.LUXURY));
        ROOM_LIST.add(new Room("R0104",RoomState.EMPTY,RoomType.DOUBLE,RoomLevel.STANDARD));
        ROOM_LIST.add(new Room("R0105",RoomState.EMPTY,RoomType.DOUBLE,RoomLevel.DELUXE));
        ROOM_LIST.add(new Room("R0106",RoomState.EMPTY,RoomType.DOUBLE,RoomLevel.LUXURY));
        ROOM_LIST.add(new Room("R0201",RoomState.EMPTY,RoomType.SINGLE,RoomLevel.STANDARD));
        ROOM_LIST.add(new Room("R0202",RoomState.EMPTY,RoomType.SINGLE,RoomLevel.DELUXE));
        ROOM_LIST.add(new Room("R0203",RoomState.EMPTY,RoomType.SINGLE,RoomLevel.LUXURY));
        ROOM_LIST.add(new Room("R0204",RoomState.EMPTY,RoomType.DOUBLE,RoomLevel.STANDARD));
        ROOM_LIST.add(new Room("R0205",RoomState.EMPTY,RoomType.DOUBLE,RoomLevel.DELUXE));
        ROOM_LIST.add(new Room("R0206",RoomState.EMPTY,RoomType.DOUBLE,RoomLevel.LUXURY));
    }

    public List<Room> getRoomList() {
        return ROOM_LIST;
    }

    private RoomManagement() {
    }

    public static RoomManagement getInstance() {
        return RoomManagementHelper.INSTANCE;
    }

    private static class RoomManagementHelper {
        private static final RoomManagement INSTANCE = new RoomManagement();
    }

    @Override
    public void add(Room room) {
        ROOM_LIST.add(room);
    }

    @Override
    public Room initFromKeyboard() {
        System.out.println(ENTER_ROOM_ID);
        String roomId = scanner.nextLine();
        if (existsRoomId(roomId)) {
            System.out.println(ROOM_ID_EXISTED);
            return null;
        }
        System.out.println(ENTER_ROOM_STATE);
        RoomState roomState = RoomState.valueOf(scanner.nextLine().toUpperCase());
        System.out.println(ENTER_ROOM_LEVEL);
        RoomLevel roomLevel = RoomLevel.valueOf(scanner.nextLine().toUpperCase());
        System.out.println(ENTER_ROOM_TYPE);
        RoomType roomType = RoomType.valueOf(scanner.nextLine().toUpperCase());

        return new Room(roomId, roomState, roomType, roomLevel);
    }

    @Override
    public void display(String roomId) {
        int index = indexOfRoom(roomId);
        System.out.println(ROOM_LIST.get(index));
    }

    @Override
    public void displayAll() {
        for (Room room : ROOM_LIST) {
            System.out.println(room);
        }
    }

    @Override
    public boolean update(String roomId) {
        int index = indexOfRoom(roomId);
        System.out.println(GATHERING_NEW_INFORMATION);
        Room room = initFromKeyboard();
        if (room == null) {
            return false;
        } else {
            ROOM_LIST.remove(index);
            ROOM_LIST.add(index, room);
            return true;
        }
    }

    @Override
    public void remove(String roomId) {
        int index = indexOfRoom(roomId);
        ROOM_LIST.remove(index);
    }

    @Override
    public int indexOfRoom(String roomId) {
        for (Room room : ROOM_LIST) {
            if (room.getRoomId().equals(roomId)) {
                return ROOM_LIST.indexOf(room);
            }
        }
        return -1;
    }

    @Override
    public boolean existsRoomId(String roomId) {
        return indexOfRoom(roomId) != -1;
    }

    @Override
    public LinkedList<Room> listByState(RoomState roomState) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getRoomState().equals(roomState)) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    @Override
    public LinkedList<Room> listByLevel(RoomLevel roomLevel) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getRoomLevel().equals(roomLevel)) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    @Override
    public LinkedList<Room> listByType(RoomType roomType) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getRoomType().equals(roomType)) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    @Override
    public LinkedList<Room> listByPrice(Double min, Double max) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (priceOf(room.getRoomId()) < max && priceOf(room.getRoomId()) > min) {
                rooms.add(room);
            }
        }
        return rooms;
    }

    @Override
    public Double priceOf(String roomId) {
        int index = indexOfRoom(roomId);
        Room room = ROOM_LIST.get(index);
        RoomType roomType = room.getRoomType();
        RoomLevel roomLevel = room.getRoomLevel();
        switch (roomType) {
            case SINGLE: {
                switch (roomLevel) {
                    case STANDARD: {
                        return 1000.00;
                    }
                    case DELUXE: {
                        return 1500.00;
                    }
                    case LUXURY: {
                        return 2000.00;
                    }
                    default: {
                        return null;
                    }
                }
            }
            case DOUBLE: {
                switch (roomLevel) {
                    case STANDARD: {
                        return 2500.00;
                    }
                    case DELUXE: {
                        return 3000.00;
                    }
                    case LUXURY: {
                        return 3500.00;
                    }
                    default: {
                        return null;
                    }
                }
            }
            default: {
                return null;
            }
        }
    }
}
