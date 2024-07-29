package algo.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/***
 * 1325 효율적인 해킹
 * 
 */
public class boj1325 {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]); 	// N은 컴퓨터 개수
		M = Integer.parseInt(str[1]); 	// M은 간선의 개수
		int a, b;

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {	// list에 arraylist 배열 할당
			list[i] = new ArrayList<>(); 	
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			a = Integer.parseInt(str[0]); 	// N은 컴퓨터 개수
			b = Integer.parseInt(str[1]); 	// M은 간선의 개수
			list[a].add(b);
		}
		// 입출력 끝.... 자바 입출력... :(
		
		bfs();		
	}

	public static void bfs() {

	}

}

//arr = new List[n + 1];
//result = new int[n + 1];
//visit = new boolean[n + 1];
//
//for (int i = 1; i <= n; i++) {
//    arr[i] = new ArrayList<>();		// 인접 리스트 초기화
//}
//for (int i = 0; i < m; i++) {
//    int s = sc.nextInt();	// 시작 노드
//    int e = sc.nextInt();	// 종료 노드
//    arr[s].add(e);
//}
//for (int i = 1; i <= n; i++) {
//    visit = new boolean[n + 1];
//    BFS(i);
//}
//int big = 0;
//for (int i = 1; i <= n; i++) {
//    big = Math.max(big, result[i]);		// 최대값 탐색
//}
//for (int i = 1; i <= n; i++) {
//    if (result[i] == big) {		// 최대값과 같다면 인덱스 출력
//        System.out.print(i + " ");
//    }
//}
//
//}
//public static void BFS(int n) {
//Queue<Integer> q = new LinkedList<>();
//q.add(n);
//visit[n] = true;
//while (!q.isEmpty()) {		// 큐가 비어있을 때까지
//    int num = q.poll();
//    for (int i : arr[num]) {
//        if (visit[i] == false) {	// 방문하지 않은 노드가 나왔을 경우
//            result[i]++;
//            visit[i] = true;
//            q.add(i);
//        }
//    }
//}
//}