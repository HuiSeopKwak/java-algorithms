package algo.salgoBoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 {
    static int n;
    static int[][] maps;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        maps = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (n == 1) {
            System.out.println(maps[1][1]);
            return;
        }

        // 각 라인별 최대값 구하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i + 1; j++) {
                maps[i][j] = Math.max(maps[i-1][j], maps[i-1][j-1]) + maps[i][j];
            }
        }

        // 가장 큰 값 찾기
        for (int num : maps[n]) {
            if (result < num)
                result = num;
        }
        System.out.println(result);
    }
}
