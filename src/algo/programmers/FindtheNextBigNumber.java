package algo.programmers;
/**
 * 뒤에 있는 큰 수 찾기
 * programmars lv2
 */

import java.util.Arrays;
import java.util.Stack;

public class FindtheNextBigNumber {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> st = new Stack<>();
            Arrays.fill(answer, -1);

            for (int i = numbers.length - 1; i >= 0; i--) {
                int cur = numbers[i];

                // 스택이 비지않았고 현재값 보다 작으면 -> 후보가 될 수 없다.
                while (!st.isEmpty() && st.peek() <= cur) {
                    st.pop();
                }
                // 위에 사이클 다 돌았는데 비지 않았다는 뜻 -> 더 큰값이 있었다
                if (!st.isEmpty()) {
                    answer[i] = st.peek();
                }
                // 없었으면 어차피 -1, 다 끝내고 본인 삽입 후 앞의 값으로 탐색
                st.push(cur);
            }

            return answer;

        }
    }
}
