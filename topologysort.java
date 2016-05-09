public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        List<Integer> nullanswer = new ArrayList<>();
        nullanswer.add(0);
        ArrayList<Set<Integer>> adj = new ArrayList<>();
        if (edges == null || edges.length == 0) {
            return nullanswer;
        }
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
