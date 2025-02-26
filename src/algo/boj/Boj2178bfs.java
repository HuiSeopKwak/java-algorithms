package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178bfs {
    static int N, M;
    static int map[][];
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int dist[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        // 입력 끝

        // BFS
        bfs(1, 1);

        System.out.println(dist[N][M]);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});
        dist[y][x] = 1;

        // que가 비지 않을때 까지 반복
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for (int d = 0; d < 4; d++) {
                int ny = temp[0] + dy[d];
                int nx = temp[1] + dx[d];
                if (ny > 0 && nx > 0 && ny <= N && nx <= M && !visited[ny][nx] && map[ny][nx] == 1) {
                    que.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[temp[0]][temp[1]] + 1;
                }
            }
        }
    }
}