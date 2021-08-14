package geometric_shapes;

public class Main {
    static Shape[] shapes = new Shape[3];
    static Circle circle = new Circle();
    static Rectangle rectangle = new Rectangle();
    static Square square  = new Square();

    public static void main(String[] args) {

        shapes[0] = circle;
        shapes[1] = rectangle;
        shapes[2] = square;

        circle.setRadius(3.5);
        rectangle.setWidth(2.0);
        rectangle.setLength(2.5);
        square.setSide(5.0);

        showInfo();

        circle.resize(50);
        rectangle.resize(50);
        square.resize(50);

        showInfo();

        System.out.println("\nHow to color: ");
        System.out.print("Circle: ");
        circle.howToColor();
        System.out.print("Rectangle: ");
        rectangle.howToColor();
        System.out.print("Square: ");
        square.howToColor();

    }

    public static void showInfo() {
        System.out.println(circle);
        System.out.println("Perimeter: " + circle.getPerimeter() + ", Area:" + circle.getArea());
        System.out.println(rectangle);
        System.out.println("Perimeter: " + rectangle.getPerimeter() + ", Area:" + rectangle.getArea());
        System.out.println(square);
        System.out.println("Perimeter: " + square.getPerimeter() + ", Area:" + square.getArea());
    }

}
