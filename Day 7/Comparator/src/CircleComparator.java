import java.util.Comparator;

public class CircleComparator extends Circle implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        return Double.compare(c1.getRadius(), c2.getRadius());
    }
}