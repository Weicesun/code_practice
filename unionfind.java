int[][] dirs = {{0,1},{0, -1},{1,0},{-1,0}};
    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return list;
        }
        if (m <= 0 || n <= 0) {
            return list;
        }
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        for (Point p : operators) {
            int root = n * p.x + p.y;
            roots[root] = root;
            count++;
            for (int[] dir : dirs) {
                int x = p.x + dir[0];
                int y = p.y + dir[1];
                int nb = n * x + y;
                if (x < 0 || y < 0 || x >= m || y >= n || roots[nb] == -1) {
                    continue;
                }
                int rootNb = find(roots, nb);
                if (rootNb != root) {
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
                
            }
            list.add(count);
        }
        return list;
    }
    public int find(int[] roots, int nb) {
        while (roots[nb] != nb) {
            roots[nb] = roots[roots[nb]];
            nb = roots[nb];
        }
        return roots[nb];
    }≈
