public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(-i);
            }
            if (Character.isDigit(s.charAt(i))) {
                String s1 = new String();
                int index = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    s1 = s1 + s.charAt(i);
                    i++;
                }
                i--;
                int n2 = Integer.parseInt(s1);
                if (index > 1 && (s.charAt(index - 1) == '+' || s.charAt(index - 1) == '-')) {
                    int n1 = stack.pop();
                    
                    if (s.charAt(index - 1) == '+') {
                        stack.push(n1 + n2);
                    } else {
                        stack.push(n1 - n2);
                    }
                } else {
                    stack.push(n2);
                }
            }
            if (s.charAt(i) == ')') {
                int n2 = stack.pop();
                int index = stack.pop();
                index = -index;
                
                if (index != 0 && (s.charAt(index - 1) == '+' || s.charAt(index - 1) == '-')) {
                    int n1 = stack.pop();
                    if (s.charAt(index - 1) == '+') {
                        stack.push(n1 + n2);
                    } else {
                        stack.push(n1 - n2);
                    }
                } else {
                    stack.push(n2);
                }
            }
        }
        return stack.peek();
    }
}
