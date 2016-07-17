public class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '*';
                queue.offer(new Point(i, 0));
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '*';
                queue.offer(new Point(i, n - 1));
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '*';
                queue.offer(new Point(0, j));
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = '*';
                queue.offer(new Point(m - 1, j));
            }
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            if (x > 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '*';
                queue.offer(new Point(x - 1, y));
            }
            if (y > 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '*';
                queue.offer(new Point(x, y - 1));
            }
            if (y < n - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = '*';
                queue.offer(new Point(x, y + 1));
            }
            if (x < m - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = '*';
                queue.offer(new Point(x + 1, y));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                board[i][j] = 'X';
                if (board[i][j] == '*')
                board[i][j] = 'O';
            }
        }
        
    }
}
// need to see the iterate way bfs
