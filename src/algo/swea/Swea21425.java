package algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea21425 {
	static int T;
	static int A, B, N;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
        	cnt = 0;
        	st = new StringTokenizer(br.readLine());
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	
        	// 둘다 N 보다 작을때까지만 반복
        	while (A <= N && B <= N) {
        		if (A >= B) {
        			B += A;
        		}
        		else {
        			A += B;
        		}
        		cnt++;
        	}
        	sb.append(cnt + "\n");
        }
		
		System.out.println(sb);
	}

}
