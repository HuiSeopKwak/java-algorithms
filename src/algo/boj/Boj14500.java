package algo.boj;
/**
 * 백준 14500 테트로미노
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    private static void dfs(int y, int x, int count, int sum) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                continue;

            if (!visited[ny][nx]) {
                if (count == 2) {
                    visited[ny][nx] = true;
                    dfs(y, x, count + 1, sum + map[ny][nx]);
                    visited[ny][nx] = false;
                }
                visited[ny][nx] = true;
                dfs(ny, nx, count + 1, sum + map[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }
}