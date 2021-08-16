import java.time.LocalDate;

public abstract class Material implements Discount {
    private String name;
    private String id;
    private LocalDate manufacturingDate;
    private int listPrice;

    public Material(){}

    public Material(String name, String id, LocalDate manufacturingDate, int listPrice){
        this.name = name;
        this.id = id;
        this.manufacturingDate = manufacturingDate;
        this.listPrice = listPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", id: " + id +
                ", list price: " + listPrice +
                ", MFG: " + manufacturingDate;
    }

    public abstract double getAmount();

    public abstract LocalDate getExpiredDate();

}
