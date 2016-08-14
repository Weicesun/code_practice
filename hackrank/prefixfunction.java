import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num <= 0) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        //System.out.println(num);
        for (int z = 0; z < num; z++) {
            
            String opt = sc.next();
            if (opt.equals("+")) {
                int add = sc.nextInt();
                list.add(add);
                sb.append(add);
            } else if (opt.equals("-")) {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            String s = sb.toString();
            if (map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                if (list.size() <= 1) {
                    System.out.println(0);
                } else {
                    int k = list.size() - 1;
                    if (k > 1 && map.containsKey(s.substring(0, k))) {
                        k = map.get(s.substring(0, k)) + 1;
                    }
                    while (k > 0) {
                        if (s.substring(0, k).equals(s.substring(s.length() - k))) {
                            break;
                        }
                        k--;
                    }
                    System.out.println(k);
                    map.put(s, k);
                }
            }
            
        }
    }
}
