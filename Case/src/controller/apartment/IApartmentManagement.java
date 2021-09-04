package controller.apartment;

import controller.IGeneralManagement;
import model.apartment.Apartment;
import model.apartment.ApartmentLevel;
import model.apartment.ApartmentState;
import model.apartment.ApartmentType;

public interface IApartmentManagement extends IGeneralManagement<Apartment> {

    Apartment initApartment();

    int searchApartmentById(String apartmentId);

    boolean apartmentIdExisted(String apartmentId);

    void displayByState(ApartmentState apartmentState);

    void displayByLevel(ApartmentLevel apartmentLevel);

    void displayByType(ApartmentType apartmentType);

    void displayByPrice(Double min, Double max);
}
