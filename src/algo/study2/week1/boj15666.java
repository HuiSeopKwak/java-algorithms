package algo.study2.week1;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class boj15666 {
//public class Main {
	static int N, M;
	static Stack<Integer> que = new Stack<Integer>();
	static int arr[];
	static Set<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		recur(0);
		
		for (String str : set) {
			System.out.println(str);
		}
	}
	
	static void recur(int idx) {
		if (idx == M) {
			String str = "";
			for (int num : que) {
				str = str + num + " ";
			}
			set.add(str);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!que.isEmpty() && arr[i] < que.peek())
				continue;
			
			que.add(arr[i]);
			recur(idx+1);
			que.pop();
		}
	}
}