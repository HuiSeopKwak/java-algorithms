package algo.study2.week6;
/* 
* 백준 2343 기타 레슨
* 메모리 : 24004 KB
* 시간 : 300 ms
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2343 {
	static int N, M;
	static long left, right, mid;
	static int arr[];
	static long result = Long.MAX_VALUE;
	static long cnt, temp;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
		}
		// 입력 끝
		left = 1;
		while (left <= right) {
			mid = (left + right) / 2;
			cnt = 1; temp = 0;
			flag = true;
			for (int i = 0; i < N; i++) {
				if (mid < arr[i]) {	// 하나의 값이 블루레이보다 클때 
					left = mid + 1;
					flag = false;
					break;
				}
				if (cnt > M) {	// cnt값이 M개를 넘어섰을때 -> 더 큰값이 필요함
					left = mid + 1;
					break;
				}
				if (temp + arr[i] <= mid) {	// 지금까지 들어간 값이 원하는 블루레이 안에 들어올때
					temp += arr[i];
				}
				else {	// 넘었으면
					cnt++;
					temp = arr[i];
				}
			}
			if (flag == true) {
				if (cnt <= M) {	// cnt가 M보다 작으면거나 같으면 블루레이 크기를 작게해야함, 너무 크다는 뜻
					right = mid - 1;
					result = Math.min(result, mid);
				}
				if (cnt > M)
					left = mid + 1;
			}
		}
		System.out.println(result);
	}

}
