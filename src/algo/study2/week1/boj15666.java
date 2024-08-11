package algo.study2.week1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class boj15666 {
//public class Main {
	static int N, M;
	static Stack<Integer> que = new Stack<Integer>();
	static int arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		recur(0);
	}
	
	static void recur(int idx) {
		if (idx == M) {
			for (int num : que) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if (!que.isEmpty() && i <= que.peek())
				continue;
			
			que.add(i);
			recur(idx+1);
			que.pop();
		}
	}
}