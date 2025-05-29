package algo.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NamuAttack {
    static int n,m;
    static int[][] map;
    static int[] attack = new int[2];
    static int goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 맵 입력 끝

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            attack[0] = Integer.parseInt(st.nextToken());
            attack[1] = Integer.parseInt(st.nextToken());

            attackTarget(attack[0], attack[1]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                System.out.print(map[i][j] + " ");
                if (map[i][j] == 1) {
                    goal++;
                }
            }
            System.out.println();
        }
        System.out.println(goal);
    }
    static public void attackTarget(int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 그 줄에 환경파괴범이 있을때 환경파괴범 없애고 다음줄로 넘어가기
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    break;
                }
            }
        }
    }
}
