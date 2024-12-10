package algo.salgoSwea;

import java.io.*;
import java.util.StringTokenizer;

public class Swea1210 {
    static int x, y;
    static int result = -1;
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            result = -1;
            st = new StringTokenizer(br.readLine());
            int tCase = Integer.parseInt(st.nextToken());
            for (int i = 1; i < 101; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < 101; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // y = 0, x값만 옮기면서 출발하는 위치별로 사다리 시작
            for (int i = 1; i < 101; i++) {
                if (map[1][i] == 1) {
                    y = 1; x = i;
                    find();
                }

                if (result != -1) {
                    System.out.println("#" + tCase + " " + (i - 1));
                    break;
                }
            }
        }
    }

    static void find() {
        while(true) {
            // 끝에 도착했다면
            if(y == 100) {
                if (map[y][x] == 2)
                    result = x;
                return;
            }
            y++;

            // 왼쪽에 1이 있다면
            if (x - 1 > 0 && map[y][x - 1] == 1) {
                moveLeft();
            }
            // 오른쪽에 1이
            else if (x + 1 < 101 && map[y][x + 1] == 1) {
                moveRight();
            }
        }
    }

    static void moveLeft() {
        while(true) {
            if (x - 1 > 0 && map[y][x - 1] == 1)
                x--;
            else
                return;
        }
    }

    static void moveRight() {
        while(true) {
            if (x + 1 < 101 && map[y][x + 1] == 1)
                x++;
            else
                return;
        }
    }
}