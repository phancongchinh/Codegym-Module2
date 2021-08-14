public class Circle {

    private static String colour = "red"; // instance of class
    private double radius;

    public Circle() {
    }

    public Circle (double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "colour='" + colour + '\'' +
                ", radius=" + radius +
                '}';
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius,2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
