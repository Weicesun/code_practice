public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        ArrayList<Integer> machine = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        machine.add(0);
        machine.add(359);
        machine.add(1);
        result.add(machine);
        for (int i = 1; i < n; i++) {
            int index = 0;
            for (int j = 1; j < i; j++) {
                if (result.get(j).get(1) - result.get(j).get(0) + 1 
                > result.get(index).get(1) - result.get(index).get(0) + 1) {
                    index = j;
                }
            }
            int x = result.get(index).get(0);
            int y = result.get(index).get(1);
            result.get(index).set(1, (x + y) / 2);
            ArrayList<Integer> newMachine = new ArrayList<>();
            newMachine.add((x + y) / 2 + 1);
            newMachine.add(y);
            newMachine.add(i + 1);
            result.add(newMachine);
        }
        return result;
    }
