import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour(){}

    public CrispyFlour(String name, String id, LocalDate manufacturingDate, int listPrice, int quantity){
        super(name, id, manufacturingDate, listPrice);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.quantity * getListPrice();
    }

    @Override
    public LocalDate getExpiredDate() {
        return getManufacturingDate().plusDays(365);
    }

    public double getDiscount() {
        LocalDate today = LocalDate.now();
        if ((today.plusMonths(4)).isBefore(getExpiredDate())) {
            return 0.05;
        } else if ((today.plusMonths(2)).isBefore(getExpiredDate())) {
            return 0.2;
        } else {
            return 0.4;
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
                ", quantity: " + quantity +
                ", discount: " + getDiscount() * 100 + "%" +
                ", sale price: " + getSalePrice() +
                " }";
    }
}
