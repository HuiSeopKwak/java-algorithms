package algo.programmers;

import java.util.Stack;

/**
 * 주식 가격
 * programmars lv2
 */
public class StockPrice {

    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            // 숫자, 인덱스 순서
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {
                // 가격이 떨여졌을대
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    int top = stack.pop();
                    answer[top] = i - top;
                }
                stack.add(i);
            }
            System.out.println(stack.toString());
            while (!stack.isEmpty()) {
                int top = stack.pop();
                answer[top] = prices.length - top - 1;
            }
            return answer;
        }
    }
}
