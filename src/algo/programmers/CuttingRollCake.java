package algo.programmers;
/**
 * 롤케이크 자르기
 * programmars lv2
 */

import java.util.HashMap;
import java.util.Map;

public class CuttingRollCake {

    class Solution {
        public int solution(int[] topping) {
            int answer = 0;

            Map<Integer, Integer> leftT = new HashMap<>();
            Map<Integer, Integer> rightT = new HashMap<>();

            for (int i = 0; i < topping.length; i++) {
                rightT.put(topping[i], rightT.getOrDefault(topping[i], 0) + 1);
            }

            for (int i = 0; i < topping.length; i++) {
                leftT.put(topping[i], leftT.getOrDefault(topping[i], 0) + 1);
                rightT.put(topping[i], rightT.get(topping[i]) - 1);
                if (rightT.get(topping[i]) == 0)
                    rightT.remove(topping[i]);

                if (leftT.size() == rightT.size())
                    answer++;
            }

            return answer;
        }
    }
}
