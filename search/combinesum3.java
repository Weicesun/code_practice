public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        for (int i = 1; i < 10; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(i);
            helper(i, result, list, 0, k, n);
        }
        return result;
    }
    public void helper(int i, List<List<Integer>> result, ArrayList<Integer> list, int sum, int k, int n) {
        sum += i;
        if (list.size() > k || sum > n) {
            return;
        }
        
        if (sum == n && list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int j = i + 1; j < 10; j++) {
            list.add(j);
            helper(j, result, list, sum, k, n);
            list.remove(list.size() - 1);
        }
    }
