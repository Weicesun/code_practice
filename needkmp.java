public class Solution {
    //KMP
    public String shortestPalindrome(String s) {
        String res = new String();
        int len = -1;
        int index = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        if (isPalindrome(s)) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            
            if (isPalindrome(s1)) {
                if (s1.length() > len) {
                    len = s1.length();
                    res = s1;
                    index = i;
                } 
            }
            
        }
        StringBuilder sb = new StringBuilder();
        if (len <= 0) {
            sb.append(s);
            sb.reverse().append(s);
            return sb.toString();
        } else {
            
                sb.append(s.substring(index));
                sb.reverse();
                
                sb.append(s);
        }
        return sb.toString();
    }
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
