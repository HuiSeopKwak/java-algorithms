package algo.study2.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2304 {
	static int N;
	static wall[] arr;
	static int height, heightest;
	static int heightestIdx;
	static int result;
	
	public static class wall implements Comparable<wall> {
		int idx;
		int height;
		
		wall(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}

		@Override
		public int compareTo(wall o) {
			return this.idx - o.idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new wall[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new wall(a, b);
		}
		Arrays.sort(arr);
	
		for (int i = 0; i < N; i++) {
			if (heightest < arr[i].height) {
				heightest = arr[i].height;
				heightestIdx = i;
			}
		}
		
		height = arr[0].height;
		for (int i = 0; i < heightestIdx; i++) {
			if (height < arr[i + 1].height) {
				result += height * Math.abs(arr[i + 1].idx - arr[i].idx);
				height = arr[i+1].height;
			}
			else {
				result += height * Math.abs(arr[i + 1].idx - arr[i].idx);
			}
		}
		height = arr[N-1].height;
		for (int i = N-1; i > heightestIdx; i--) {
			if (height < arr[i - 1].height) {
				result += height * Math.abs(arr[i - 1].idx - arr[i].idx);
				height = arr[i-1].height;
			}
			else {
				result += height * Math.abs(arr[i - 1].idx - arr[i].idx);
			}
		}
		result += arr[heightestIdx].height;
		
		System.out.println(result);
	}

}
