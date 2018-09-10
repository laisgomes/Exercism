class SumOfMultiples {

    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        int sum = 0;
        for (int item = 0; item < number; item++) {
            if (isMultiple(item)) {
                sum = sum + item;
            }
        }
        return sum;
    }

    boolean isMultiple(int numberToCheck) {
        int countCheck = 0;
        for (int item = 0; item < set.length; item++) {
            if (numberToCheck % set[item] == 0) {
                countCheck++;
            }
        }
        return countCheck != 0;
    }
}
