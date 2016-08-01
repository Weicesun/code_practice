public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
               return b - a;
            }
        });
        
        for (int i = 0; i < m; i++) {
            if (pq.size() == k && matrix[i][0] > pq.peek()) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (pq.size() == k) {
                    if (pq.peek() > matrix[i][j]) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                } else {
                    pq.offer(matrix[i][j]);
                }
            }
            
        }
        return pq.peek();
