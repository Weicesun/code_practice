  public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(ticket[1]);
                map.put(ticket[0], temp);
            } else {
                map.get(ticket[0]).add(ticket[1]);
            }
        }
        for (ArrayList<String> list : map.values()) {
            Collections.sort(list);
        }
        
        
        helper(result, tickets, "JFK", map);
        return result;
    }
    public boolean helper(List<String> result, String[][] tickets, String target, HashMap<String, ArrayList<String>> map) {
        result.add(target);
        if (result.size() == tickets.length + 1) {
            return true;
        }
        if (!map.containsKey(target) || map.get(target).isEmpty()) {
            return false;
        }
        ArrayList<String> nextTarget = map.get(target);
        for (int i = 0; i < nextTarget.size(); i++) {
            String arrive = nextTarget.remove(i);
            if(helper(result, tickets, arrive, map)) {
                return true;
            }
            result.remove(result.size() - 1);
            nextTarget.add(i, arrive);
        }
        return false;
    }
