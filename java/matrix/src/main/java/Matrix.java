import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

class Matrix {

    private final String matrixAsString;

    private int[][] row;

    private List<List<Integer>> column;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        this.row = buildRow(this.matrixAsString);
        this.column = buildColumn();
    }

    int[][] buildRow(String matrixAsString){
        String[] matrix = matrixAsString.split("\n");

        final int[][] ints = new int[matrix.length][];
        for (int i=0; i < matrix.length; i++) {
            String[] splited = matrix[i].split(" ");
            ints[i] = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();
        }
        return ints;
    }
    List<List<Integer>> buildColumn(){

        List<Integer> tempList = new ArrayList<Integer>();

        int size = this.row.length;
        for (int i=0; i < row[0].length; i++) {
            for (int j=0; j < size; j++) {
                tempList.add(this.row[j][i]);
            }
        }

        List<List<Integer>> columns =  range(0, tempList.size())
                .boxed()
                .collect(groupingBy(index -> index / size))
                .values()
                .stream()
                .map(indices -> indices
                        .stream()
                        .map(tempList::get)
                        .collect(toList()))
                .collect(toList());

        return columns;
    }
    int[] getRow(int rowNumber) {
       return this.row[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        List<Integer> column = this.column.get(columnNumber);

        return column.stream().mapToInt(i -> i).toArray();
    }

}
