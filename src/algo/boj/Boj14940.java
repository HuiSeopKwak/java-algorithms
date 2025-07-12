package algo.boj;
/**
 * 백준 14940 쉬운 최단거리
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940 {
    static int[][] map;
    static int[][] result;
    static int[] target;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    target = new int[] {i, j};
                }
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }
        // 입력 끝

        Queue<int[]> q = new LinkedList<>();
        q.add(target);
        result[target[0]][target[1]] = 0;
        visited[target[0]][target[1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if (nx >= 0 && ny >= 0 && ny < n && nx < m && !visited[ny][nx]) {
                    result[ny][nx] = result[cur[0]][cur[1]] + 1;
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}