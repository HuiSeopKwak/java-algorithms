package algo.study2.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 2003 수들의 합 2
 * 메모리 : 14920 KB
 * 시간 : 132 ms
 */
public class Boj2003 {
	static int N, M;
	static int arr[];
	static int p1, p2, sum;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N > 1) {
			p1 = 0; p2 = 0;
			sum = arr[p1];
			while (p2 < N) {	
				if (sum == M) {	// 지금까지 합이 M과 같을때
					count++;
				}
				if (sum <= M) {	// 합이 M보다 작으면 오른쪽으로 늘려줌
					if (p2 == N-1)
						break;
					sum += arr[++p2];
				}
				else {	// 합이 M보다 커지면 왼쪽을 줄여준다.
					sum -= arr[p1++];
				}
				
			}
			System.out.println(count);
		}
		else {	// N이 1일때
			if (arr[0] == M)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

}
