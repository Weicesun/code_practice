public List<String> findRepeatedDnaSequences(String s) {
        // already see the answer
        Set<Integer> firstTime = new HashSet<Integer>();
        Set<Integer> secondTime = new HashSet<Integer>();
        List<String> list = new ArrayList<>();
        if (s == null && s.length() == 0) {
            return list;
        }
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if (!firstTime.add(v) && secondTime.add(v)) {
                list.add(s.substring(i, i + 10));
            }
        }
        return list;
