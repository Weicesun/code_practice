public int integerBreak(int n) {
        int flag = n % 3;
        int result = 1;
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (flag == 0) {
            for (int i = 0; i < n / 3; i++) {
                result = result * 3;
            }
        } else if (flag == 1) {
            for (int i = 0; i < n / 3 - 1; i++) {
                result = result * 3;
            }
            result = result * 4;
        } else {
            for (int i = 0; i < n / 3; i++) {
                result = result * 3;
            }
            result = result * 2;
        }
        return result;
    }
find the logn solution
