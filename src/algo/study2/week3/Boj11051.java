package algo.study2.week3;

import java.util.Scanner;
/**
 * 백준 11051 이항 계수 2
 * 메모리 : 21524 KB
 * 시간 : 180 ms
 *
 */
public class Boj11051 {
	static int N, K;	// n개의 숫자에서 k개 뽑기
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int[N+1][N+1];
		
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (i == j || j == 0)	// nCn or nCo
					dp[i][j] = 1;
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		System.out.println(dp[N][K] % 10007);
	}
}