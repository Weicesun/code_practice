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
