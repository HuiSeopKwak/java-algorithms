package algo.programmers;

/**
 * n^2 배열 자르기
 * programmars lv2
 */
public class N2ArraySlicing {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int size = (int) (right - left + 1);
            int[] answer = new int[size];


            int idx = 0;
            for (long i = left; i <= right; i++) {
                int ny = (int)(i / n);
                int nx = (int)(i % n);

                answer[idx++] = Math.max(ny + 1, nx + 1);
            }


            return answer;

        }
    }
}
