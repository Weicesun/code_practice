public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        ArrayList<int[]> height = new ArrayList<int[]>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int pre = 0;
        pq.offer(0);
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i)[1] < 0) {
                pq.offer(-height.get(i)[1]);
            } else {
                pq.remove(height.get(i)[1]);
            }
            int temp = pq.peek();
            if (temp != pre) {
                result.add(new int[]{height.get(i)[0], temp});
                pre = temp;
            }
            
        }
        return result;
    }
