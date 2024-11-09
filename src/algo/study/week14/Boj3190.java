package algo.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj3190 {
    
    static int N, K, L;    // N*N 맵, K 사과의 개수, L 방향 변환 개수
    static int map[][];    // 맵
    static int Ltime[];    // 방향 전환 시간 
    static String Lway[];    // 방향 바꾸는 위치
    static int[] dr = {0, 1, 0, -1};    // 오른, 아래, 왼, 위
    static int[] dc = {1, 0, -1, 0};
    static List<int[]> snake = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        // 사과있는 곳은 2
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 2; 
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        Ltime = new int[L];
        Lway = new String[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            Ltime[i] = Integer.parseInt(st.nextToken());
            Lway[i] = st.nextToken();
        }
        // 입력 끝
        
        int d = 0;    // 바라보는 방향
        int idx = 0;// 턴
        int tidx = 0; // 방향 전환용 idx 체크
        int nr = 0;
        int nc = 0;
        snake.add(new int[] {nr, nc});
        while(true) {
            idx++;
            nr = nr + dr[d];
            nc = nc + dc[d];
            // 정상범위라면
            if (nc >= 0 && nr >= 0 && nc < N && nr < N) {
                // 자리 몸이랑 부딪히면 끝
                for (int[] a : snake) {
                    if (a[0] == nr && a[1] == nc) {
                        System.out.println(idx);
                        return;
                    }
                }
                // 사과 없음
                if (map[nr][nc] == 0) {
                    snake.add(new int[] {nr, nc});
                    snake.remove(0);
                }
                // 사과 있음
                else {
                    map[nr][nc] = 0;
                    snake.add(new int[] {nr, nc});
                }
                // 방향 전환해야되면 하는 부분
                // 시간이 되었다면 
                if (tidx < L && idx == Ltime[tidx]) {
                    if (Lway[tidx].equals("L")) {
                        d = (d + 3) % 4;
                    }
                    else {
                        d = (d + 1) % 4;
                    }
                    tidx++;
                }
            }
            else
                break;
        }
        System.out.println(idx);

    }
}