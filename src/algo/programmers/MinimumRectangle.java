package algo.programmers;

/**
 * 최소직사각형
 * programmars lv1
 */
public class MinimumRectangle {

    class Solution {
        public int solution(int[][] sizes) {
            // 가로, 세로 중 최대 MAX 구하고, 양변 중 짧은 쪽의 최대 MAX 길이를 곱해주면 된다.
            int Max1 = 0;
            int Max2 = 0;

            for (int i = 0; i < sizes.length; i++) {
                for (int j = 0; j < 2; j++) {
                    Max1 = Math.max(Max1, sizes[i][j]);
                }
                int temp = (sizes[i][0] > sizes[i][1]) ? sizes[i][1] : sizes[i][0];                     Max2 = Math.max(Max2, temp);
            }

            int answer = Max1 * Max2;
            return answer;
        }
    }
}
