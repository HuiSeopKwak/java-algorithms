package algo.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 	1260 백준 DFS와 BFS
 * 
 */

public class boj1260 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 정점의 개수
		int k = Integer.parseInt(st.nextToken());	// 간선의 개수
		int v = Integer.parseInt(st.nextToken());	// 정점의 번호
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		}

	}

}
