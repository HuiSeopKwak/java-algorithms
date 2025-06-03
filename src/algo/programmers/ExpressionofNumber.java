package algo.programmers;

/***
 * 숫자의 표현
 * programmers lv2
 */
public class ExpressionofNumber {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for (int i = 1; i < n; i++) {
                int total = i;
                for (int j = i + 1; j < n; j++) {
                    total += j;
                    if (total == n) {
                        answer++;
                        // System.out.println("total == n일때 i와 j값 : " + i + " ," + j);
                        break;
                    }
                    else if (total > n)
                        break;
                }
            }
            // n이 값이 n인 자연수 하나로만 완성되는 경우를 더해줌
            answer++;
            return answer;
        }
    }
}
