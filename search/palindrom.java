public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> list = new ArrayList<>();
        
        dfs(res, list, s, 0);
        
        return res;
    }
    public void dfs (List<List<String>> res, List<String> list, String s, int pos) {
        if (pos > s.length()) {
            return;
        }
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for (int j = pos; j < s.length(); j++) {
            String test = s.substring(pos, j + 1);
            if (isPalindrome(test)) {
                list.add(test);
                dfs(res, list, s, j + 1);
                list.remove(list.size() - 1);
            } 
        }
        return;
    }
    public boolean isPalindrome(String s1) {
        if (s1 == null || s1.length() == 0) {
            return false;
        }
        int start = 0;
        int end = s1.length() - 1;
        while (end > start) {
            if (s1.charAt(end) != s1.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
