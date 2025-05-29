package algo.programmers;

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
