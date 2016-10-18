 public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        Queue<int[]> pqueue = new LinkedList<>();
        Queue<int[]> aqueue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
            pqueue.offer(new int[]{i, 0});
            aqueue.offer(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
            pqueue.offer(new int[]{0, j});
            aqueue.offer(new int[]{m - 1, j});
        }
        bfs(matrix, pqueue, pacific);
        bfs(matrix, aqueue, atlantic);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] temparray = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temparray[0] + dx[i];
                int ny = temparray[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny] || matrix[temparray[0]][temparray[1]] > matrix[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
            
        }
    }
}
