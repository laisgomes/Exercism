import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String ex = "-";
        String isbnToVerify = stringToVerify.replaceAll(ex, "");
        if (isbnToVerify.length() < 10 || isbnToVerify.length() > 10) {
            return false;
        }
        List<Integer> isbnList = readIsbn(isbnToVerify);
        if (isbnList.size() < 10) {
            return false;
        }
        int checkDigit = isbnList.get(9);
        int calcItems = getCalcItems(isbnList);
        return (calcItems + checkDigit) % 11 == 0 && isCheckDigit(calcItems, checkDigit);
    }

    private int getCalcItems(List<Integer> isbnList) {
        int total = 10;
        int calcItems = 0;
        isbnList.remove(9);
        ListIterator<Integer> integerListIterator = isbnList.listIterator();
        while (integerListIterator.hasNext()) {
            int item = integerListIterator.next();
            calcItems = calcItems + (item * total);
            total--;
        }
        return calcItems;
    }

    List<Integer> readIsbn(String isbnToRead) {
        List<String> stringList = Arrays.asList(isbnToRead.split(""));

        if (stringList.get(9).equals("X")) {
            stringList.set(9, "10");
        }
        List<String> removedList = new ArrayList();
        for (String item : stringList) {
            if (!item.matches("[a-zA-Z]")) {
                removedList.add(item);
            }
        }

        return removedList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    boolean isCheckDigit(int calcItems, int intToCheck) {
        int trueCheckDigit = (11 - (calcItems % 11)) % 11;
        return trueCheckDigit == intToCheck;
    }


}
