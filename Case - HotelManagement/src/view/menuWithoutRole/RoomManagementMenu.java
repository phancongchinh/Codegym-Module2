package view.menuWithoutRole;

import controller.room.RoomManagement;

import model.Room;
import model.RoomLevel;
import model.RoomState;
import model.RoomType;

public class RoomManagementMenu implements IMenuWithoutRole {

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
        System.out.println("-----------------------------------------------------------------------------");
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
        String choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextLine();
            handleChoice(choice);
        } while (!choice.equals("0"));
    }

    @Override
    public void handleChoice(String choice) {
        boolean empty = ROOM_MANAGEMENT.getRoomList().size() == 0;
        switch (choice) {
            case "1": {
                if (isRoomList(empty)) break;
                System.out.println(ROOM_LIST);
                ROOM_MANAGEMENT.displayAll();
                break;
            }
            case "2": {
                if (isRoomList(empty)) break;
                System.out.println(SEARCH_ROOM);
                System.out.print(ENTER_ROOM_ID);
                String roomId = scanner.nextLine();
                if (ROOM_MANAGEMENT.existsRoomId(roomId)) {
                    ROOM_MANAGEMENT.display(roomId);
                } else {
                    System.out.println(ROOM_ID_NOT_EXISTED);
                }
                break;
            }
            case "3": {
                System.out.println(ADDING_ROOM);
                Room room = ROOM_MANAGEMENT.initFromKeyboard();
                if (ROOM_MANAGEMENT.add(room)) {
                    System.out.println(ROOM_ADDED);
                } else {
                    System.out.println(ROOM_ADDED_UNSUCCESSFULLY);
                }
                break;
            }
            case "4": {
                if (isRoomList(empty)) break;
                System.out.println(UPDATING_ROOM);
                System.out.print(ENTER_ROOM_ID);
                String roomId = scanner.nextLine();
                if (ROOM_MANAGEMENT.update(roomId)) {
                    System.out.println(ROOM_UPDATED);
                } else {
                    System.out.println(ROOM_UPDATED_UNSUCCESSFULLY);
                }
                break;
            }
            case "5": {
                if (isRoomList(empty)) break;
                System.out.println(DELETING_ROOM);
                System.out.print(ENTER_ROOM_ID);
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
            case "6": {
                if (isRoomList(empty)) break;
                System.out.println(SEARCH_ROOM_BY_STATE);
                System.out.print(ENTER_ROOM_STATE);
                String inputRoomState = scanner.nextLine();
                if (ROOM_MANAGEMENT.isRoomStateValid(inputRoomState)) {
                    ROOM_MANAGEMENT.listByState(RoomState.valueOf(inputRoomState.toUpperCase()));
                } else {
                    System.out.println(ROOM_STATE_NOT_EXISTED);
                }
                break;
            }
            case "7": {
                if (isRoomList(empty)) break;
                System.out.println(SEARCH_ROOM_BY_LEVEL);
                System.out.print(ENTER_ROOM_LEVEL);
                String inputRoomLevel = scanner.nextLine();
                if (ROOM_MANAGEMENT.isRoomLevelValid(inputRoomLevel)) {
                    ROOM_MANAGEMENT.listByLevel(RoomLevel.valueOf(inputRoomLevel.toUpperCase()));
                } else {
                    System.out.println(ROOM_LEVEL_NOT_EXISTED);
                }
                break;
            }
            case "8": {
                if (isRoomList(empty)) break;
                System.out.println(SEARCH_ROOM_BY_TYPE);
                System.out.print(ENTER_ROOM_TYPE);
                String inputRoomType = scanner.nextLine().toUpperCase();
                if (ROOM_MANAGEMENT.isRoomTypeValid(inputRoomType)) {
                    ROOM_MANAGEMENT.listByType(RoomType.valueOf(inputRoomType.toUpperCase()));
                } else {
                    System.out.println(ROOM_TYPE_NOT_EXISTED);
                }
                break;
            }
            case "9": {
                if (isRoomList(empty)) break;
                System.out.println(SEARCH_ROOM_BY_PRICE);

                System.out.print(ENTER_MINIMUM_PRICE);
                double min = scanner.nextDouble();
                while (Double.isNaN(min)) {
                    System.out.println(EXCEPTION_ILLEGAL_ARGUMENT);
                    System.out.print(ENTER_MINIMUM_PRICE);
                    min = scanner.nextDouble();
                }

                System.out.print(ENTER_MAXIMUM_PRICE);
                double max = scanner.nextDouble();
                while (Double.isNaN(max)) {
                    System.out.println(EXCEPTION_ILLEGAL_ARGUMENT);
                    System.out.println(ENTER_MAXIMUM_PRICE);
                    max = scanner.nextDouble();
                }
                ROOM_MANAGEMENT.listByPrice(min, max);
                scanner.nextLine();
                break;
            }
            case "0": {
                System.out.println(TURN_BACK);
                return;
            }
            default: {
                System.out.println(INVALID_CHOICE);
                break;
            }
        }
    }

    private boolean isRoomList(boolean empty) {
        if (empty) {
            System.out.println(ROOM_LIST_EMPTY);
            return true;
        }
        return false;
    }
}
