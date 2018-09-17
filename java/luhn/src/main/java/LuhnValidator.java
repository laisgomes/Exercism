import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate.length() <= 1 || !candidate.matches("[0-9]")) {
            return false;
        }

        List<Integer> listCandidate = getIntList(candidate);

        int sum = getSum(listCandidate);
        return sum % 10 == 0;
    }

    int getSum(List<Integer> listCandidate) {
        Collections.reverse(listCandidate);
        Iterator<Integer> integerIterator = listCandidate.iterator();

        while (integerIterator.hasNext()) {
            int index = listCandidate.indexOf(integerIterator.next());
            if ((index % 2) == 1) {
                int number = listCandidate.get(index) * 2;
                int numberLessNine = (number <= 9) ? number : number - 9;
                listCandidate.set(index, numberLessNine);
            }
        }

        return listCandidate.stream().mapToInt(Integer::intValue).sum();
    }

    List<Integer> getIntList(String candidate) {
        String candidateWithoutSpace = candidate.replace(" ", "");
        List<String> candidateList = Arrays.asList(candidateWithoutSpace.split("\\s*"));
        return candidateList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}

