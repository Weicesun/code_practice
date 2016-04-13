    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        search(n, result, new ArrayList<Integer>());
        return result;
    }
    public void search(int n, List<List<String>> result, ArrayList<Integer> cols) {
        if (cols.size() == n) {
            result.add(new ArrayList<String>(drawLine(cols)));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(col, cols)) {
                continue;
            }
            cols.add(col);
            search(n, result, cols);
            cols.remove(cols.size() - 1);
        }
    }
    public boolean isValid(int col, ArrayList<Integer> cols) {
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (cols.get(i) - col == i - cols.size()) {
                return false;
            }
            if (col - cols.get(i) == i - cols.size()) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> drawLine(ArrayList<Integer> cols) {
        ArrayList<String> result1 = new ArrayList<String>();
        for (int i = 0; i < cols.size(); i ++) {
            String temp = "";
            for (int j = 0; j < cols.size(); j++) {
                
                if (j != cols.get(i)) {
                    temp += ".";
                } else {
                    temp += "Q";
                }
            }
            result1.add(temp);
        }
        return result1;
    }
