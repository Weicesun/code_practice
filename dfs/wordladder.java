 int num = Integer.MAX_VALUE;
    int times = 1;
     public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> countered = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<List<String>>();
        List<String> ll = new ArrayList<>();
        ll.add(beginWord);
        queue.offer(ll);
        countered.add(beginWord);
        wordList.add(endWord);
        helper(queue, endWord, countered, wordList, res);
        
        return res;
    }
    public void helper(Queue<List<String>> queue, String endWord, Set<String> countered, Set<String> wordList, List<List<String>> res) {
        if (queue.isEmpty()) {
            return;
        }
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            //System.out.println(size);
            for (int i = 0; i < size; i++) {
                List<String> list = queue.poll();
                String beginWord = list.get(list.size() - 1);
                
                if (beginWord.equals(endWord)) {
                    if (num >= times) {
                        num = times;
                        res.add(new ArrayList<String>(list));
                    }
                }
                if (times > num) {
                    continue;
                }
                char[] array = beginWord.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    char c = 'a';
                    char backup = array[j];
                    for (int k = 0; k < 26; k++) {
                        array[j] = (char)(c + k);
                        String ns = new String(array);
                        
                        if (!countered.contains(ns) && wordList.contains(ns)) {
                            
                            list.add(ns);
                            
                            countered.add(ns);
                            List<String> temp = new ArrayList<>();
                            
                            temp.addAll(list);
                            
                            queue.offer(temp);
                            list.remove(list.size() - 1);
                            countered.remove(ns);
                        }
                    }
                    array[j] = backup;
                }
            }
            if (times == num) {
                return;
            }
            times++;
        }
    }
