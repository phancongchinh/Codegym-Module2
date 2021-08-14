public class Test {
    public static void main(String[] args) {
        Point point = new Point(1,2);

        MovablePoint movablePoint = new MovablePoint(point.getX(), point.getY(),10,10);

        System.out.println(movablePoint);

        movablePoint.move();

        System.out.println(movablePoint);
    }
}
