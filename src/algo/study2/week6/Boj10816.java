package algo.study2.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드 2
 * 메모리 : 124208 KB
 * 시간 : 1356 ms
 */

public class Boj10816 {
	static int N, M;
	static int cards[];
	static int finds[];
	static int start, end, mid;
	static int ub, lb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		finds = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			finds[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝 
		// 카드 정렬
		Arrays.sort(cards);
		// lower bound, upper bound 로 시작 위치, 끝 위치 찾기
		// 1~M 까지 반복
		for (int i = 0; i < M; i++) {
			// upper bound
			start = 0;
			end = N;
			while(start < end) {
				mid = (start + end) / 2;
				if (cards[mid] > finds[i]) 	// 찾는 값 보다 작으면
					end = mid;
				else
					start = mid + 1;
			}
			ub = start;
//			System.out.println(start);
			
			// lower bound
			start = 0;
			end = N;
			while (start < end) {
				mid = (start + end) / 2;
				if (cards[mid] >= finds[i])
					end = mid;
				else
					start = mid + 1;
			}
			lb = start;
//			System.out.println(start);
			sb.append(ub - lb).append(" ");
		}
		System.out.println(sb);
	}

}
