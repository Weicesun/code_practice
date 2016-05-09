    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (numCourses == 0) {
            int[] empty = new int[numCourses];
            return empty;
        }
       // if ()
       int[] linkCount = new int[numCourses];
        Queue<Integer> leaves = new LinkedList<Integer>();
        ArrayList<Integer> order = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0 ; i < prerequisites.length; i++) {
            linkCount[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i< numCourses; i++) {
            if (linkCount[i] == 0) {
                leaves.offer(i);
            }
        }
        int size = leaves.size();
        int count = 0;
        while(!leaves.isEmpty()) {
            int cl = leaves.poll();
            order.add(cl);
            for (int to : adj.get(cl)) {
                linkCount[to]--;
                if (linkCount[to] == 0) {
                    leaves.offer(to);
                }
            }
            count++;
            
        }
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        return count == numCourses ? result : new int[0];
    }
