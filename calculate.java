    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        if (numerator == 0) {
            return "0";
        }
        if (numerator == denominator) {
            return "1";
        }
        int sign = 1;
        long numerator1 = numerator;
        long denominator1 = denominator;
        if (numerator1 * denominator1 < 0) {
            sign = -1;
        }
        numerator1 = Math.abs(numerator1);
        denominator1 = Math.abs(denominator1);
        if (numerator1 > denominator1) {
            long part1 = numerator1 / denominator1;
            long part2 = numerator1 % denominator1;
            if (part2 == 0) {
                return sign*part1 + "";
            }
             String result = helper(part2, denominator1);
             return sign*part1 + "." + result;
        } else {
            String result = helper(numerator1, denominator1);
            if (sign == 1) {
                return 0 + "." + result;
            } else {
                return "-"+0 + "." + result;
            }
            
        }
    }
    public String helper(long num1, long num2) {
        Map<Long,Integer> map = new HashMap<Long, Integer>();
        ArrayList<Long> list = new ArrayList<Long>();
        String result = new String();
        int num = 0;
        while (!map.containsKey(num1) && num1 != 0) {
            map.put(num1, num);
            list.add(num1 * 10 / num2);
            num1 = num1 * 10 % num2;
            num++;
        }
        for (int i = 0; i < list.size(); i++) {
            result += ""+ list.get(i);
        }
        if (num1 != 0) {
            int index = map.get(num1);
            result = result.substring(0, index) + "(" + result.substring(index, result.length()) + ")";
        }
        return result;
    }
// overflow negative and no remain 3 errors
