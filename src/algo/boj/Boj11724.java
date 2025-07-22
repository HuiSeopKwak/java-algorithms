package algo.boj;
/**
 * 백준 11724 연결 요소의 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11724 {
    static int N, M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        // 입력 끝

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                recursiveBfs(i, list);
                answer++;
            }
        }

        System.out.println(answer);

    }
    private static void recursiveBfs(int i, ArrayList<Integer>[] list) {
        visited[i] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(i);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
