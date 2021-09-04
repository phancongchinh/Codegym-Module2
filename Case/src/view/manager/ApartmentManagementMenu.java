package view.manager;

import controller.apartment.ApartmentManagement;
import model.apartment.Apartment;
import model.apartment.ApartmentLevel;
import model.apartment.ApartmentState;
import model.apartment.ApartmentType;
import view.IMenu;

public class ApartmentManagementMenu implements IMenu {

    private static final ApartmentManagement apartmentManagement = ApartmentManagement.getInstance();

    private ApartmentManagementMenu(){}

    public static ApartmentManagementMenu getInstance() {
        return ApartmentMenuHelper.INSTANCE;
    }

    private static class ApartmentMenuHelper{
        private static final ApartmentManagementMenu INSTANCE = new ApartmentManagementMenu();
    }

    @Override
    public void draw() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("APARTMENT MANAGEMENT MENU!");
        System.out.println("\t 1. Display list of all apartments!");
        System.out.println("\t 2. Searching information of an apartment!");
        System.out.println("\t 3. Add a new apartment!");
        System.out.println("\t 4. Edit an apartment!");
        System.out.println("\t 5. Delete an apartment!");
        System.out.println("\t 6. Search for apartment by state!");
        System.out.println("\t 7. Search for apartment by level!");
        System.out.println("\t 8. Search for apartment by type!");
        System.out.println("\t 9. Search for apartment by price!");
        System.out.println("\t 0. Back to Main Menu!");
        System.out.println("-----------------------------------------------------------------------------");
    }

    @Override
    public void run() throws NumberFormatException {
        int choice;
        do {
            draw();
            System.out.print(MAKE_CHOICE);
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean apartmentListIsEmpty = apartmentManagement.getApartmentList().size() == 0;
            switch (choice) {
                case 1: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(APARTMENT_LIST);
                    apartmentManagement.displayAll();
                    break;
                }
                case 2: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_APARTMENT);
                    System.out.println(ENTER_APARTMENT_ID);
                    String apartmentId = scanner.nextLine();
                    if (apartmentManagement.apartmentIdExisted(apartmentId)) {
                        apartmentManagement.display(apartmentId);
                    } else {
                        System.out.println(APARTMENT_ID_NOT_EXISTED);
                    }
                    break;
                }
                case 3: {
                    System.out.println(ADDING_APARTMENT);

                    Apartment apartment;
                    try {
                        apartment = apartmentManagement.initApartment();
                    } catch (IllegalArgumentException e) {
                        System.err.println("Input invalid!");
                        System.out.println(APARTMENT_ADDED_UNSUCCESSFULLY);
                        break;
                    }
                    if (apartment != null) {
                        apartmentManagement.add(apartment);
                        System.out.println(APARTMENT_ADDED);
                    } else {
                        System.out.println(APARTMENT_ADDED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 4: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(UPDATING_APARTMENT);
                    System.out.println(ENTER_APARTMENT_ID);
                    String apartmentId = scanner.nextLine();
                    if (apartmentManagement.apartmentIdExisted(apartmentId)) {
                        apartmentManagement.update(apartmentId);
                        System.out.println(APARTMENT_UPDATED);
                    } else {
                        System.out.println(APARTMENT_ID_NOT_EXISTED);
                        System.out.println(APARTMENT_UPDATED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 5: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(DELETING_APARTMENT);
                    System.out.println(ENTER_APARTMENT_ID);
                    String apartmentId = scanner.nextLine();
                    if (apartmentManagement.apartmentIdExisted(apartmentId)) {
                        apartmentManagement.delete(apartmentId);
                        System.out.println(APARTMENT_DELETED);
                    } else {
                        System.out.println(APARTMENT_ID_NOT_EXISTED);
                        System.out.println(APARTMENT_DELETED_UNSUCCESSFULLY);
                    }
                    break;
                }
                case 6: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_APARTMENT_BY_STATE);
                    System.out.println(ENTER_APARTMENT_STATE);
                    ApartmentState apartmentState = ApartmentState.valueOf(scanner.nextLine());
                    apartmentManagement.displayByState(apartmentState);
                    break;
                }
                case 7: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_APARTMENT_BY_LEVEL);
                    System.out.println(ENTER_APARTMENT_LEVEL);
                    ApartmentLevel apartmentLevel = ApartmentLevel.valueOf(scanner.nextLine());
                    apartmentManagement.displayByLevel(apartmentLevel);
                    break;
                }
                case 8: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_APARTMENT_BY_TYPE);
                    System.out.println(ENTER_APARTMENT_TYPE);
                    ApartmentType apartmentType = ApartmentType.valueOf(scanner.nextLine());
                    apartmentManagement.displayByType(apartmentType);
                    break;
                }
                case 9: {
                    if (apartmentListIsEmpty) {
                        System.out.println(APARTMENT_LIST_EMPTY);
                        break;
                    }
                    System.out.println(SEARCH_APARTMENT_BY_PRICE);
                    System.out.println(ENTER_MINIMUM_PRICE);
                    Double min = scanner.nextDouble();
                    System.out.println(ENTER_MAXIMUM_PRICE);
                    Double max = scanner.nextDouble();
                    apartmentManagement.displayByPrice(min, max);
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
