import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat(){}

    public Meat(String name, String id, LocalDate manufacturingDate, int listPrice, double weight) {
        super(name, id, manufacturingDate, listPrice);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight * getListPrice();
    }

    @Override
    public LocalDate getExpiredDate() {
        return getManufacturingDate().plusDays(7);
    }

    public double getDiscount() {
        LocalDate today = LocalDate.now();
        if ((today.plusDays(5)).isBefore(getExpiredDate())) {
            return 0.1;
        } else if ((today.plusDays(3)).isBefore(getExpiredDate())) {
            return 0.3;
        } else {
            return 0.5;
        }
    }

    @Override
    public double getSalePrice() {
        return getListPrice() * (1-getDiscount());
    }

    @Override
    public String toString() {
        return "Meat { " +
                super.toString() +
                ", EXP: " + getExpiredDate() +
                ", weight: " + weight +
                ", discount: " + getDiscount() * 100 + "%" +
                ", sale price: " + getSalePrice() +
                " }";
    }
}
