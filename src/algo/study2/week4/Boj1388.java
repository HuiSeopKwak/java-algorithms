package algo.study2.week4;

import java.io.BufferedReader;
/**
 * 백준 1388 바닥 장식
 * 메모리 : 14420 KB
 * 시간 : 104 ms
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1388 {
	static int N, M;	// 세로크기 N, 가로크기 M
	static char[][] map;	// 장판 배열
	static boolean[][] visited;
	static int cnt;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visited = new boolean[N][M];
        String str = "";
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	str = st.nextToken();
        	for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
        // 가로 점검
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '-' && !visited[i][j]) {
					// 방문 되지않았고 - 이면
					for (int k = j; k < M; k++) {
						if (map[i][k] == '-')
							visited[i][k] = true;
						else
							break;
					}
					cnt++;
				}
			}
		}
        // 세로 점검
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '|' && !visited[i][j]) {
					// 방문 되지 않았고 | 이면
					for (int k = i; k < N; k++) {
						if (map[k][j] == '|')
							visited[k][j] = true;
						else
							break;
					}
					cnt++;
				}
			}
		}
        System.out.println(cnt);
        // 
//      for (int i = 0; i < N; i++) {
//        	for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

	}

}
