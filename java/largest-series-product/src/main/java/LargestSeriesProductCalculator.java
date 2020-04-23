import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static java.util.Comparator.comparing;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        List<List<Integer>> longList = buildListOfNumbers(numberOfDigits);

        return longList.stream().map(e -> e.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply))
                .flatMapToLong(x -> LongStream.of(x.longValue()))
                .max()
                .orElseThrow(() -> new IllegalStateException("Invalid Value"));
    }

    private List<List<Integer>> buildListOfNumbers(int numberOfDigits) {
        List<List<Integer>> longList = new ArrayList<>();

        int size = inputNumber.length()-1;
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            String substring = inputNumber.substring(i, i + numberOfDigits);
            for (char ch : substring.toCharArray()) {
                list.add(Integer.parseInt(String.valueOf(ch)));
            }

            longList.add(list);
        }
       return longList;
    }
}
