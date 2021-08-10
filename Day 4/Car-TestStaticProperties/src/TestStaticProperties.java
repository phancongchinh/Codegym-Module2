public class TestStaticProperties {
    public static void main(String[] args) {
        Car car1 = new Car("Car 1","Engine 1");
        System.out.println(car1);
        Car car2 = new Car("Car 2","Engine 2");
        System.out.println(car1);
        System.out.println(Car.numberOfCars);

        Car.setColor("black");
        Car.setNumberOfCars(100);
        car1.setName("McLaren 6");
        car1.setEngine("V6");
        car2.setName("McLaren 8");
        car2.setEngine("V8");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(Car.numberOfCars);
    }
}