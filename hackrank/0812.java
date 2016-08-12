import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n <= 0 || m <= 0) {
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        init(n, map, 0, new StringBuilder());
        int[] array = new int[n];
        for (int i = 0; i < m; i++) {
            int opt = sc.nextInt();
            if (opt == 1) {
                int val = sc.nextInt();
                int nlocation = sc.nextInt();
                String location = "" + nlocation;
                char[] array = location.toCharArray();
                update1(array, val, map, 0, new StringBuilder());
                
            } else if (opt == 2) {
                int val = sc.nextInt();
                int nlocation = sc.nextInt();
                String location = "" + nlocation;
                char[] array = location.toCharArray();
                update2(array, val, map, 0, new StringBuilder());
            } else {
                int nlocation = sc.nextInt();
                String location = "" + nlocation;
                int prt = map.get(location);
                System.out.println(prt);
            }
            
        }
    }
    public void init(int n, Map<String, Integer> map, int index, StringBuilder sb) {
        if (index == n) {
            map.put(sb.toString(), 0);
            return;
        }
        sb.append(0);
        init(n, map, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(1);
        init(n, map, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    public void update1(char[] array, int val, Map<String, Integer> map, int index, StringBuilder sb) {
        if (index == array.length()) {
            map.put(sb.toString(), val);
        }
        if (array[index] == '1') {
            sb.append(0);
            update1(array, val, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(1);
            update1(array, val, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(0);
            update1(array, val, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public void update2(char[] array, int val, Map<String, Integer> map, int index, StringBuilder sb) {
        if (index == array.length()) {
            int temp = map.get(sb.toString());
            temp = (val^temp)
            map.put(sb.toString(), temp);
        }
        if (array[index] == '1') {
            sb.append(0);
            update2(array, val, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(1);
            update2(array, val, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(0);
            update2(array, val, map, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
