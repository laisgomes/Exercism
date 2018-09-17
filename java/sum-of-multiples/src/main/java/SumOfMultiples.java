import java.util.stream.IntStream;

class SumOfMultiples {

    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
       return IntStream.range(1,number).filter(this::isMultiple).sum();
    }

    boolean isMultiple(int numberToCheck) {
        return IntStream.of(set).anyMatch(multiNumber -> numberToCheck % multiNumber == 0);
    }
}
