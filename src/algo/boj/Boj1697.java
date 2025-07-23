package algo.boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 1697 숨바꼭질
 */

public class Boj1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];
        Arrays.fill(time, -1);

        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        time[n] = 0;
        visited[n] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();

            for (int next : new int[] {cur * 2, cur + 1, cur - 1}) {
                if (next >= 0 && next < 100001 && !visited[next]) {
                    visited[next] = true;
                    time[next] = time[cur] + 1;
                    que.add(next);
                }
            }
        }

//        while(!que.isEmpty()) {
//            int cur = que.poll();
//            if (cur * 2 < 100001 && !visited[cur * 2]) {
//                visited[cur * 2] = true;
//                time[cur * 2] = time[cur] + 1;
//                que.add(cur * 2);
//            }
//            if (cur + 1 < 100001 && !visited[cur + 1]) {
//                visited[cur + 1] = true;
//                time[cur + 1] = time[cur] + 1;
//                que.add(cur + 1);
//            }
//            if (cur - 1 >= 0 && !visited[cur - 1]) {
//                visited[cur - 1] = true;
//                time[cur - 1] = time[cur] + 1;
//                que.add(cur - 1);
//            }
//        }

        System.out.println(time[k]);
    }
}
