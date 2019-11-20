import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Triangle {

    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        validateSizes();
    }

    private void validateSizes() throws TriangleException {
        boolean isGreaterThanZero = DoubleStream.of(side1, side2, side3).anyMatch(s -> s <= 0);
        if (isGreaterThanZero || isInequality(side1, side2, side3) ) {
            throw new TriangleException();
        }

    }

    private boolean isInequality(double side1, double side2, double side3) {

        List<Double> listOfSize = Arrays.asList(side1, side2, side3);
        List<Boolean> checkList = new ArrayList<>();
        for (int item = 0; item < listOfSize.size(); item++) {
            int finalItem = item;
            Double sumOfSides = listOfSize.stream().filter(s -> !s.equals(listOfSize.get(finalItem)))
                    .collect(Collectors.toList()).stream().reduce( 0.0, Double::sum);

            checkList.add(listOfSize.get(item) <= sumOfSides);

        }
        return checkList.stream().anyMatch(s -> !s);
    }

    boolean isEquilateral() {
        return getNumberOfDistinctSides() == 1;
    }

    private int getNumberOfDistinctSides() {
        return DoubleStream.of(side1, side2, side3).distinct().toArray().length;
    }

    boolean isIsosceles() {
        return getNumberOfDistinctSides() <= 2;
    }

    boolean isScalene() {
        return getNumberOfDistinctSides() == 3;
    }


}
