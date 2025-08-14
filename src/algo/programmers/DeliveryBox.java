package algo.programmers;

import java.util.Stack;

/**
 * 택배상자
 * programmars lv2
 */
public class DeliveryBox {

    class Solution {
        public int solution(int[] order) {
            // stack 하나는 메인 컨테이너, 다른 stack으로 보조 컨테이너 구현
            // 원하는 순서와 일치 시 바로 넣고 안되면 보조 que가 비어있지 않다면
            // que peek 후 일치 시 빼고 다시 돌기
            // 만약 성공하면 continue 시키고 while문 맨 밑까지 내려오면 break 후 현재 answer값 return
            int answer = 0;
            int idx = 0;

            Stack<Integer> mainS = new Stack<>();
            Stack<Integer> subS = new Stack<>();

            for (int i = order.length; i > 0; i--)
                mainS.add(i);

            while(!mainS.isEmpty()) {
                // main에서 나오는게 현재 order의 idx와 같을때
                if (order[idx] == mainS.peek()) {
                    idx++;
                    mainS.pop();
                    answer++;
                    continue;
                }
                // main에서 나오는게 현재 order의 idx와 다를때
                else {
                    // sub가 비어있지 않을때
                    if (!subS.isEmpty()) {
                        // sub에 처음으로 나올 값이 원하는 값일때
                        if (order[idx] == subS.peek()) {
                            idx++;
                            subS.pop();
                            answer++;
                            continue;
                        }
                        // 원하는 값이 아닐때
                        else {
                            // sub에 main pop 해서 넣어줌
                            subS.push(mainS.pop());
                            continue;
                        }
                    }
                    // sub가 비어있을때
                    else {
                        subS.push(mainS.pop());
                        continue;
                    }
                }

//             System.out.println(mainS.toString());
//             System.out.println(subS.toString());
            }

            // 위에선 main 끝, 남은 sub에서 되는지 확인
            while (!subS.isEmpty()) {
                if (subS.pop() == order[idx]) {
                    idx++;
                    answer++;
                }
                else
                    break;
            }

            return answer;
        }
    }
}
