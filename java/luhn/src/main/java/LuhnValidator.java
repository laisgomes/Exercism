import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {

        List<Integer> listCandidate = getIntList(candidate);
        int sum = getSum(listCandidate);
        return false;
    }

    int getSum(List<Integer> listCandidate){
        Iterator<Integer> integerIterator = listCandidate.iterator();
        while (integerIterator.hasNext()){
            int index = listCandidate.indexOf(integerIterator.next());
            if ((index % 2)==1) {
                int number = listCandidate.get(index - 1) * 2;
                int numberLessNine = (number <= 9) ? number : number - 9;
                listCandidate.set(index, numberLessNine);
            }
        }
        return listCandidate.stream().mapToInt(Integer::intValue).sum();
    }
    List<Integer> getIntList(String candidate){
        String candidateWithoutSpace = candidate.replace(" ", "");
        List<String> candidateList = Arrays.asList(candidateWithoutSpace.split("\\s*"));

        List<String> cleanList = new ArrayList();
        for (String item : candidateList) {
            if (item.matches("[0-9]")) {
                cleanList.add(item);
            }
        }
        return cleanList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}

