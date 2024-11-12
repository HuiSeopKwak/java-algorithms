package algo.study.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16234 {

    static int N, L, R;
    static int[][] map;
    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean flag;
    static boolean[][] visited;
    static int result;    // 총 병합 개수
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝

        result = 0;
        while (true) {
        	flag = true;
        	for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		bfs(i, j);
            	}
            }
        	if (flag == true)
        		break;
        	else
        		result++;
        }
        
        System.out.println(result);
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x, y});
        while(!que.isEmpty()) {
        	// 4방향 값을 비교할거임
        	for (int d = 0; d < 4; d++) {
        		int nx = x + dx[d];
        		int ny = y + dy[d];
        		// 유효범위 안이라면
        		if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
        			if (Math.abs(map[nx][ny] - map[x][y]) <= R && Math.abs(map[nx][ny] - map[x][y]) >= L) {	// 차이가 L 이상, R 이하라면
        				
        				
        			}
        		}
        	}
        }
        
        
    }
}