package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 2206 벽 부수고 이동하기
 */
public class Boj2206 {
    static int N, M;
    static int[][] map;
    // 벽을 부순경우와 안 부순 경우의 방문을 따로 체크하기 위해 3차원으로 선언
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        // 입력 끝

        System.out.println(bfs());

    }
    static private int bfs() {
        // 벽을 안부순 경우의 visited: [][][0], 벽을 부순 경우의 visited: [][][1]
        visited = new boolean[N + 1][M + 1][2];
        Deque<int[]> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offer(new int[] {0, 0, 0, 1}); // y좌표, x좌표, 벽 부순 여부, 거리(dist)

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], broken = cur[2], dist = cur[3];

            // 목적지 도착시 리턴
            if (y == N - 1 && x == M - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                // 범위 벗어나면 넘김
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                // 벽이 아니고 방문되지 않았다면
                if (map[ny][nx] == 0 && !visited[ny][nx][broken]) {
                    visited[ny][nx][broken] = true;
                    q.offer(new int[] {ny, nx, broken, dist + 1});
                }
                // 벽이 있고, 한번도 벽을 부수지 않은 상태였다면 벽을 부수고 이동
                else if (map[ny][nx] == 1 && broken == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    q.offer(new int[] {ny, nx, 1, dist + 1});
                }
            }
        }
        return -1;
    }
}
