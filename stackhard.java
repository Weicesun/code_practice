 public int longestValidParentheses(String s) {
        int length = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                length++;
                stack.push(length);
            }else if (s.charAt(i) == ')' && stack.isEmpty()) {
                length = 0;
                
            } else if (s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
                length++;
                if (!stack.isEmpty()) {
                    max = Math.max(length - stack.peek(), max);
                } else {
                    max = Math.max(length, max);
                }
            }
        }
        return max;
    }
