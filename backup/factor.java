public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(2,n, list, result);
        return result;
    }
    public void helper(int num, int n, ArrayList<Integer> list, List<List<Integer>> result) {
        if (n == 1) {
            if (list.size() == 1 || list.size() == 0) {
                return;
            }
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = num; i <= n ; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(i, n/i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
