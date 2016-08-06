public class Solution {
    public String getHint(String secret, String guess) {
        List<Character> set = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        int len = Math.min(secret.length(), guess.length());
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                set.add(secret.charAt(i));
                list.add(guess.charAt(i));
            }
        }
        if (secret.length() < guess.length()) {
            for (int i = len; i < guess.length(); i++) {
                list.add(guess.charAt(i));
            }
        }
        if (guess.length() < secret.length()) {
            for (int i = len; i < secret.length(); i++) {
                set.add(secret.charAt(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if (set.size() > 0 && set.contains(c)) {
                cow++;
                set.remove((Character)c);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull).append("A").append(cow).append("B");
        return sb.toString();
    }
}
