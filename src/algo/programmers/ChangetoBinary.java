package algo.programmers;

/***
 * 이진변환 반복하기
 * programmers lv2
 */
public class ChangetoBinary {
    class Solution {
        public int[] solution(String s) {
            int removedZero = 0;
            int totalCycle = 0;
            while(s.length() != 1) {
                int cnt = 0;
                // System.out.println(s);
                // System.out.println(s.length());
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0') removedZero++;
                    else cnt++;
                }
                s = Integer.toBinaryString(cnt);
                // System.out.println(s);
                totalCycle++;
            }

            int[] answer = new int[] {totalCycle, removedZero};
            return answer;
        }
    }
}
