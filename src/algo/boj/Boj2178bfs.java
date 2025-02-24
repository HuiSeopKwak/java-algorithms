package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// dfs 시간 초과 코드
public class Boj2178bfs {
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

        // BFS
        bfs(1, 1);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});


    }
}