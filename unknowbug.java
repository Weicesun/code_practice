package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> res = new ArrayList<>();
        String[][] test = {
                {"red", "green", "green"},
                {"black", "blue", "black"},
                {"red", "yellow", "yellow"}
        };
        res = Yelp(test);
        Collections.sort(res);
        for (String ele : res) {
            System.out.println(ele);
        }
    }
    static List<String> Yelp(String[][] test) {
        List<String> res = new ArrayList<>();
        if (test == null || test.length == 0 || test[0].length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                if (!map.containsKey(test[i][j])) {
                    map.put(test[i][j], 1);
                } else {
                    map.put(test[i][j], map.get(test[i][j]) + 1);
                }
            }
        }
        int max = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}

