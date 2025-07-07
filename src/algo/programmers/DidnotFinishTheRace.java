package algo.programmers;
/**
 * 완주하지 못한 선수
 * programmars lv1
 */

import java.util.HashMap;
import java.util.Map;

public class DidnotFinishTheRace {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> map = new HashMap<>();

            for (String s : participant)
                map.put(s, map.getOrDefault(s, 0) + 1);

            for (String s : completion)
                map.put(s, map.get(s) - 1);

            String answer = "";
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                if (entry.getValue() == 1) {
                    answer = entry.getKey();
                    break;
                }
            }

            // for (String key : map.keySet()) {
            //     if (map.get(key) == 1) {
            //         answer = key;
            //         break;
            //     }
            // }

            return answer;
        }
    }
}
