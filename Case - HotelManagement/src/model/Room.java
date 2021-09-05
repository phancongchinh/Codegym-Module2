package model;

public class Room {
    private String roomId;
    private RoomState roomState;
    private RoomType roomType;
    private RoomLevel roomLevel;

    public Room(String roomId, RoomState roomState, RoomType roomType, RoomLevel roomLevel) {
        this.roomId = roomId;
        this.roomState = roomState;
        this.roomType = roomType;
        this.roomLevel = roomLevel;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public RoomState getRoomState() {
        return roomState;
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomLevel getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(RoomLevel roomLevel) {
        this.roomLevel = roomLevel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomState=" + roomState +
                ", roomType=" + roomType +
                ", roomLevel=" + roomLevel +
                '}';
    }
}
