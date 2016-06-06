 public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-")) {
                String temp1 = stack.pop();
                String temp2 = stack.pop();
                int t1 = Integer.parseInt(temp1);
                int t2 = Integer.parseInt(temp2);
                int res = 0;
                switch(tokens[i]) {
                    case "+":
                        res = t1 + t2;
                        break;
                    case "-":
                        res = t2 - t1;
                        break;
                    case "*":
                        res = t2 * t1;
                        break;
                    case "/":
                        res = t2 / t1;
                        break;
                        
                }
                stack.push(res + "");
            } else {
                stack.push(tokens[i]);
            }
        }
        String num = stack.pop();
        return Integer.parseInt(num);
    }
