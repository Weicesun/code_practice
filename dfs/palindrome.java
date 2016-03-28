//it is like combination
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        ArrayList<String> list = new ArrayList<String>();
        helper(s, result, list, 0);
        return result;
    }
    public boolean isPalindrome(String test) {
        if (test == null || test.length() == 0) {
            return false;
        }
        if (test.length() == 1) {
            return true;
        }
        int end = test.length() - 1;
        int start = 0;
        while (start < end) {
            if (test.charAt(start) != test.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private void helper(String s, List<List<String>> result, ArrayList<String> list, int pos) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String tempString = s.substring(pos, i);
            if (isPalindrome(tempString)) {
                list.add(tempString);
                helper(s, result, list, i);
                list.remove(list.size() - 1);
            }
            
        }
        
    }
