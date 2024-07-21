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
		int [][] board = new int[n][m];		// 입력 받을 배열
		int [][] Sboard = new int[n][m];	// 누적합 배열
		
		// 배열 입력 받기기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				Sboard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
