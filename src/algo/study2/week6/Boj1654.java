package algo.study2.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1654 랜선 자르기
 * 메모리 : 18284 KB
 * 시간 : 184 ms
 */

public class Boj1654 {
	static int N, K;	// K: 가지고 있는 랜선 개수, N: 필요한 랜선 개수
	static int[] len;	// 길이 저장 배열 
	static int maxLen = -1;	// 가장 긴 랜선의 길이 저장용
	static long sum;		// 만드는 랜선 개수 저장용
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		len = new int[K];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			len[i] = Integer.parseInt(st.nextToken());
			maxLen = Math.max(maxLen, len[i]);
		}
		// 입력 끝
		
		// 이분탐색으로 최대 길이,최소길이를 기준으로 돌면서 필요한 랜선 개수를 충족하는 가장 긴 길이를 찾는다.
		long start = 1;
		long end = maxLen;
		long mid = (start + end) / 2;
		result = mid;
		// 탐색 시작
		while (start <= end) {
			sum = 0;
			mid = (start + end) / 2;
//			System.out.println(mid);
			for (int i = 0; i < K; i++) {
				sum += len[i] / mid;
			}
			if (sum >= N) {
				result = mid;
				start = mid + 1;
			}
			else 
				end = mid - 1;
			
		}
		System.out.println(result);
	}

}
