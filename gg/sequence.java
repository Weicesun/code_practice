public List<List<String>> wordSquares(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String sub = word.substring(0, i);
                if (!map.containsKey(sub)) {
                    List<String> tlist = new ArrayList<>();
                    tlist.add(word);
                    map.put(sub, tlist);
                } else {
                    map.get(sub).add(word);
                }
                
            }
        }
        helper(list, map, words, res);
        return res;
    }
    public void helper(List<String> list, Map<String, List<String>> map, String[] words, List<List<String>> res) {
        if (list.size() == words[0].length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        List<String> source;
        if (list.size() == 0) {
            source = Arrays.asList(words);
        } else {
            String head = "";
            for (String ts : list) {
                head = head + ts.charAt(list.size());
            }
            source = map.get(head);
        }
        if (source == null || source.size() == 0) {
            return;
        }
        for (String word : source) {
            list.add(word);
            helper(list, map, words, res);
            list.remove(list.size() - 1);
        }
    }
