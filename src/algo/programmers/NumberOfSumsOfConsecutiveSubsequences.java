package algo.programmers;
/**
 * 연속 부분 수열 합의 개수
 * programmars lv2
 */

import java.util.HashSet;
import java.util.Set;

public class NumberOfSumsOfConsecutiveSubsequences {

    class Solution {
        public int solution(int[] elements) {
            // set으로 갯수 셀거임
            Set<Integer> nums = new HashSet<>();
            // element 길이
            int length = elements.length;

            for (int i = 1; i <= length; i++) {
                for (int j = 0; j < length; j++) {
                    int num = 0;
                    for (int k = j; k < j + i; k++) {
                        num += elements[k % length];
                    }
                    // System.out.println(num);
                    nums.add(num);
                }
            }

            int answer = nums.size();
            return answer;
        }
    }
}
