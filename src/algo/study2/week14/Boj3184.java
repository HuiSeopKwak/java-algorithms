package algo.study2.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 백준 3184 양
 * 메모리 : 19448 KB
 * 시간 : 176ms
 */
public class Boj3184 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int totalWolf, totalSheep;
	static int[] dr = { 1, 0, -1, 0};
	static int[] dc = { 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       	R = Integer.parseInt(st.nextToken());
       	C = Integer.parseInt(st.nextToken());
       	
       	map = new char[R][C];
       	visited = new boolean[R][C];
       	
       	for (int i = 0; i < R; i++) {
       		String line = br.readLine();
       		for (int j = 0; j < C; j++) {
       			map[i][j] = line.charAt(j);
       		}
       	}
       	// 입력 끝
       	for (int i = 0; i < R; i++) {
       		for (int j = 0; j < C; j++) {
       			if (!visited[i][j] && map[i][j] != '#') {
       				check(i, j);
       			}
       		}
       	}
       	System.out.println(totalSheep + " " + totalWolf);
	}
	
	public static void check(int r, int c) {
		int wolf = 0;
		int sheep = 0;
		Queue<int[]> que = new LinkedList<>();
		visited[r][c] = true;
		que.add(new int[] { r, c });
		
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			if (map[loc[0]][loc[1]] == 'v') 
				wolf += 1;
			if (map[loc[0]][loc[1]] == 'o') 
				sheep += 1;
			
			for (int d = 0; d < 4; d++) {
				int nr = loc[0] + dr[d];
				int nc = loc[1] + dc[d];
				// 정상범위 + 벽이 아닐때 que에 추가
				if (nc >= 0 && nr >= 0 && nc < C && nr < R && map[nr][nc] != '#' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.add(new int[] {nr, nc});
				}
			}
		}
		// 아무도 없으면 return
		if (sheep == 0 && wolf == 0)
			return;
		// 있으면 계산하여 남은 마리 추가
		if (sheep > wolf) 
			totalSheep += sheep;
		else
			totalWolf += wolf;
	}
}
