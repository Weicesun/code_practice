Map<Integer, Integer> map;
    class UnionFind {
        public UnionFind (int[] nums) {
            map = new HashMap<>();
            for (int num : nums) {
                map.put(num, num);
            }
        }
        int find(int ele) {
            int fa = map.get(ele);
            
            while (map.get(fa) != fa) {
                fa = map.get(fa);
            }
            
            while (map.get(ele) != fa) {
                int temp = map.get(ele);
                map.put(ele, fa);
                ele = temp;
            }
            return fa;
        }
        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);
            if (p1 != p2) {
                if (a < b) {
                    map.put(b, a);
                } else {
                    map.put(a, b);
                }
            }
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num + 1)) {
                uf.union(num, num + 1);
            } else if (set.contains(num - 1)) {
                uf.union(num, num - 1);
            }
            
        }
        Map<Integer, Integer> map = new HashMap();
        set.clear();
        int res = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            int pa = uf.find(num);
            if (!map.containsKey(pa)) {
                map.put(pa, 1);
                res = Math.max(res, 1);
            } else {
                
                map.put(pa, map.get(pa) + 1);
                res = Math.max(res, map.get(pa));
            }
            
        }
        return res;
