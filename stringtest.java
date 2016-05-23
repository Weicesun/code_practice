int low, len;
    public String longestPalindrome(String s) {
        String result = new String();
        int max = 1;
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length() - max; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + len);
    }
    public void extendPalindrome(String temp, int start, int end) {
        while (start >= 0 && end < temp.length() && temp.charAt(start) == temp.charAt(end)) {
            if (end - start + 1 > len) {
                low = start;
                len = end - start + 1;
            }
            start--;
            end++;
        }
        
    }
