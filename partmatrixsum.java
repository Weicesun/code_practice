public class NumMatrix {
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                if (i > 0 && j > 0) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j] - matrix[i - 1][j - 1];
                }
                if (j > 0 && i == 0) {
                    matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
                }
                if (j == 0 && i > 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > 0 && col1 > 0)
        return (matrix[row2][col2] - matrix[row2][col1 - 1] - matrix[row1 - 1][col2] + matrix[row1 - 1][col1 - 1]);
        if (row1 == 0 && col1 != 0)
        return matrix[row2][col2] - matrix[row2][col1 - 1];
        if (row1 > 0 && col1 == 0)
        return matrix[row2][col2]  - matrix[row1 - 1][col2];
        
        return matrix[row2][col2];
    }
}
