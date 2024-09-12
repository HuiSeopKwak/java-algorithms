package algo.study2.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 12865 평범한 배낭
 * 메모리 : 58016 KB
 * 시간 : 244 ms
 */
public class Boj12865 {
    static int N, K;
    static int[][] dp, arr;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new int[N][100001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());    // idx
            arr[i][1] = Integer.parseInt(st.nextToken());    // weight
        }
        // 입력끝
        
        // dp배열 -1로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 100001; j++) {
                dp[i][j] = -1;
            }
        }
        ans = recur(0, 0);
        System.out.println(ans);
    }
    
    static int recur(int idx, int weight) {
    	// 무게가 기준값 올라가면 유효 X
        if (weight > K)
            return -999999;
        // 탐색 끝일때 return
        if (idx == N) 
            return 0;
        // 이미 탐색한 곳에 대해선 탐색 X
        if (dp[idx][weight] != -1)
            return dp[idx][weight];
        
        dp[idx][weight] = Math.max(recur(idx + 1, weight + arr[idx][0]) + arr[idx][1], recur(idx+1, weight));
        
        return dp[idx][weight];
    }
}