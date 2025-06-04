package algo.programmers;

/***
 * 피보나치 수
 * programmars lv2
 */

public class Fibonacci {
    class Solution {
        public int solution(int n) {
            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;
            for(int i = 2; i <= n; i++)
                nums[i] = (nums[i-1] + nums[i-2]) % 1234567;

            return nums[n];

        }
    }
}
