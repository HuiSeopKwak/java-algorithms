package algo.study2.week6;
/**
 * 백준 2467 용액
 * 메모리 : 28832 KB
 * 시간 : 324 ms
 * 풀이 : 투포인터
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2467 {
	static int N;
	static int[] arr;
	static int p1, p2, minV1, minV2;
	static int minValue = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		
		// 투포인터로 탐색
		p1 = 0;
		p2 = N-1;
		
		while(p1 < p2) {
			if (minValue > Math.abs(arr[p1] + arr[p2])) {	// 최소값보다 작을때 최소값, 그때 값 저장 
				minValue = Math.abs(arr[p1] + arr[p2]);
				minV1 = arr[p1];
				minV2 = arr[p2];
			}
			
			if (arr[p2] + arr[p1] > 0) 	// 둘이 더한 값이 0 보다 크면 큰값을 낮춰야함(오른쪽값)
				p2 = p2-1;
			else 
				p1 = p1+1;
		}
		System.out.println(minV1 + " " + minV2);
	}
}
