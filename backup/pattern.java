 boolean res = false;
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        helper( pattern, str, map, set, 0, 0);
        return res;
    }
    public void helper(String pattern, String str, Map<Character, String> map, Set<String> set, int indexs, int indexp) {
        if (indexs == str.length() && indexp == pattern.length()) {
            res = true;
            return;
        }
        if (indexp == pattern.length()) {
            return;
        }
        for (int i = indexs + 1; i <= str.length(); i++) {
            String sub = str.substring(indexs, i);
            if (map.containsKey(pattern.charAt(indexp))) {
                //System.out.println(sub);
                if (!map.get(pattern.charAt(indexp)).equals(sub)) {
                    continue;
                }
                
                helper(pattern, str, map, set, i, indexp + 1);
            } else {
                if (set.contains(sub)) {
                    continue;
                }
                set.add(sub);
                map.put(pattern.charAt(indexp), sub);
                helper(pattern, str, map, set, i, indexp + 1);
                map.remove(pattern.charAt(indexp));
                set.remove(sub);
            }
            
        }
    }
