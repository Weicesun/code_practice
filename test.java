public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String test = "aeiouAEIOU";
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (test.contains(s.charAt(i) + "")) {
                list.add(s.charAt(i));
                indexs.add(i);
            }
        }
        char[] array = s.toCharArray();
        for (int k = 0; k < indexs.size() ; k++) {
            array[indexs.get(k)] = list.get(list.size() - 1 - k);
        }
        return String.valueOf(array);
    }

public int shortestWordDistance(String[] words, String word1, String word2) {
        int d1 = -1;
        int d2 = -1;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2) && d1 != -1) {
                    d2 = d1;
                    d1 = i;
                } else {
                    d1 = i;
                }
                if (d2 != -1) {
                    shortest = Math.min(shortest, d1 - d2);
                }
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    continue;
                } else {
                    d2 = i;
                }
                if (d1 != -1) {
                    shortest = Math.min(shortest, d2 - d1);
                }
            }
        }
        return shortest;
    }
