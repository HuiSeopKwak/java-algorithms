package algo.study2.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2468 안전 영역
 * 메모리 : 18732 KB
 * 시간 : 208 ms
 */
public class Boj2468 {
	static int N; // 배열 크기
	static int map[][]; // 높이 맵
	static boolean visited[][]; // 방문 처리 배열
	static int maxSafe = Integer.MIN_VALUE; // 안전지역 최대값 저장
	static int cnt;
	static int maxHeight = Integer.MIN_VALUE; // 최대 높이 저장용
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		// 입력 끝

		// 높이 별로 안정장판 갯수 체크
		for (int k = 0; k < maxHeight; k++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > k) { // 방문되지 않았고 and 물높이 보다 높을때
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			maxSafe = Math.max(maxSafe, cnt);
		}
		System.out.println(maxSafe);
	}

	static void dfs(int y, int x, int height) {	
		// 범위탐색하고 visited 되지 않고 && 높이가 높으면 탐색 쭉쭉 + 방문처리
		for (int i = 0; i < 4; i++) {
			int ry = y + dy[i];
			int rx = x + dx[i];
			if (ry >= 0 && rx >= 0 && ry < N && rx < N && !visited[ry][rx] && map[ry][rx] > height) {
				visited[ry][rx] = true;
				dfs(ry, rx, height);
			}
		}

	}
}
