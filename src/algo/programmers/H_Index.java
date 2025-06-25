package algo.programmers;
/**
 * H-index
 * programmars lv2
 */

import java.util.Arrays;

public class H_Index {
    class Solution {
        public int solution(int[] citations) {

            Arrays.sort(citations);
            int len = citations.length;

            for (int i = 0; i < len; i++) {
                if (len - i <= citations[i]) {
                    return len - i;
                }
            }

            return 0;
        }
    }
}
