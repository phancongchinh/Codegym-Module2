package model.apartment;

public class Apartment {

    private String apartmentId;
    private ApartmentState apartmentState;
    private ApartmentLevel apartmentLevel;
    private ApartmentType apartmentType;

    public Apartment() {
    }

    public Apartment(String apartmentId, ApartmentState apartmentState, ApartmentLevel apartmentLevel, ApartmentType apartmentType) {
        this.apartmentId = apartmentId;
        this.apartmentState = apartmentState;
        this.apartmentLevel = apartmentLevel;
        this.apartmentType = apartmentType;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public ApartmentState getApartmentState() {
        return apartmentState;
    }

    public void setApartmentState(ApartmentState apartmentState) {
        this.apartmentState = apartmentState;
    }

    public ApartmentLevel getApartmentLevel() {
        return apartmentLevel;
    }

    public void setApartmentLevel(ApartmentLevel apartmentLevel) {
        this.apartmentLevel = apartmentLevel;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Double getPrice() {
        switch (apartmentType) {
            case SINGLE: {
                switch (apartmentLevel) {
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
                switch (apartmentLevel) {
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