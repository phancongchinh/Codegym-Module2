public class Shapes {
    public static void main(String[] args) {
        drawRectangle();
        drawSquareTriangle1();
        drawSquareTriangle2();
        drawIsoscelesTriangle();
    }

    public static void drawRectangle() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawSquareTriangle1() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i+1 ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawSquareTriangle2() {
        for (int i = 0; i < 5; i++) {
            for (int j = 5-i ; j > 0 ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawIsoscelesTriangle() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
