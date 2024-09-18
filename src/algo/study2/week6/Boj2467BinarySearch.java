package algo.study2.week6;
/**
 * 백준 2467 용액
 * 메모리 : 28624 KB
 * 시간 : 348 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2467BinarySearch {
	static int N;
	static int[] arr;
	static int left, right, mid, sum, minV1, minV2;
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
		
		// 이분탐색으로 풀기
		for (int i = 0; i < N; i++) {
			left = i + 1;
			right = N - 1;
			
			while(left <= right) {
				mid = (left + right) / 2;
				sum = Math.abs(arr[i] + arr[mid]);
				
				if (sum < minValue) {	// 작을때 값 초기화
					minV1 = arr[i];
					minV2 = arr[mid];
					minValue = sum;
				}
				if (arr[mid] <= -arr[i]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		System.out.println(minV1 + " " + minV2);
	}
}
