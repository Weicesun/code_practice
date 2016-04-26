public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(0, candidates, list, result, target);
        return result;
    }
    
    public void helper(int index, int[] candidates, ArrayList<Integer> list, List<List<Integer>> result, int target) {
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                helper(i, candidates, list, result, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
