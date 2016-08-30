class node {
         int x;
         int y;
         int cap;
         public node(int x1, int y1, int cap1) {
             x = x1;
             y = y1;
             cap = cap1;
         }
     }
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        PriorityQueue<node> pq = new PriorityQueue<node>(10, new Comparator<node>(){
            public int compare(node a, node b) {
                return a.cap - b.cap;
            }
        });
        int m = heights.length;
        int n = heights[0].length;
        int amount = 0;
        boolean[][] check = new boolean[m][n];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for (int i = 0; i < n; i++) {
            pq.offer(new node(0, i, heights[0][i]));
            check[0][i] = true;
            pq.offer(new node(m - 1, i, heights[m - 1][i]));
            check[m - 1][i] = true;
        }
        for (int i = 0; i < m; i++) {
            pq.offer(new node(i, 0, heights[i][0]));
            check[i][0] = true;
            pq.offer(new node(i, n - 1, heights[i][n - 1]));
            check[i][n - 1] = true;
        }
        while (!pq.isEmpty()) {
            node tnode = pq.poll();
            for (int i = 0; i < 4; i++) {
                int tx = tnode.x + dx[i];
                int ty = tnode.y + dy[i];
                if (tx < 0 || ty < 0 || tx >= m || ty >= n || check[tx][ty]) {
                    continue;
                }
                if (heights[tx][ty] < tnode.cap) {
                    amount += (tnode.cap - heights[tx][ty]);
                    check[tx][ty] = true;
                    pq.offer(new node(tx, ty, tnode.cap));
                } else {
                    check[tx][ty] = true;
                    pq.offer(new node(tx, ty, heights[tx][ty]));
                }
            }
        }
        return amount;
    }
// two pointer
