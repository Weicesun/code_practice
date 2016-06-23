public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0 ||edges.length == 0) {
            return n;
        }
        int[] uf = new int[n];
        Arrays.fill(uf, -1);
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int x = find(uf, edges[i][0]);
            int y = find(uf, edges[i][1]);
            if (x != y) {
                count--;
                //union
                uf[x] = y;
            }
        }
        return count;
    }
    public int find(int[] uf, int num) {
        if (uf[num] == -1) {
            return num;
        }
        return find(uf, uf[num]);
    }
