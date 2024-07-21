import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*****
 * 백준 11660 구간 함 구하기

*/
public class boj1749 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][] board = new int[n+1][m+1];		// 입력 받을 배열
		int [][] Sboard = new int[n+1][m+1];	// 누적합 배열
		
		// 배열 입력 받기
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 누적합 배열 만들기
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				Sboard[i][j] = Sboard[i][j-1] + Sboard[i-1][j] - Sboard[i-1][j-1] + board[i][j];
			}
		}
		// 부분 배열 최대합 구하기
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				Sboard[i][j] = Sboard[i][j-1] + Sboard[i-1][j] - Sboard[i-1][j-1] + board[i][j];
			}
		}
		
	}
}
