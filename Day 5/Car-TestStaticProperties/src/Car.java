public class Car {
    private String name;
    private String engine;
    public static String color = "red";
    public static int numberOfCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    // getters and setters


    public void setName(String name) {
        this.name = name;
    }
    public void setEngine(String engine) {
        this.engine = engine;
    }
    public static void setColor(String color) {
        Car.color = color;
    }
    public static void setNumberOfCars(int numberOfCars) {
        Car.numberOfCars = numberOfCars;
    }

    //toString() sao không ghi đè được nhỉ?
    @Override
    public String toString() {
        return this.name + " " + this.engine + " " + color + " " + numberOfCars;
    }

//    public static void main(String[] args) {
//        Car car1 = new Car("Car 1","Engine 1");
//        System.out.println(car1);
//        Car car2 = new Car("Car 2","Engine 2");
//        System.out.println(car1);
//        System.out.println(Car.numberOfCars);
//
//        Car.setColor("black");
//        Car.setNumberOfCars(100);
//        car1.setName("McLaren 6");
//        car1.setEngine("V6");
//        car2.setName("McLaren 8");
//        car2.setEngine("V8");
//        System.out.println(car1);
//        System.out.println(car2);
//        System.out.println(Car.numberOfCars);
//    }
}