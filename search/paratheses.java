    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String element = new String();
        if (n <= 0) {
            return res;
        }
        element = "(";
        helper(res, element, n, 1, ")", 1);
        helper(res, element, n, 1, "(", 1);
        return res;
    }
    public void helper(List<String> res, String element, int n, int level, String test, int flag) {
        element = element + test;
        if (test.equals(")")) {
            if (flag == 0) {
                return;
            } else {
                flag--;
            }
        } else {
           flag++;
        }
        if (level + 1 == n*2) {
            if (flag == 0) {
                res.add(element);
            }
            return;
        }
        
        
        helper(res, element, n, level + 1, ")", flag);
        helper(res, element, n, level + 1, "(", flag);
        element = element.substring(0, element.length() - 1);
    }
