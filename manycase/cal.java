    public String fractionToDecimal(int numerator1, int denominator1) {
        long numerator = numerator1;
        long denominator = denominator1;
        if (numerator == 0) {
            return 0+"";
        }
        String res = new String();
        int sign = 1;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sign = -1;
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        if (numerator >= denominator) {
          res = res + numerator / denominator;
          numerator = numerator % denominator;
        }
        if (numerator == 0) {
            if (sign == -1)
            return "-" + res;
            return res;
        }
        if (res.length() == 0) {
            res += "0";
        }
        res = res + ".";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        String sm = new String();
        int index = 0;
        numerator = numerator * 10;
        while (!map.containsKey(numerator)) {
            
            map.put(numerator,index);
            while (numerator < denominator) {
                numerator *= 10;
                sm += "0";
                index++;
                map.put(numerator, index);
                
            }
            sm = sm + numerator / denominator;
            index++;
            numerator = numerator % denominator;
            numerator = numerator * 10;
            if (numerator == 0) {
                if (sign == -1)
                return "-" + res + sm;
                return res + sm;
            }
        }
        int seg = map.get(numerator);
        sm = sm.substring(0, seg) + "(" + sm.substring(seg, sm.length()) + ")";
        if (sign == -1)
        return "-" + res + sm;
        
        return res + sm;
    }
