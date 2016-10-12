public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(pattern, str, map, set, 0, 0);
    }
    public boolean helper(String pattern, String str, Map<Character, String> map, Set<String> set, int index1, int index2) {
        if (index1 == pattern.length() && index2 == str.length()) {
            return true;
        }
        if (index1 == pattern.length() || index2 == str.length()) {
            return false;
        }
        char c = pattern.charAt(index1);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, index2)) {
                return false;
            }
            return helper(pattern, str, map, set, index1 + 1, index2 + s.length());
        } else {
            for (int k = index2; k < str.length(); k++) {
                String temp = str.substring(index2, k + 1);
                if (set.contains(temp)) {
                    continue;
                }
                map.put(c, temp);
                set.add(temp);
                if (helper(pattern, str, map, set, index1 + 1, k + 1)) {
                    return true;
                }
                map.remove(c);
                set.remove(temp);
            }
        }
