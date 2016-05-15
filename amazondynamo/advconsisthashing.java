public class Solution {

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    int k;
    int n;
    Map<Integer, List<Integer>> map;
    Set<Integer> set;
    public static Solution create(int n, int k) {
        // Write your code here
        Solution solution = new Solution();
        solution.n = n;
        solution.k = k;
        solution.map = new HashMap<>();
        solution.set = new HashSet<>();
        return solution;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        Random ra = new Random();
        for (int i = 0; i < k; i++) {
            int temp = ra.nextInt(n);
            while (set.contains(temp)) {
                temp = ra.nextInt(n);
            }
            list.add(temp);
            set.add(temp);
        }
        map.put(machine_id, list);
        return list;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int machine = Integer.MAX_VALUE;
        int result = -1;
        for (int id : set) {
            if ((id >= hashcode && id - hashcode < (machine >=hashcode ? machine - hashcode : machine + n - hashcode)) ||
            (id < hashcode && n + id - hashcode < (machine >=hashcode ? machine - hashcode : machine + n - hashcode))) {
                machine = id;
            }
        }
        for (int id : map.keySet()) {
            if (map.get(id).contains(machine)) {
                result = id;
                break;
            }
        }
        return result;
    }
}
