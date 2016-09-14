public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0 || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0, bottom = matrix.length, right = matrix[0].length;
        int i = 0, j = 0;
        while (res.size() < m * n) {
            while (j < right && res.size() < m * n) {
                res.add(matrix[i][j]);
                j++;
            }
            j--;
            top++;
            i++;
            while (i < bottom && res.size() < m * n) {
                res.add(matrix[i][j]);
                i++;
            }
            i--;
            right--;
            j--;
            while (j >= left && res.size() < m * n) {
                res.add(matrix[i][j]);
                j--;
            }
            j++;
            bottom--;
            i--;
            while (i >= top && res.size() < m * n) {
                res.add(matrix[i][j]);
                i--;
            }
            i++;
            left++;
