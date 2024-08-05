package algo.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20922 {
//public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int[] cntArr = new int[100001];
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int p1 = 0;
		int p2 = 0;
		int idx = 0;
		int max = 0;
		int len = 0;
		
		while (p2 != N) {
			cntArr[arr[p2++]] += 1;
			if (cntArr[arr[p2-1]] <= K) {
				len = p2-p1;
				max = Math.max(max, len);
			}
			else {
				while(!(cntArr[arr[p2-1]] <= K)) {
					cntArr[p1++] -= 1;
				}
			}
			
		}
		System.out.println(max);
	}

}
