    public boolean isMatch(String s, String p) {
        int indexs = 0;
        int indexp = 0;
        int match = 0, startIndex = -1;
        while (indexs < s.length()) {
            if (indexp < p.length() && (p.charAt(indexp) == '?' || s.charAt(indexs) == p.charAt(indexp))) {
                indexs++;
                indexp++;
            }
            else if (indexp < p.length() && p.charAt(indexp) == '*') {
                startIndex = indexp;
                match = indexs;
                indexp++;
            } else if (startIndex != -1) {
                indexp = startIndex + 1;
                match++;
                indexs = match;
            } else {
                return false;
            }
        }
        while (indexp < p.length() && p.charAt(indexp) == '*') {
            indexp++;
        }
        return indexp == p.length();
    }
