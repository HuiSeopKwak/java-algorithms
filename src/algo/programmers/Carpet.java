package algo.programmers;

/***
 * 카펫
 * programmars lv2
 */

public class Carpet {
    class Solution {
        public int[] solution(int brown, int yellow) {

            for (int i = 1; i <= yellow; i++) {
                if (yellow % i == 0) {
                    System.out.println("i는 : " + i);
                    System.out.println(((yellow / i) + 2) * (i + 2) - yellow);
                    if ((((yellow / i) + 2) * (i + 2) - yellow) == brown) {
                        int a1 = Math.max((yellow / i) + 2, i+2);
                        int a2 = Math.min((yellow / i) + 2, i+2);
                        return new int[] {a1, a2};
                    }
                }
            }
            return new int[] {-1, -1};
        }
    }
}
