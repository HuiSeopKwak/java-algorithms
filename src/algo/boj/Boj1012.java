package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1012 유기농 배추
 */
public class Boj1012 {
    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int testCase = 0; testCase < T; testCase++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            // 입력 끝
//            for (int y = 0; y < n; y++) {
//                for (int x = 0; x < m; x++) {
//                    System.out.print(map[y][x] + " ");
//                }
//                System.out.println();
//            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] == 1 && !visited[y][x]) {
//                        System.out.println("we go to bfs y : " + y + " x : " + x);
                        bfs(y, x);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    static public void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {y, x});
        visited[y][x] = true;
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for (int d = 0; d < 4; d++) {
                int ny = temp[0] + dy[d];
                int nx = temp[1] + dx[d];
                if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && map[ny][nx] == 1) {
                    que.add(new int[] {ny, nx});
//                    System.out.println("what is added? : " + ny + " " + nx);
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
