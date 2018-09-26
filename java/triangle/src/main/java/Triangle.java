import java.util.stream.DoubleStream;

class Triangle {

    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        validateSizes(side1, side2, side3);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    void validateSizes(double side1, double side2, double side3) throws TriangleException {
        boolean isGreaterThanZero = DoubleStream.of(side1, side2, side3).anyMatch( s -> s <= 0);
        boolean isInequality = DoubleStream.of(side1, side2).sum() < side3;
        if (isGreaterThanZero || isInequality) {
            throw new TriangleException();
        }

    }

    boolean isEquilateral() {
        int sizeUnique = DoubleStream.of(side1, side2, side3).distinct().toArray().length;
        if (sizeUnique == 1) {
            return true;
        }
        return false;
    }

    boolean isIsosceles() {
        int numberUniques = DoubleStream.of(side1, side2, side3).distinct().toArray().length;
        if (numberUniques <= 2 ){
            return true;
        }

        return false;
    }

    boolean isScalene() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
