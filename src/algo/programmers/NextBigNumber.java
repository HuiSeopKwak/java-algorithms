package algo.programmers;

/***
 * 다음 큰 숫자
 * programmars lv2
 */

public class NextBigNumber {
    class Solution {
        public int solution(int n) {
            String binaryN = Integer.toBinaryString(n);
            int oneCount = 0; // 1의 개수
            int answer = n;

            for (int i = 0; i < binaryN.length(); i++) {
                if (binaryN.charAt(i) == '1')
                    oneCount++;
            }

            while(true) {
                answer++;
                int oneCount1 = 0;
                String temp = Integer.toBinaryString(answer);
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '1')
                        oneCount1++;
                }

                if (oneCount1 == oneCount)
                    return answer;
            }
        }
    }
}
