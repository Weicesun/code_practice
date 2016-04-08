    int num = 0;
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        if (edges.length == 0) {
            return n;
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (!set.contains(edges[i][0]) && !set.contains(edges[i][1])) {
                count++;
                num += 2;
                set.add(edges[i][0]);
                set.add(edges[i][1]);
                search(set, edges, edges[i][0]);
                search(set, edges, edges[i][1]);
            }
            
        }
        return count + n - num;
    }
    public void search(HashSet<Integer> set, int[][] edges, int temp) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == temp && !set.contains(edges[i][1])) {
                num++;
                set.add(edges[i][1]);
                search(set, edges, edges[i][1]);
            }
            if (edges[i][1] == temp && !set.contains(edges[i][0])) {
                num++;
                set.add(edges[i][0]);
                search(set, edges, edges[i][0]);
            }
        }
    }
