public void wallsAndGates(int[][] rooms) {
        int INF = Integer.MAX_VALUE;
        Queue<int[]> queue = new Queue<int[]>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] top = queue.pull();
            int row = top[0];
            int col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] = Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
            }
        }
    }
