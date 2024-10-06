package algo.study.week10;
/**
 * 백준 9663 N-Queen 
 * 메모리 : 15488 KB
 * 시간 : 6172 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9663 {
    static int N;
    static int[] queens;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        queens = new int[N];
        // 입력 끝
        
        // 탐색 시작
        check(0);

        System.out.println(cnt);
    }
    
    public static void check(int depth) {
        // depth가 N이면 탐색 끝
        if (depth == N) {
            cnt++;
            return;
        }
        
        // 깊이에서 넣을 수 있는 부분들에 대해 확인하고 재귀호출함
        for (int i = 0; i < N; i++) {
            queens[depth] = i;    
            if (possible(depth)) {    // 유효할때만 다음으로
                check(depth + 1);
            }
        }
    }
    
    public static boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (queens[i] == queens[depth]) // 같은 열에 있으면 실패    
                return false;
        }
        for (int i = 0; i < depth; i++) {
            if (Math.abs(depth - i) == Math.abs(queens[depth] - queens[i]))    // 대각선 위치에 있다면
                return false;
        }
        return true;
    }
}