package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// dfs 시간 초과 코드
public class Boj2178dfs {
    static int N, M;
    static int minMove = Integer.MAX_VALUE;
    static int map[][];
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        // 입력 끝

        // DFS
        findNM(1, 1, 1);

        System.out.println(minMove);
    }

    public static void findNM(int y, int x, int move) {
        // 마지막에 도착하면 최소 움직임수 갱신 후 return
        if (y == N && x == M) {
            minMove = Math.min(minMove, move);
            return;
        }
        // 4방향 가능 경로 탐색 후 함수 호출
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 가려는 방향이 필드 내의 위치일때
            if (ny > 0 && ny <= N && nx > 0 && nx <= M && !visited[ny][nx]) {
                // 갈 수 있는 길일때
                if (map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    findNM(ny, nx, move + 1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}