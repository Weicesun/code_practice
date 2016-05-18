public class MiniCassandra {
    Map<String, Map<Integer, String>> cassandra;
    public MiniCassandra() {
        // initialize your data structure here.
        cassandra = new HashMap<>();
    }
    
    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        if (cassandra.containsKey(raw_key)) {
            Map<Integer, String> map = cassandra.get(raw_key);
            map.put(column_key, column_value);
        } else {
            Map<Integer, String> map = new HashMap<>();
            map.put(column_key, column_value);
            cassandra.put(raw_key, map);
        }
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        List<Column> result = new ArrayList<Column>();
        if (!cassandra.containsKey(raw_key)) {
            return result;
        }
        Map<Integer, String> map = cassandra.get(raw_key);
        for (int i = column_start; i <= column_end; i++) {
            if (!map.containsKey(i)) {
                continue;
            } else {
                Column tempC = new Column(i, map.get(i));
                result.add(tempC);
            }
        }
        return result;
    }
}
