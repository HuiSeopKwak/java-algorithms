package algo.programmers;

/***
 * 최솟값 만들기
 * programmers lv2
 */

import java.util.Arrays;

public class GeneratingMinimumValue {
    class Solution
    {
        public int solution(int []A, int []B)
        {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            int len = A.length;

            System.out.println(len);

            for (int i = 0; i < len; i++) {
                answer += A[i] * B[len - i - 1];
            }

            return answer;
        }
    }
}
