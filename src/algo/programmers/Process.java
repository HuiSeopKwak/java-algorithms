package algo.programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프로세스
 * programmars lv2
 */
public class Process {
    class Solution {
        public int solution(int[] priorities, int location) {
            int idx = 0;    // 순서용
            Queue<Integer> que = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < priorities.length; i++) {
                que.add(priorities[i]);
                pq.add(priorities[i]);
            }
            // 큐들에 입력 완;

            // System.out.println(pq.poll());
            // System.out.println(pq.poll());

            while(!que.isEmpty()) {
                int len = que.size();
                int max = pq.poll();
                int now = que.poll();
                // 현재값이 max값이랑 일치할때 +
                if (now == max) {
                    idx++;
                    System.out.println("now : "+now+" max : "+max+" loc : "+location+" idx : "+idx);
                    // location이 0일때 나온다면
                    if (location == 0) return idx;
                        // 아니면 한칸 앞으로 당기면서 타켓 location 위치도 당겨줌
                    else location = (location - 1 + len) % len;
                }
                // 현재값이 max값이랑 일치하지 않을때
                else {
                    pq.add(max);
                    que.add(now);
                    location = (location - 1 + len) % len;
                }
            }
            return idx;
        }
    }
}
