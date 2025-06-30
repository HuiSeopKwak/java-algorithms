package algo.programmers;
/**
 * 할인 행사
 * programmars lv2
 */

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            Map<String, Integer> items = new HashMap<>();
            // discount에 추가
            for (int i = 0; i < 10; i++) {
                items.put(discount[i], items.getOrDefault(discount[i], 0) + 1);
            }
            // 비교 함수 호출
            if (check(want, number, items))
                answer++;

            // idx 계속 올리면서 비교함수 호출
            for (int i = 0; i < discount.length - 10; i++) {
                items.put(discount[i], items.get(discount[i]) - 1);
                items.put(discount[i + 10], items.getOrDefault(discount[i + 10], 0) + 1);
                if (check(want, number, items))
                    answer++;
            }
            // 결국 위에서 안끝난다면 마지막 return 0 해줌
            return answer;
        }

        static public boolean check(String[] want, int[] number, Map<String, Integer> items) {
            for (int i = 0; i < want.length; i++) {
                if (items.getOrDefault(want[i], 0) != number[i])
                    return false;
            }
            return true;
        }
    }
}
