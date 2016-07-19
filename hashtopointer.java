List<Integer> res = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        
        for (int i = 0; i < s.length() - words.length * len + 1; i++) {
            for (int k = 0; k < words.length; k++) {
            if (map.containsKey(words[k])) {
                map.put(words[k], map.get(words[k]) + 1);
            } else {
                map.put(words[k], 1);
            }
        }
            //System.out.println(i);
            helper(i, s, map, words, res);
            map.clear();
        }
        return res;
    }
    public void helper(int start, String s, Map<String, Integer> map, String[] words, List<Integer> res) {
        int i = start;
        while ( i < start + words.length*words[0].length()) {
            String sub = s.substring(i, i + words[0].length());
            if (map.containsKey(sub) && map.get(sub) > 0) {
                map.put(sub, map.get(sub) - 1);
                //System.out.println(map.get(sub));
                i += words[0].length();
            } else {
                break;
            }
            if (i == start + words.length*words[0].length()) {
                
                res.add(start);
                break;
            }
        }
