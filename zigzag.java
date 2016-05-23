public class Solution {
    public String convert(String s, int numRows) {
        String[] list = new String[numRows];
        for (int i = 0; i < list.length; i++) {
            list[i] = new String();
        }
        String result = new String();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (numRows == 1) {
            return s;
        }
        int flag = 1;
        int tempi = -1;
        for (int i = 0; i < s.length(); i++) {
            if (flag == 1) {
                tempi++;
            }
            if (flag == -1) {
                tempi--;
            }
            if (tempi == numRows - 1) {
                flag = -1;
            }
            if (tempi == 0) {
                flag = 1;
            }
            list[tempi] = list[tempi] + s.charAt(i);
        }
        
        for (int k = 0; k < numRows; k++) {
            if (list[k] != null && list[k].length() != 0) {
                result = result + list[k];
            }
            
        }
        return result;
    }
}
