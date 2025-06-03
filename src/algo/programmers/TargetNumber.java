package algo.programmers;

/***
 * 타켓넘버
 * programmars lv2
 */
public class TargetNumber {
    class Solution {
        static int answer = 0;
        public int solution(int[] numbers, int target) {
            recursive(numbers, target, 0, 0);

            return answer;
        }

        static public void recursive(int[] numbers, int target, int idx, int num) {
            // 마지막 까지 탐색 완 + 목표 숫자만들었을때
            if (idx == numbers.length) {
                if (num == target)
                    answer++;
                return;
            }
            else {
                recursive(numbers, target, idx + 1, num + numbers[idx]);
                recursive(numbers, target, idx + 1, num - numbers[idx]);
            }
        }
    }
}
