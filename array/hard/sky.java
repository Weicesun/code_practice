public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            height.add(new int[]{buildings[i][0], -buildings[i][2]});
            height.add(new int[]{buildings[i][1], buildings[i][2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int pre = 0;
        pq.offer(0);
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i)[1] < 0) {
                pq.offer(-height.get(i)[1]);
                
            } else {
                pq.remove(height.get(i)[1]);
            }
            if (pre != pq.peek()) {
                res.add(new int[]{height.get(i)[0],pq.peek()});
                pre = pq.peek();
            }
        }
        return res;
    }
