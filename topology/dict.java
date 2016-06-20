    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String res = new String();
        if (words == null || words.length == 0) {
            return res;
        }
        for (String s : words) {
            char[] array = s.toCharArray();
            for (char c : array) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            int len = Math.min(current.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                if (c1 == c2) {
                    continue;
                } else {
                    if (map.containsKey(c1)) {
                        if (!map.get(c1).contains(c2)) {
                            map.get(c1).add(c2);
                            int t = degree.get(c1);
                            degree.put(c1, t + 1);
                        }
                        
                    } else {
                        Set<Character> set = new HashSet<>();
                        set.add(c2);
                        map.put(c1, set);
                        int t = degree.get(c1);
                        degree.put(c1, t + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        for (Character c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            Character delete = queue.poll();
            res = delete + res;
            for (Character ch : map.keySet()) {
                if (map.get(ch).contains(delete)) {
                    int t = degree.get(ch) - 1;
                    degree.put(ch, t);
                    if (t == 0) {
                        queue.offer(ch);
                    }
                }
            }
        }
        if (res.length() != degree.size()) {
            return new String();
        }
        return res;
    }
