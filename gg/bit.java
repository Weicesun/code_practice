int[] bit;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }
    void init (int i, int val) {
        int index = i + 1;
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }
    void update(int i, int val) {
        int change = val - nums[i];
        nums[i] = val;
        init(i, change);
        
    }
    int getSum(int i) {
        int index = i + 1;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

//2d
int[][] matrix1;
    int[][] bit;
    int m, n;
    public NumMatrix(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            m = 0;
            n = 0;
        } else {
            m = matrix.length;
            n = matrix[0].length;
        }
        
        bit = new int[m + 1][n + 1];
        matrix1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n== 0) {
            return;
        }
        int diff = val - matrix1[row][col];
        matrix1[row][col] = val;
       
        for (int i = row + 1; i <= m; i += (i & (-i))) {
            for (int j = col + 1; j <= n; j += (j & (-j))) {
                bit[i][j] += diff;
            }
        }
    }
    public int getSum(int row1, int col1) {
        
        int sum = 0;
        for (int i = row1 + 1; i > 0; i -= (i & (-i))) {
            for (int j = col1 + 1; j > 0; j -= (j & (-j))) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
    }
