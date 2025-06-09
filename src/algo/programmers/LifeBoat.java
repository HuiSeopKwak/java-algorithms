package algo.programmers;
/***
 * 구명보트
 * programmars lv2
 */

import java.util.Arrays;

public class LifeBoat {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int left = 0;
            int right = people.length - 1;

            Arrays.sort(people);

            while(left <= right) {
                if (people[right] + people[left] <= limit) {
                    right--;
                    left++;
                }
                else {
                    right--;
                }
                answer++;
            }

            return answer;
        }
    }
}
