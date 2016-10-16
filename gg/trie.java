public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        //Set<String> visited = new HashSet<>();
        List<String> list = new ArrayList<>();
        Trie trie = new Trie();
        trie.buildTrie(words);
        helper(trie, words, list, res);
        return res;
    }
    public void helper(Trie trie, String[] words, List<String> list, List<List<String>> res) {
        if (list.size() == words[0].length()) {
            if (!res.contains(list))
            res.add(new ArrayList<String>(list));
            return;
        }
        for (String word : words) {
            if (list.contains(word)) {
                continue;
            }
            if (list.size() == 0) {
                list.add(word);
                helper(trie, words, list, res);
                list.remove(list.size() - 1);
            } else {
                int size = list.size();
                StringBuilder sb = new StringBuilder();
                for (String ss : list) {
                    sb.append(ss.charAt(size));
                }
                List<String> tlist = trie.startWith(sb.toString());
                for (String tss : tlist) {
                    list.add(tss);
                    helper(trie, words, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    class TrieNode {
        TrieNode[] array;
        List<String> list;
        public TrieNode () {
            array = new TrieNode[26];
            list = new ArrayList<>();
        }
    }
    class Trie {
        TrieNode root;
        public Trie () {
            root = new TrieNode();
        }
        void buildTrie(String[] words) {
            for (String word : words) {
                TrieNode temp = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (temp.array[c-'a'] != null) {
                        temp = temp.array[c - 'a'];
                    } else {
                        temp.array[c-'a'] = new TrieNode();
                        temp = temp.array[c - 'a'];
                    }
                    
                    temp.list.add(word);
                    
                }
            }
        }
        List<String> startWith(String head) {
            TrieNode temp = root;
            for (int i = 0; i < head.length(); i++) {
                temp = temp.array[head.charAt(i) - 'a'];
                if (temp == null) {
                    return new ArrayList<String>();
                }
            }
            return temp.list;
        }
    } 
