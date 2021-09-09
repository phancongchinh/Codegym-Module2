package model;

public class Room {
    private String roomId;
    private RoomState roomState;
    private RoomType roomType;
    private RoomLevel roomLevel;

    public Room(){
    }

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

    public Double getPrice() {
        RoomType roomType = this.getRoomType();
        RoomLevel roomLevel = this.getRoomLevel();
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

    @Override
    public String toString() {
        return roomId + "," + roomState + "," + roomType + "," + roomLevel + "," + this.getPrice();
    }
}
