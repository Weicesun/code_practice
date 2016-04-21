public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = new ArrayList<Integer>();
                List<Integer> part2Res = new ArrayList<Integer>();
                part1Res = diffWaysToCompute(part1);
                part2Res = diffWaysToCompute(part2);
                for (int p1 : part1Res) {
                    for (int p2 : part2Res) {
                        int c = 0;
                        switch(input.charAt(i) ) {
                            case '+':
                            c = p1 + p2;
                            break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1*p2;
                                break;
                        }
                        result.add(c);
                    }
                }
            }
        }
        if (result.size() == 0) {
                    result.add(Integer.valueOf(input));
                }
        return result;
    }
}
