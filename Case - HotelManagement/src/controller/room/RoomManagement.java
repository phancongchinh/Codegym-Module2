package controller.room;

import model.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        System.out.print(ENTER_ROOM_ID);
        String roomId = scanner.nextLine();
        if (existsRoomId(roomId)) {
            System.out.println(ROOM_ID_EXISTED);
            return null;
        }

        // check input room type
        Set<String> roomTypes = getRoomTypeEnums();
        System.out.print(ENTER_ROOM_TYPE);
        String inputRoomType = scanner.nextLine().toUpperCase();
        if (!roomTypes.contains(inputRoomType)) {
            System.out.println(ROOM_TYPE_NOT_EXISTED);
            return null;
        }

        // check input room level
        Set<String> roomLevels = getRoomLevelEnums();
        System.out.print(ENTER_ROOM_LEVEL);
        String inputRoomLevel = scanner.nextLine().toUpperCase();
        if (!roomLevels.contains(inputRoomLevel)) {
            System.out.println(ROOM_LEVEL_NOT_EXISTED);
            return null;
        }

        RoomState roomState = RoomState.EMPTY;
        RoomLevel roomLevel = RoomLevel.valueOf(inputRoomLevel);
        RoomType roomType = RoomType.valueOf(inputRoomType);
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
        System.out.println(GATHERING_NEW_INFORMATION_FOR_UPDATING);
        Room newRoom = initFromKeyboard();
        if (newRoom == null) {
            return false;
        } else {
            ROOM_LIST.set(index,newRoom);
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
    public void listByState(RoomState roomState) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getRoomState().equals(roomState)) {
                rooms.add(room);
            }
        }
        if (rooms.size() == 0) {
            System.out.println(NO_RESULT);
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    @Override
    public void listByLevel(RoomLevel roomLevel) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getRoomLevel().equals(roomLevel)) {
                rooms.add(room);
            }
        }
        if (rooms.size() ==0) {
            System.out.println(NO_RESULT);
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    @Override
    public void listByType(RoomType roomType) {
         List<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getRoomType().equals(roomType)) {
                rooms.add(room);
            }
        }
        if (rooms.size() == 0) {
            System.out.println(NO_RESULT);
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    @Override
    public void listByPrice(Double min, Double max) {
        LinkedList<Room> rooms = new LinkedList<>();
        for (Room room : ROOM_LIST) {
            if (room.getPrice() <= max && room.getPrice() >= min) {
                rooms.add(room);
            }
        }
        if (rooms.size() == 0) {
            System.out.println(NO_RESULT);
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    @Override
    public HashSet<String> getRoomStateEnums() {
        HashSet<String> values = new HashSet<>();
        for (RoomState roomState : RoomState.values()) {
            values.add(roomState.name());
        }
        return values;
    }

    @Override
    public HashSet<String> getRoomLevelEnums() {
        HashSet<String> values = new HashSet<>();
        for (RoomLevel roomLevel : RoomLevel.values()) {
            values.add(roomLevel.name());
        }
        return values;
    }

    @Override
    public HashSet<String> getRoomTypeEnums() {
        HashSet<String> values = new HashSet<>();
        for (RoomType roomType : RoomType.values()) {
            values.add(roomType.name());
        }
        return values;
    }
}