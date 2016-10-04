class Node implements Comparable<Node> {
         int x;
         int y;
         int val;
         public Node (int x, int y, int v) {
             this.x = x;
             this.y = y;
             this.val = v;
         }
         public int compareTo(Node another) {
             if (this.val < another.val) {
                 return -1;
             } else if (this.val > another.val) {
                 return 1;
             }
             return 0;
         }
         
     }
     int[] dx = {0, 1};
     int[] dy = {1, 0};
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int indexA = 0, indexB = 0;
        Node tnode = new Node(0, 0, A[0] + B[0]);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Set<String> set = new HashSet<>();
        pq.offer(tnode);
        set.add("0,0");
        for (int i = 0; i < k; i++) {
            Node pnode = pq.poll();
            if (i == k - 1) {
                return pnode.val;
            }
            for (int j = 0; j < 2; j++) {
                int tempx = pnode.x + dx[j];
                int tempy = pnode.y + dy[j];
                Node test = new Node(tempx, tempy, 0);
                if (tempx < A.length && tempy < B.length && 
                !set.contains(tempx + "," + tempy)) {
                    test.val = A[tempx] + B[tempy];
                    pq.offer(test);
                    set.add(tempx + "," + tempy);
                }
            }
        }
        return -1;
    }
