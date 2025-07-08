package algo.programmers;

import java.util.TreeMap;

/**
 * 이중 우선 순위 큐
 * programmars lv3
 */
public class DoublePriorityQueue {

    class Solution {
        public int[] solution(String[] operations) {

            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for (int i = 0; i < operations.length; i++) {
                String[] order = operations[i].split(" ");
                int value = Integer.parseInt(order[1]);
                if (order[0].equals("I")) {
                    tm.put(value, tm.getOrDefault(value, 0) + 1);
                    // System.out.println(tm.toString());
                }
                else { // D인 경우

                    if (tm.isEmpty())
                        continue;
                    if (order[1].equals("1")) {
                        int key = tm.lastKey();
                        if (tm.get(key) == 1) tm.remove(key);
                        else tm.put(key, tm.get(key) - 1);
                        // System.out.println(tm.toString());
                    }
                    else {  // -1 인 경우
                        int key = tm.firstKey();
                        if (tm.get(key) == 1) tm.remove(key);
                        else tm.put(key, tm.get(key) - 1);
                        // System.out.println(tm.toString());
                    }
                }
            }
            if (tm.isEmpty())
                return new int[] {0, 0};
            else
                return new int[] {tm.lastKey(), tm.firstKey()};
        }
    }
}
