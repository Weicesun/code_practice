int res;
    public int minCut(String s) {
        char[] array = s.toCharArray();
        int len = s.length();
        int[] cut = new int[len];
        boolean[][] check = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (array[j] == array[i] && (j+1 > i - 1 || check[j + 1][i - 1] )) {
                    check[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                } 
            }
            cut[i] = min;
        }
        return cut[len - 1];
    }
