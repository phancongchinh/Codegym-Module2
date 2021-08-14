public class Circle {
    private double radius;
    private String colour;
    private boolean filled;

    public Circle(){
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String colour, boolean filled){
        this.radius = radius;
        this.colour = colour;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colour='" + colour + '\'' +
                ", filled=" + filled +
                '}';
    }
}
