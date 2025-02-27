package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2667 {
    static int size;
    static int map[][];
    static List<Integer> result = new ArrayList<>();
    static int totalHouses = 1;
    static int houseCounts = 0;
    static boolean visited[][];
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        // 입력 끝

        // bfs로 0, 0의 자리부터 탐색
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                // 집이 있어야하고, visited 된곳은 방문 X
                if (map[y][x] == 1 && !visited[y][x]) {
                    bfs(y, x);
                    totalHouses++;
                }
            }
        }

        System.out.println(totalHouses - 1);
        Collections.sort(result);
        for (int i : result)
            System.out.println(i);
    }

    public static void bfs(int y, int x) {
        Queue<int []> que = new LinkedList<>();
        que.add(new int[] {y, x});
        visited[y][x] = true;
        houseCounts = 1;

        while(!que.isEmpty()) {
            int[] temp = que.poll();
            for (int d = 0; d < 4; d++) {
                int ny = temp[0] + dy[d];
                int nx = temp[1] + dx[d];
                if (ny >= 0 && nx >= 0 && ny < size && nx < size && map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    houseCounts++;
                    que.add(new int[] {ny, nx});
                }
            }
        }
        result.add(houseCounts);
    }
}
