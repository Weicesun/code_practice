public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for (int i = 1; i < canSegment.length; i++) {
            canSegment[i] = false;
        }
        int maxLength = getMaxLength(wordDict);
        for (int i = 1; i < canSegment.length; i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                } else {
                    String temp = s.substring(i - j, i);
                    if (wordDict.contains(temp)) {
                        canSegment[i] = true;
                        break;
                    }
                }
            }
        }
        return canSegment[s.length()];
    }
    public int getMaxLength(Set<String> wordDict) {
        int length = 0;
        for (String test : wordDict) {
            length = Math.max(length, test.length());
        }
        return length;
    }
