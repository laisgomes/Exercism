import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {

        if (inputNumber.matches("^[0-9]*$")) {
            this.inputNumber = inputNumber;
        } else {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        List<List<Integer>> longList = buildListOfNumbers(numberOfDigits);

        return longList.stream().map(e -> e.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply))
                .flatMapToLong(x -> LongStream.of(x.longValue()))
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Series length must be less than or equal to the length of the string to search."));
    }

    private List<List<Integer>> buildListOfNumbers(int numberOfDigits) {
        List<List<Integer>> longList = new ArrayList<>();
        try {
            int limitSize = inputNumber.length() - numberOfDigits;
            for (int i = 0; i < limitSize + 1; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                if (longList.size() <= limitSize) {
                    String substring = inputNumber.substring(i, i + numberOfDigits);
                    for (char ch : substring.toCharArray()) {
                        list.add(Integer.parseInt(String.valueOf(ch)));
                    }
                }
                longList.add(list);
            }
            return longList;
        }catch (Exception e){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
    }
}
