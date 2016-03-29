public int maximalSquare(char[][] matrix) {
        // see the answer dp
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] result = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    result[i][j] = Math.min(Math.min(result[i][j - 1] , result[i - 1][j]) , result[i - 1][j - 1]) + 1;
                    res = Math.max(res, result[i][j]);
                }
            }
        }
        return res*res;
