package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2636 {
	static int R, C; // row, col 개수
	static int[][] cheeze; // 치즈 배열
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited; // 방문 확인 배열
	static int t, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 시작
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cheeze = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
				if (cheeze[i][j] == 1) count++;
			}
		}
		// 입력 끝

		bfs();
	}

	static void bfs() {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0, 0));
		visited = new boolean[R][C];
		visited[0][0] = true;

		int melted = 0; // 녹은 가장자리 치즈
		t++;

		while (!q.isEmpty()) {
			Loc p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.y + dy[i];
				int nc = p.x + dx[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc])
					continue;

				visited[nr][nc] = true;

				if (cheeze[nr][nc] == 0) {
					q.add(new Loc(nr, nc)); // 계속 탐색 진행
				} else {
					// 치즈가 녹음
					cheeze[nr][nc] = 0;
					melted++;
				}
			}
		}

		count -= melted;

		// 치즈가 다 녹았다면
		if (count == 0) {
			System.out.println(t);
			System.out.println(melted);
			return;
		} else {
			bfs();
		}
	}

	static class Loc {
		int y, x;

		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
