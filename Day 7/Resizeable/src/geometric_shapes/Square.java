package geometric_shapes;

public class Square extends Shape implements Resizeable, Colorable{
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super (color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                super.toString() +
                "side=" + side +
                '}';
    }

    public double getPerimeter() {
        return side *4;
    }

    public double getArea() {
        return side * side;
    }

    public void resize(double percent) {
        setSide(this.side * (1+percent / 100));
    }

    public void howToColor() {
        System.out.println("color all four sides");
    }

}
