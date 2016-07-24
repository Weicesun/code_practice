import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class mine {
        int dis;
        int amount;
        List<Integer> cost = new ArrayList<>();
        public mine(int dis, int amount) {
            this.dis = dis;
            this.amount = amount;
        }
    }
    static int money = Integer.MAX_VALUE;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int conint = sc.nextInt();
        List<mine> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int dis = sc.nextInt();
            int amount = sc.nextInt();
            list.add(new mine(dis, amount));
        }
        for (mine m : list) {
            for (mine nm : list) {
                m.cost.add(m.amount*(Math.abs(m.dis - nm.dis)));
            }
        }
        List<Integer> choose = new ArrayList<>();
        helper(list, conint, 0, choose);
        System.out.println(money);
    }
    public static void helper(List<mine> list, int conint, int start, List<Integer> choose) {
        if (conint == 0) {
            int total = 0;
            for (int j = 0; j < list.size(); j++) {
                mine temp = list.get(j);
                int cost1 = Integer.MAX_VALUE;
                for (int ii : choose) {
                    cost1 = Math.min(cost1, temp.cost.get(ii));
                }
                total += cost1;
            }
            money = Math.min(money, total);
        }
        for (int i = start; i < list.size(); i++) {
            choose.add(i);
            helper(list, conint - 1, i + 1, choose);
            choose.remove(choose.size() - 1);
        }
    }
}
