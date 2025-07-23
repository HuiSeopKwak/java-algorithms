package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2630 색종이 자르기
 */

public class Boj2630 {
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝
        findSqure(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static private void findSqure(int startY, int startX, int size) {
        // 최소크기일땐 계산안하고 1 더해주고 끝
        if (size == 1) {
            if (map[startY][startX] == 1)
                blue++;
            else
                white++;
            return;
        }
        int color = map[startY][startX];
        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (color != map[i][j]) { // 한개라도 다른게 있다면 네개로 쪼개서 다시 탐색
                    findSqure(startY, startX, size/2);
                    findSqure(startY + size/2, startX, size/2);
                    findSqure(startY, startX + size/2, size/2);
                    findSqure(startY + size/2, startX + size/2, size/2);
                    return;
                }
            }
        }
        // 문제 없이 통과했다면 이 부분은 탐색 끝냄
        if (color == 1)
            blue++;
        else
            white++;
    }
}
