package algo.programmers;

/**
 * N개의 최소공배수
 * programmars lv2
 */
public class NLeastCommonMultiples {
    class Solution {
        public int solution(int[] arr) {
            int answer = 0;

            for (int i : arr) {
                if (answer < i)
                    answer = i;
            }

            while(true) {
                if (checkOK(arr, answer))
                    return answer;
                else
                    answer++;
            }
        }
        static public boolean checkOK(int[] arr, int n) {
            for (int i : arr) {
                if (n % i != 0)
                    return false;
            }

            return true;
        }
    }
}
