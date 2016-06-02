    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> tested = new HashSet<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        tested.add(beginWord);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                ArrayList<String> nextWs = nextwords(temp, wordList);
                
                for (String nextword : nextWs) {
                    if (tested.contains(nextword)) {
                        continue;
                    }
                    if (nextword.equals(endWord)) {
                        return length;
                    }
                    tested.add(nextword);
                    queue.offer(nextword);
                }
                
            }
        }
        return 0;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    public ArrayList<String> nextwords(String s1, Set<String> wordList) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < s1.length(); i++) {
                if (c == s1.charAt(i)) {
                    continue;
                }
                String nextWord = replace(s1, i, c);
                if (wordList.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
