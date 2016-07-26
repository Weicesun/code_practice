public class Solution {
    public String fractionToDecimal(int numerator1, int denominator1) {
        long numerator = numerator1;
        long denominator = denominator1;
        
        String res = new String();
        int sign = 1;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sign = -1;
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        if ( numerator % denominator == 0) {
            res = res + numerator / denominator;
            if (sign < 0) {
                res = "-" + res;
            }
            return res;
        } else {
            res = res + numerator / denominator;
            numerator = numerator % denominator;
            res = res  + ".";
            Map<Long, Integer> map = new HashMap<>();
            String temp = new String();
            numerator = numerator % denominator;
            int index = 0;
            numerator = numerator * 10;
            while (!map.containsKey(numerator)) {
                map.put(numerator, index);
                while (numerator < denominator) {
                    index++;
                    numerator = numerator * 10;
                    temp += "0";
                    map.put(numerator, index);
                }
                temp = temp + numerator / denominator;
                index++;
                numerator = numerator % denominator;
                numerator = numerator * 10;
                if (numerator == 0) {
                    if (sign < 0) {
                        res = "-" + res + temp;
                        return res;
                    }
                    return res + temp;
                }
            }
            int seg = map.get(numerator);
            temp = temp.substring(0, seg) + "(" + temp.substring(seg, temp.length()) + ")";
            if (sign < 0) {
                res = "-" + res + temp;
                return res;
            } else {
                return res + temp;
            }
        }
       
    }
}
