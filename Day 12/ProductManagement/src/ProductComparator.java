import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Double.compare(product1.getListPrice(),product2.getListPrice());
    }
}
