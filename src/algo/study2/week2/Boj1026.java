package algo.study2.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1026 보물
 * 메모리 : 14224 KB
 * 시간 : 104 ms
 *
 */
public class Boj1026 {
    
    static int N;
    static int[] A, B;
    static int sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[N];
        
        // 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) 
            A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) 
            B[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(B);
        Arrays.sort(A);
        
        for (int i = 0; i < N; i++) {
            sum += B[i] * A[N-i-1];
        }
        System.out.println(sum);
    }
}