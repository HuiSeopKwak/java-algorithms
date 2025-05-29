package algo.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SteppingStones {

    static int n;
    static int[] stones;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        stones = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            stones[i] = Integer.parseInt(st.nextToken());
        // 입력 끝 로직 시작
        dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (stones[j] < stones[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++)
            result = Math.max(result, dp[i]);

        System.out.println(result);
    }
}
