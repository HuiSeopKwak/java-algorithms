package algo.study2.week5;

import java.io.IOException;
import java.util.Scanner;
/**
 * 백준 1904 01타일
 * 메모리 : 21560 KB
 * 시간 : 180 ms
 *
 */
public class Boj1904 {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		dp[0] = 1; dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		System.out.println(dp[N] % 15746);
	}
}