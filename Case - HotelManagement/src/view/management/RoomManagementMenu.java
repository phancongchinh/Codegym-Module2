package view.management;

import controller.room.RoomManagement;

import model.Room;
import model.RoomLevel;
import model.RoomState;
import model.RoomType;
import view.IMenuRun;

import java.util.LinkedList;

public class RoomManagementMenu implements IMenuRun {

    private static final RoomManagement ROOM_MANAGEMENT = RoomManagement.getInstance();

    private RoomManagementMenu(){}

    public static RoomManagementMenu getInstance() {
        return RoomManagementMenuHelper.INSTANCE;
    }

    private static class RoomManagementMenuHelper {
        private static final RoomManagementMenu INSTANCE = new RoomManagementMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("ROOM MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all rooms!");
        System.out.println("\t 2. Searching information of a room!");
        System.out.println("\t 3. Add a new room!");
        System.out.println("\t 4. Edit information of a room!");
        System.out.println("\t 5. Delete information of a room!");
        System.out.println("\t 6. Search for rooms by state!");
        System.out.println("\t 7. Search for rooms by level!");
        System.out.println("\t 8. Search for rooms by type!");
        System.out.println("\t 9. Search for rooms by price!");
        System.out.println("\t 0. Back!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = Integer.parseInt(scanner.nextLine());
            boolean roomListIsEmpty = ROOM_MANAGEMENT.getRoomList().size() == 0;
            switch (choice) {
                case 1: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(ROOM_LIST);
                    ROOM_MANAGEMENT.displayAll();
                    break;
                }
                case 2: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_ROOM);
                    System.out.println(ENTER_ROOM_ID);
                    String roomId = scanner.nextLine();
                    if (ROOM_MANAGEMENT.existsRoomId(roomId)) {
                        ROOM_MANAGEMENT.display(roomId);
                    } else {
                        System.out.println(ROOM_ID_NOT_EXISTED);
                    }
                    break;
                }
                case 3: {
                    System.out.println(ADDING_ROOM);
                    Room room = ROOM_MANAGEMENT.initFromKeyboard();
                    if (room != null) {
                        ROOM_MANAGEMENT.add(room);
                        System.out.println(ROOM_ADDED);
                    } else {
                        System.out.println(ROOM_ADDED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 4: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(UPDATING_ROOM);
                    System.out.println(ENTER_ROOM_ID);
                    String roomId = scanner.nextLine();
                    if (ROOM_MANAGEMENT.existsRoomId(roomId)) {
                        ROOM_MANAGEMENT.update(roomId);
                        System.out.println(ROOM_UPDATED);
                    } else {
                        System.out.println(ROOM_ID_NOT_EXISTED);
                        System.out.println(ROOM_UPDATED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 5: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DELETING_ROOM);
                    System.out.println(ENTER_ROOM_ID);
                    String roomId = scanner.nextLine();
                    if (ROOM_MANAGEMENT.existsRoomId(roomId)) {
                        ROOM_MANAGEMENT.remove(roomId);
                        System.out.println(ROOM_DELETED);
                    } else {
                        System.out.println(ROOM_ID_NOT_EXISTED);
                        System.out.println(ROOM_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 6: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_ROOM_BY_STATE);
                    System.out.print(ENTER_ROOM_STATE);
                    RoomState roomState = RoomState.valueOf(scanner.nextLine().toUpperCase());
                    LinkedList<Room> rooms = ROOM_MANAGEMENT.listByState(roomState);
                    if (rooms.size() == 0) {
                        System.out.println(NO_RESULT);
                    } else {
                        for (Room room : rooms) {
                            System.out.println(room);
                        }
                    }
                    break;
                }
                case 7: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_ROOM_BY_LEVEL);
                    System.out.print(ENTER_ROOM_LEVEL);
                    RoomLevel roomLevel = RoomLevel.valueOf(scanner.nextLine().toUpperCase());
                    LinkedList<Room> rooms = ROOM_MANAGEMENT.listByLevel(roomLevel);
                    if (rooms.size() == 0) {
                        System.out.println(NO_RESULT);
                    } else {
                        for (Room room : rooms) {
                            System.out.println(room);
                        }
                    }
                    break;
                }
                case 8: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_ROOM_BY_TYPE);
                    System.out.print(ENTER_ROOM_TYPE);
                    RoomType roomType = RoomType.valueOf(scanner.nextLine().toUpperCase());
                    LinkedList<Room> rooms = ROOM_MANAGEMENT.listByType(roomType);
                    if (rooms.size() == 0) {
                        System.out.println(NO_RESULT);
                    } else {
                        for (Room room : rooms) {
                            System.out.println(room);
                        }
                    }
                    break;
                }
                case 9: {
                    if (roomListIsEmpty) {
                        System.out.println(ROOM_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_ROOM_BY_PRICE);
                    System.out.print(ENTER_MINIMUM_PRICE);
                    Double min = scanner.nextDouble();
                    System.out.print(ENTER_MAXIMUM_PRICE);
                    Double max = scanner.nextDouble();
                    LinkedList<Room> rooms = ROOM_MANAGEMENT.listByPrice(min, max);
                    if (rooms.size() == 0) {
                        System.out.println(NO_RESULT);
                    } else {
                        for (Room room : rooms) {
                            System.out.println(room);
                        }
                    }
                    break;
                }
                case 0: {
                    System.out.println(TURN_BACK);
                    return;
                }
                default: {
                    System.out.println(INVALID_CHOICE);
                    break;
                }
            }

        } while (choice !=0 );
    }
}
