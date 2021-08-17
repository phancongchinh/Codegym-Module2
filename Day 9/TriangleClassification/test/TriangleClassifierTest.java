import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void TestNegativeSides() {
        int side1 = -1;
        int side2 = 1;
        int side3 = 1;
        String expected = TriangleClassifier.INVALID_SIDE;
        String actual = TriangleClassifier.classify(side1,side2,side3);
        assertEquals(actual.compareTo(expected),0);
    }

    @Test
    void testTamGiacDeu() {
        int side1 = 1;
        int side2 = 1;
        int side3 = 1;
        String expected = TriangleClassifier.EQUILATERAL;
        String actual = TriangleClassifier.classify(side1,side2,side3);
        assertEquals(actual.compareTo(expected),0);
    }

    @Test
    void testTamGiacVuong() {
        int side1 = 3;
        int side2 = 4;
        int side3 = 5;
        String expected = TriangleClassifier.RIGHT_TRIANGLE;
        String actual = TriangleClassifier.classify(side1,side2,side3);
        assertEquals(actual.compareTo(expected),0);
    }

    @Test
    void testTamGiacCan() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 3;
        String expected = TriangleClassifier.ISOSCELES_TRIANGLE;
        String actual = TriangleClassifier.classify(side1,side2,side3);
        assertEquals(actual.compareTo(expected),0);
    }

    @Test
    void testTamGiacThuong() {
        int side1 = 2;
        int side2 = 3;
        int side3 = 4;
        String expected = TriangleClassifier.NORMAL_TRIANGLE;
        String actual = TriangleClassifier.classify(side1,side2,side3);
        assertEquals(actual.compareTo(expected),0);
    }
}