public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int level = 1;
        int result = 0;
        if (nestedList == null || nestedList.size() == 0) {
            return result;
        }
        for (NestedInteger temp : nestedList) {
            result += helper(temp, level);
        }
        return result;
    }
    public int helper(NestedInteger temp , int level) {
        int sum = 0;
        if (temp.isInteger()) {
            return level * temp.getInteger();
        } else {
            for (NestedInteger temp1 : temp.getList()) {
                sum += helper(temp1, level + 1);
            }
            return sum;
        }
    }
}
