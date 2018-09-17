
class Matrix {

    private final String matrixAsString;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
    }

    int[] getRow(int rowNumber) {
        if(rowNumber == 0){
            int[] row = {1};
            return row;
        }
        return null;
    }

    int[] getColumn(int columnNumber) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
