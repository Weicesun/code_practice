public int canCompleteCircuit(int[] gas, int[] cost) {
        // null
        if (gas == null || gas.length == 0) {
            return -1;
        }
        int totalGas = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i]; 
            if (tank < 0) {
                totalGas += tank;
                tank = 0;
                start = i + 1;
            }
        }
        return totalGas + tank < 0 ? -1 : start;
    }
