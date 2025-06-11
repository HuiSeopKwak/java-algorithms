package algo.programmers;

import java.util.*;

/***
 * 귤 고르기
 * programmars lv2
 */

public class ChoosingTangerines {

    class Solution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> count = new HashMap<>();

            for (int size : tangerine)
                count.put(size, count.getOrDefault(size, 0) + 1);

            List<Integer> counts = new ArrayList<>(count.values());
            counts.sort(Collections.reverseOrder());

            int sum = 0;
            int answer = 0;
            for (int c : counts) {
                answer++;
                sum += c;
                if (sum >= k)
                    return answer;
            }


            return answer;
        }
    }
}
