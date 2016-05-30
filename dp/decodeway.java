public int numDecodings(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        result[0] = 1; 
        result[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
                return 0;
            }
            else if (s.charAt(i - 1) == '0') {
                result[i] = result[i - 2];
            }
            else if (s.charAt(i - 1) != '0' && (s.charAt(i - 2) == '1')) {
                result[i] = result[i - 1] + result[i - 2];
            }
            else if (s.charAt(i - 1) != '0' && s.charAt(i - 1) < '7' && (s.charAt(i - 2) == '2')) {
                result[i] = result[i - 1] + result[i - 2];
            } else {
                result[i] = result[i - 1];
            }
        }
        return result[n];
    }
