package controller.apartment;

import model.apartment.Apartment;
import model.apartment.ApartmentLevel;
import model.apartment.ApartmentState;
import model.apartment.ApartmentType;

import java.util.LinkedList;
import java.util.List;

public class ApartmentManagement implements IApartmentManagement {

    private final List<Apartment> apartmentList = new LinkedList<>();

    public List<Apartment> getApartmentList() {
        return apartmentList;
    }

    private ApartmentManagement() {
    }

    public static ApartmentManagement getInstance() {
        return ApartmentManagementHelper.INSTANCE;
    }

    private static class ApartmentManagementHelper {
        private static final ApartmentManagement INSTANCE = new ApartmentManagement();
    }

    @Override
    public void add(Apartment apartment) {
        apartmentList.add(apartment);
    }

    @Override
    public Apartment initApartment() throws IllegalArgumentException {
        System.out.println(ENTER_APARTMENT_ID);
        String apartmentId = scanner.nextLine();
        if (apartmentIdExisted(apartmentId)) {
            System.out.println(APARTMENT_ID_EXISTED);
            return null;
        }
        System.out.println(ENTER_APARTMENT_STATE);
        ApartmentState apartmentState = ApartmentState.valueOf(scanner.nextLine().toUpperCase());
        System.out.println(ENTER_APARTMENT_LEVEL);
        ApartmentLevel apartmentLevel = ApartmentLevel.valueOf(scanner.nextLine().toUpperCase());
        System.out.println(ENTER_APARTMENT_TYPE);
        ApartmentType apartmentType = ApartmentType.valueOf(scanner.nextLine().toUpperCase());

        Apartment apartment = new Apartment();
        apartment.setApartmentId(apartmentId);
        apartment.setApartmentState(apartmentState);
        apartment.setApartmentLevel(apartmentLevel);
        apartment.setApartmentType(apartmentType);
        return apartment;
    }

    @Override
    public void display(String apartmentId) {
        int index = searchApartmentById(apartmentId);
        System.out.println(apartmentList.get(index));
    }

    @Override
    public void displayAll() {
        for (Apartment apartment : apartmentList) {
            System.out.println(apartment);
        }
    }

    @Override
    public boolean update(String apartmentId) {
        int index = searchApartmentById(apartmentId);
        System.out.println(GATHERING_NEW_INFORMATION);
        Apartment apartment = initApartment();
        if (apartment == null) {
            return false;
        } else {
            apartmentList.remove(index);
            apartmentList.add(index, apartment);
            return true;
        }
    }

    @Override
    public void delete(String apartmentId) {
        int index = searchApartmentById(apartmentId);
        apartmentList.remove(index);
    }

    @Override
    public int searchApartmentById(String apartmentId) {
        for (Apartment apartment : apartmentList) {
            if (apartment.getApartmentId().equals(apartmentId)) {
                return apartmentList.indexOf(apartment);
            }
        }
        return -1;
    }

    @Override
    public boolean apartmentIdExisted(String apartmentId) {
        return searchApartmentById(apartmentId) != -1;
    }

    @Override
    public void displayByState(ApartmentState apartmentState) {
        int count = 0;
        for (Apartment apartment : apartmentList) {
            if (apartment.getApartmentState().equals(apartmentState)) {
                System.out.println(apartment);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }

    @Override
    public void displayByLevel(ApartmentLevel apartmentLevel) {
        int count = 0;
        for (Apartment apartment : apartmentList) {
            if (apartment.getApartmentLevel().equals(apartmentLevel)) {
                System.out.println(apartment);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }

    @Override
    public void displayByType(ApartmentType apartmentType) {
        int count = 0;
        for (Apartment apartment : apartmentList) {
            if (apartment.getApartmentType().equals(apartmentType)) {
                System.out.println(apartment);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }

    @Override
    public void displayByPrice(Double min, Double max) {
        int count = 0;
        for (Apartment apartment : apartmentList) {
            if (apartment.getPrice() > min && apartment.getPrice() < max) {
                System.out.println(apartment);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(NO_RESULT);
        }
    }
}
