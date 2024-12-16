package algo.salgoBoj;

import java.util.Scanner;

public class Boj1074 {
    static int N, r, c, size;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        size = (int) Math.pow(2, N);

        cnt = 0;
        find(size, r, c);
        System.out.println(cnt);
    }

    static void find(int size, int r, int c) {
        // 위치 찾으면 return
        if (size == 1)
            return;
        // r, c가 현재 사이즈 기준 2사분면에 있을때
        if (size/2 > r && size/2 > c) {
            find(size / 2, r, c);
        }
        // r, c가 현재 사이즈 기분 1사분면에 있을때
        else if (size/2 > r && size/2 <= c) {
            cnt += (size * size) / 4;
            find(size / 2, r, c - (size/2));
        }
        // r, c가 현재 사이즈 기분 3사분면에 있을때
        else if (size/2 <= r && size/2 > c) {
            cnt += ((size * size) / 4) * 2;
            find(size / 2, r - (size/2), c);
        }
        // r, c가 현재 사이즈 기분 4사분면에 있을때
        else if (size/2 <= r && size/2 <= c) {
            cnt += ((size * size) / 4) * 3;
            find(size / 2, r - (size/2), c - (size/2));
        }
    }
}
