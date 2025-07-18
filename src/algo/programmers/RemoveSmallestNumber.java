package algo.programmers;

/**
 * 제일 작은 수 제거하기
 * programmars lv1
 */
public class RemoveSmallestNumber {

    class Solution {
        public int[] solution(int[] arr) {
            int minIdx = 0;
            int minValue = Integer.MAX_VALUE;
            int[] answer = {};

            if (arr.length == 1)
                return new int[] {-1};

            answer = new int[arr.length - 1];

            for (int i = 0; i < arr.length; i++) {
                if (minValue > arr[i]) {
                    minIdx = i;
                    minValue = arr[i];
                }
            }

            for (int i = 0; i < minIdx; i++) {
                answer[i] = arr[i];
            }
            for (int i = minIdx; i < arr.length - 1; i++) {
                answer[i] = arr[i + 1];
            }

            return answer;
        }
    }
}
