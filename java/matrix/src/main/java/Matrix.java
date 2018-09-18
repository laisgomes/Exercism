import java.util.Arrays;
import java.util.stream.IntStream;

class Matrix {

    private final String matrixAsString;

    private int[][] row;

    private int[] column;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        this.row = buildRow(this.matrixAsString);
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
    int[] buildCollumn(String matrixAsString){
        return null;
    }
    int[] getRow(int rowNumber) {
       return this.row[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
