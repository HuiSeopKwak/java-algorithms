package algo.boj;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * 백준 13549 숨바꼭질 3
 */
public class Boj13549 {
    static int k;
    static int[] time = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        Arrays.fill(time, -1);
        dq.offer(n);
        time[n] = 0;

        while(!dq.isEmpty()) {
            int now = dq.poll();
//            if (now < 100)
//                System.out.println("now : " + now);
            if (now * 2 < 100001 && (time[now*2] == -1 || time[now * 2] > time[now])) {
                time[now * 2] = time[now];
                dq.offerFirst(now * 2);
            }
            if (now + 1 < 100001 && time[now + 1] == -1) {
                time[now + 1] = time[now] + 1;
                dq.offerLast(now + 1);
            }
            if (now - 1 >= 0 && time[now - 1] == -1) {
                time[now - 1] = time[now] + 1;
                dq.offerLast(now - 1);
            }
        }
//        for (int i = 3; i < 17; i++) {
//            System.out.println("time["+i+"] = "+time[i]);
//        }
        System.out.println(time[k]);

    }

}
