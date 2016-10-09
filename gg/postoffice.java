public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int houseNum = 0;
        int[][] count = new int[m][n];
        int[][] step = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[m][n];
                    houseNum++;
                    Queue<Integer> queuex = new LinkedList<>();
                    Queue<Integer> queuey = new LinkedList<>();
                    queuex.offer(i);
                    queuey.offer(j);
                    int[] dx = {1, -1, 0, 0};
                    int[] dy = {0, 0, -1, 1};
                    int level = 1;
                    while (!queuex.isEmpty()) {
                        int size = queuex.size();
                        for (int p = 0; p < size; p++) {
                            int tx = queuex.poll();
                            int ty = queuey.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = tx + dx[k];
                                int ny = ty + dy[k];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
                                    step[nx][ny] += level;
                                    count[nx][ny]++;
                                    queuex.offer(nx);
                                    queuey.offer(ny);
                                    visited[nx][ny] = true;
                                }
                                
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == houseNum && step[i][j] < res) {
                    res = step[i][j];
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
