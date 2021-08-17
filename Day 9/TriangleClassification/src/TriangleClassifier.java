public class TriangleClassifier {

    public static final String INVALID_SIDE = "All side must not be less than or equal 0!";
    public static final String TRIANGLE_INEQUALITIES_ARE_NOT_SATISFIED = "The Triangle inequalities are not satisfied!";
    public static final String EQUILATERAL = "Equilateral triangle!";
    public static final String ISOSCELES_RIGHT_TRIANGLE = "Isosceles & right triangle!";
    public static final String ISOSCELES_TRIANGLE = "Isosceles triangle!";
    public static final String RIGHT_TRIANGLE = "Right triangle!";
    public static final String NORMAL_TRIANGLE = "Normal triangle!";

    public static String classify(int side1, int side2, int side3) {
        String result;
        boolean anySideIsInvalid = side1 <= 0 || side2 <= 0 || side3 <= 0;
        if (anySideIsInvalid) {
            result = INVALID_SIDE;
        } else {
            boolean theTriangleInequalitiesAreSatisfied = side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
            if (!theTriangleInequalitiesAreSatisfied) {
                result = TRIANGLE_INEQUALITIES_ARE_NOT_SATISFIED;
            } else {
                boolean allSidesAreEqual = side1 == side2 && side1 == side3;
                if (allSidesAreEqual) {
                    result = EQUILATERAL;
                } else {
                    boolean twoSidesAreEqual = side1 == side2 || side2 == side3 || side3 == side1;
                    boolean thereExistARightAngle = (Math.pow(side1, 2) == Math.pow(side2, 2) + Math.pow(side3, 2) || Math.pow(side2, 2) == Math.pow(side1, 2) + Math.pow(side3, 2) || Math.pow(side3, 2) == Math.pow(side1, 2) + Math.pow(side2, 2));
                    if (twoSidesAreEqual && thereExistARightAngle) {
                        result = ISOSCELES_RIGHT_TRIANGLE;
                    } else if (twoSidesAreEqual) {
                        result = ISOSCELES_TRIANGLE;
                    } else if (thereExistARightAngle) {
                        result = RIGHT_TRIANGLE;
                    } else {
                        result = NORMAL_TRIANGLE;
                    }
                }
            }
        }
        return result;
    }
}
