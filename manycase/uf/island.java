    class UF {
        int count = 0;
        int[] parent;
        UF(int x, int y, char[][] grid) {
            parent = new int[x * y];
            for (int i = 0; i < x * y; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1')
                    count++;
                }
            }
        }
        public int find(int x) {
            while(x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            } else {
                parent[px] = py;
                count--;
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m,n,grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(i *n + j, (i - 1)*n + j );
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.union(i *n + j, (i + 1)*n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i*n + j, i*n + j - 1);
                    }
                    if (j < n -1 && grid[i][j + 1] == '1') {
                        uf.union(i*n + j, i*n + j + 1);
                    }
                    
                }
            }
        }
        return uf.count;
        
    }
