package algo.salgoSwea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea5215 {
    static int tc;
    static int N, L;
    static int[] T, K;
    static int maxTaste;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tc = Integer.parseInt(st.nextToken());

        for (int tCase = 1; tCase <= tc; tCase++) { // 조건 수정
            maxTaste = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            T = new int[N];
            K = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            check(0, 0, 0);
            System.out.println("#" + tCase + " " + maxTaste);
        }
    }

    static void check(int taste, int cal, int idx) {
        if (idx == N) {
            if (cal <= L && maxTaste < taste)
                maxTaste = taste;
            return;
        }
        check(taste + T[idx], cal + K[idx], idx + 1);
        check(taste, cal, idx + 1);
    }
}
