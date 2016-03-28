    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        return helper(s, wordDict, 0, set);
        
    }
    public boolean helper(String s, Set<String> wordDict, int pos, Set<Integer> set) {
        if (pos == s.length()) {
            return true;
        }
        if (set.contains(pos)) {
            return false;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(pos, i))) {
                if (helper(s, wordDict, i, set)) {
                    return true;
                } else {
                    set.add(i);
                }
                
            }
        }
        set.add(pos);
        return false;
    }
// decrease the time complex by maintain hashset
