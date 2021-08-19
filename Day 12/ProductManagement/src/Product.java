import java.time.LocalDate;

public class Product {
    private String name;
    private int id;
    private double listPrice;

    public Product(){}

    public Product(String name, int id, double listPrice){
        this.name = name;
        this.id = id;
        this.listPrice = listPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", listPrice=" + listPrice +
                '}';
    }
}
