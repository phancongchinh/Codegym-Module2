public class Fan {
    static int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan () {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return (this.isOn()) ? "Fan{" +
                "Fan is on" +
                ", speed=" + this.getSpeed() +
                ", radius=" + this.getRadius() +
                ", color='" + this.getColor() + '\'' +
                '}' :
                "Fan{" +
                "Fan is off" +
                ", radius=" + this.getRadius() +
                ", color='" + this.getColor() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("red");
        fan1.setOn(true);

        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
