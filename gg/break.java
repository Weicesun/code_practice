public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        return helper(map, s, wordDict);
    }
    List<String> helper(Map<String, List<String>> map, String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)) {
                if (i == s.length()) {
                    res.add(sub);
                }
                List<String> temp = helper(map, s.substring(i), wordDict);
                for (String ele : temp) {
                    res.add(sub + " " + ele);
                }
            }
        }
        map.put(s, res);
        return res;
    }
