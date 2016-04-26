 public List<String> generatePalindromes(String s) {
        int[] array = new int[256];
        String mid = "";
        List<String> result = new ArrayList<String>();
        ArrayList<Character> list = new ArrayList<Character>();
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (array[i]%2 == 1) {
                odd++;
                mid = mid + (char)( i);
                if (odd > 1) {
                    return result;
                }
            } 
            if (array[i] != 0) {
                for (int j = 0; j < array[i] / 2; j++) {
                    list.add((char)( i));
                }
            }
        }
        permutation(list, result, mid, new StringBuilder(), new boolean[list.size()]);
        return result;
    }
    public void permutation(ArrayList<Character> list, List<String> result, String mid, StringBuilder sb, boolean[] visited) {
        if (sb.length() == list.size()) {
            result.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (visited[i] || ( i > 0 && list.get(i - 1) == list.get(i)  && !visited[i - 1])) {
                continue;
            }
            sb.append(list.get(i));
            visited[i] = true;
            permutation(list, result, mid, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
